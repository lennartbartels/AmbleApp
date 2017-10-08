package amble.main;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.bartelsl.photowalk.Home;
import com.example.bartelsl.photowalk.R;
import com.example.bartelsl.photowalk.Register;

import amble.model.User;
import amble.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText username = (EditText) findViewById(R.id.etUsername);
        final EditText lastname = (EditText) findViewById(R.id.etLastname);
        final EditText emailadress = (EditText) findViewById(R.id.etEmailAdress);
        final EditText firstname = (EditText) findViewById(R.id.etFirstname);
        final EditText password = (EditText) findViewById(R.id.etPassword);

        Button registerBtn = (Button) findViewById(R.id.btnRegister);
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

                sendNetworkRequest(user);

            }


            private void sendNetworkRequest(User user) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                UserClient client = retrofit.create(UserClient.class);
                Call<User> call = client.createAccount(user);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(MainActivity.this, "Yeah! You're registered - User-ID:" + response.body().getId(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Oops: Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
