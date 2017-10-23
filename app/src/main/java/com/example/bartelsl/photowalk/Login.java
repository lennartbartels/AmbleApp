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

import amble.main.RestClient;
import amble.model.Credentials;
import amble.model.User;
import amble.service.SessionClient;
import amble.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Activity {

    UserClient userClient;
    SessionClient sessionClient;
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
        userClient = RestClient.getUserClient();
        sessionClient = RestClient.getSessionClient();
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
                String username = loginName.getText().toString().trim();
                String password = Login.this.password.getText().toString().trim();
                if (!Objects.equals(username, "") && !Objects.equals(password, "")) {
                    sendNetworkrequest(username, password);
                }

            }
        });
    }

    private void sendNetworkrequest(String username, String password) {
        //UserClient client = userClient.getUserClient();
        Credentials credentials = new Credentials ();
        credentials.setPassword(password);
        credentials.setUsername(username);
        Call<String> loginCall = sessionClient.login(credentials);
        loginCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {


                    RestClient.setToken(response.body());
                    Toast.makeText(Login.this, "Login successful.", Toast.LENGTH_SHORT).show();
                    Intent moveToRegister = new Intent(Login.this, Home.class);
                    startActivity(moveToRegister);


                }


            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast toast = Toast.makeText(Login.this,"Login failed .", Toast.LENGTH_SHORT);
                toast.show();
            }


        });
    }

    private void initRestClient(){
        RestClient.init();
    }
}
