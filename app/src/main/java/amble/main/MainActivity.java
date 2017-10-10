package amble.main;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.example.bartelsl.photowalk.R;

import amble.model.User;
import amble.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.R.attr.password;

// Main Activity beschreibt den Registrierungsprozess und die versendung an den Server der Daten
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "localhost:8080/api/";
    private static Retrofit retrofit = null;

    private EditText username;
    private EditText lastname;
    private EditText firstname;
    private EditText emailadress;
    private EditText password;

    private Button registerBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void main(String args[]) {
        RestClient restclient = new RestClient("null");
        UserClient userClient = restclient.getUserClient();
        Call<User> lilly = userClient.getUserByUsername("Lilly");
        lilly.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.body());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("das war wohl nix");

            }
        });

        username = (EditText) findViewById(R.id.etUsername);
        lastname = (EditText) findViewById(R.id.etLastname);
        emailadress = (EditText) findViewById(R.id.etEmailAdress);
        firstname = (EditText) findViewById(R.id.etFirstname);
        password = (EditText) findViewById(R.id.etPassword);

        registerBtn = (Button) findViewById(R.id.btnRegister);
        registerBtn.setOnClickListener(this);
    }


    public void onClick(View view) {
        User user = new User(
                username.getText().toString(),
                lastname.getText().toString(),
                emailadress.getText().toString(),
                firstname.getText().toString(),
                password.getText().toString()
        );

        sendNetworkrequest(user);
    }


    private void sendNetworkrequest(User user) {

        Call<Void> accountcall = userClient.createAccount(user);
        accountcall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast toast = Toast.makeText(MainActivity.this,"Yeah", Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast toast = Toast.makeText(MainActivity.this,"Oh no!", Toast.LENGTH_SHORT);
            }


        });
    }
}


          /*  @Override
            public void onResponse(Call<User> call, Response<Void> response) {
                Toast toast = Toast.makeText(MainActivity.this,"Yeah", Toast.LENGTH_SHORT);
                        toast.show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
           @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                System.out.println("erstellt");
            }


            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("nicht erstellt");


        ;}


*/

            /*    UserClient client = retrofit.create(UserClient.class);
                Call<User> call = client.createAccount(user);

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(MainActivity.this, "Yeah! You're registered", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Oops: Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }

} */






