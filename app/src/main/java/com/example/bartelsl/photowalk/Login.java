package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import amble.main.MainActivity;
import amble.main.RestClient;
import amble.model.User;
import amble.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Activity {

    UserClient retrofit;

    TextView registerHere;
    Button signInBtn;
    EditText loginName;
    EditText password;
    Button button;//*******************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //entfernt title bar
        setContentView(R.layout.activity_login);
        // Initialize Rest Client for later usage.
        initRestClient();
        retrofit = RestClient.getUserClient();
        loginName = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);

        registerHere = (TextView) findViewById(R.id.tvRegsiterHere);
        signInBtn = (Button) findViewById(R.id.btnSignIn);
        button = (Button) findViewById(R.id.button);//***********************************************

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Login.this, Register.class);
                startActivity(moveToRegister);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {//************************************
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Login.this, Home.class);
                startActivity(moveToRegister);
            }
        });//***************************************************************************************

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = loginName.getText().toString().trim();
                String passw = password.getText().toString().trim();
                if (!Objects.equals(name, "") && !Objects.equals(passw, "")) {
                    sendNetworkrequest(name, passw);
                }

            }
        });
    }

    private void sendNetworkrequest(String usrName, String passwrd) {
        //UserClient client = retrofit.getUserClient();
        Call<User> accountcall = retrofit.getUserByUsername(usrName);
        accountcall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User usr = response.body();
                if (usr != null && usr.getPassword().equals(password)) {
                    RestClient.setCurrentUser(usr);
                    Toast.makeText(Login.this, "Login successful.", Toast.LENGTH_SHORT).show();
                    Intent moveToRegister = new Intent(Login.this, Home.class);
                    startActivity(moveToRegister);
                } else {
                    Toast toast = Toast.makeText(Login.this,"Login failed.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast toast = Toast.makeText(Login.this,"Login failed completely.", Toast.LENGTH_SHORT);
                toast.show();
            }


        });
    }

    private void initRestClient(){
        RestClient.init();
    }
}
