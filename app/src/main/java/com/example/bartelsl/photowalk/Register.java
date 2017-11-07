package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import amble.exceptions.NotRegisteredException;
import amble.main.MainActivity;
import amble.main.RestClient;
import amble.model.Credentials;
import amble.model.SessionDto;
import amble.model.User;
import amble.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;

public class Register extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner selectRole;
    ArrayAdapter adapter;
    //private static final String TAG = Register.class.getSimpleName();

    UserClient retrofit =RestClient.getUserClient();

    EditText username;
    EditText lastname;
    EditText firstname;
    EditText emailadress;
    EditText password;

    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //entfernt title bar
        setContentView(R.layout.activity_register);


        adapter = ArrayAdapter.createFromResource(this, R.array.role, android.R.layout.simple_spinner_item);

        selectRole = (Spinner) findViewById(R.id.spnSelectRole);
        selectRole.setAdapter(adapter);
        selectRole.setOnItemSelectedListener(Register.this);

        username = (EditText) findViewById(R.id.etUsername);
        lastname = (EditText) findViewById(R.id.etLastname);
        emailadress = (EditText) findViewById(R.id.etEmailAdress);
        firstname = (EditText) findViewById(R.id.etFirstname);
        password = (EditText) findViewById(R.id.etPassword);

        registerBtn = (Button) findViewById(R.id.btnRegister);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(
                        username.getText().toString(),
                        lastname.getText().toString(),
                        emailadress.getText().toString(),
                        firstname.getText().toString(),
                        password.getText().toString()
                );

                sendNetworkrequest(user);
                //Intent moveToRegister = new Intent(Register.this, Home.class);
                //startActivity(moveToRegister);
            }
        });
    }

    private void sendNetworkrequest(User user) {
        //UserClient client = userClient.getUserClient();
        Call<Void> accountcall = retrofit.createAccount(user);
        accountcall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Credentials credentials = new Credentials ();
                credentials.setPassword(user.getPassword());
                credentials.setUsername(user.getUsername());
                Call<SessionDto> loginCall = RestClient.getSessionClient().login(credentials);
                loginCall.enqueue(new Callback<SessionDto>() {
                    @Override
                    public void onResponse(Call<SessionDto> call, Response<SessionDto> response) {

                        Toast.makeText(Register.this, "register successful.", Toast.LENGTH_SHORT).show();
                        Intent moveToRegister = new Intent(Register.this, Home.class);
                        startActivity(moveToRegister);


                    }


                    @Override
                    public void onFailure(Call<SessionDto> call, Throwable t) {
                        Toast toast = Toast.makeText(Register.this,"register failed .", Toast.LENGTH_SHORT);
                        toast.show();
                    }


                });

                /*
                String token = RestClient.getToken();
                if (token == null ){throw new NotRegisteredException();}
                retrofit.getUserByUsername(user.getUsername(),token).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User usr = response.body();
                        if (usr != null) {
                            Toast.makeText(Register.this, "success user:" + response.body().getUsername(), Toast.LENGTH_SHORT).show();
                            RestClient.setCurrentUser(usr);
                            Intent moveToRegister = new Intent(Register.this, Home.class);
                            startActivity(moveToRegister);
                        } else {
                            Toast.makeText(Register.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Toast.makeText(Register.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                    }
                });*/

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast toast = Toast.makeText(Register.this,"Registration failed completely.", Toast.LENGTH_SHORT);
                toast.show();
            }


        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView selectRoleText = (TextView) view;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
