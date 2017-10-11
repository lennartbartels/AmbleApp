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
import retrofit2.http.Body;
import retrofit2.http.Path;

import static android.R.attr.password;

// Main Activity beschreibt den Registrierungsprozess und die versendung an den Server der Daten
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void onClick(View view) {

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






