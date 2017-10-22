package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import amble.main.RestClient;
import amble.model.Photowalk;
import amble.model.User;
import amble.service.PhotowalkApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bartelsl.photowalk.R.id.lvWalks;
import static com.example.bartelsl.photowalk.R.id.parent;
import static java.util.Collections.addAll;

public class Home extends Activity {

    //ListView WalkListe
    Button CreateWalkBtn;
    Button Walk1Btn;
    Button LogoutBtn;
    ListView lvWalks;
    PhotowalkApiService retrofit;
    private Object Response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Call<List<Photowalk>> call = retrofit.getPhotowalks();
        call.enqueue(new Callback<List<Photowalk>>() {
            @Override
            public void onResponse(Call<List<Photowalk>> call, Response<List<Photowalk>> response) {
                List<Photowalk> walks = response.body();
                lvWalks = (ListView) findViewById(R.id.lvWalks);
                ListAdapter adapter = new ArrayAdapter<Photowalk>(Home.this, android.R.layout.simple_list_item_1, walks);
                lvWalks.setAdapter(adapter);


                }

            @Override
            public void onFailure(Call<List<Photowalk>> call, Throwable t) {

            }



            });
       /* String[] walks = {"Walk 1", "Walk 2", "Walk 3", "..."}; //nur Beispiel, damit etwas angezeigt wird!
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, walks);
        ListView lvWalks = (ListView) findViewById(lvWalks);
        lvWalks.setAdapter(adapter);
*/


        CreateWalkBtn = (Button) findViewById(R.id.btnCreateWalk);
        Walk1Btn = (Button) findViewById(R.id.btnWalk1);
        LogoutBtn = (Button) findViewById(R.id.btnLogout);



        CreateWalkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, CreateWalk.class); //wenn Create Walk Btn geklickt wird, Wechsel zu CreateWalk Activity
                startActivity(moveToRegister);
            }
        });

        Walk1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, JoinWalk.class);
                startActivity(moveToRegister);
            }
        });

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, Login.class); //wenn Logout Btn geklickt wird, Wechsel zu Login Activity
                startActivity(moveToRegister);
                startActivity(moveToRegister);
            }
        });
    }




    }




