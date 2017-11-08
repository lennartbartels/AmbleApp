package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import amble.exceptions.NotLoggedinException;
import amble.main.RestClient;
import amble.model.Photowalk;
import amble.service.PhotowalkApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyWalks extends Activity {

    Button CreateWalkBtn;
    Button MyWalksBtn;
    Button PreviousWalksBtn;
    Button LogoutBtn;
    ListView lvMyCreatedWalks;
    PhotowalkApiService retrofit =  RestClient.getPhotowalkClient();
    Photowalk photowalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_walks);

        try {
            String token = RestClient.getToken();
            if (token == null) {
                throw new NotLoggedinException();
            }

            Call<List<Photowalk>> myWalksCall = retrofit.getPhotowalks(token); // noch NICHT die richtige Methode!

            myWalksCall.enqueue(new Callback<List<Photowalk>>() {


                @Override
                public void onResponse(Call<List<Photowalk>> call, Response<List<Photowalk>> response) {
                    List<Photowalk> MyCreatedWalks = response.body();
                    lvMyCreatedWalks = (ListView) findViewById(R.id.lvMyCreatedWalks);
                    ListAdapter adapter = new ArrayAdapter<Photowalk>(MyWalks.this, android.R.layout.simple_list_item_1, MyCreatedWalks);
                    lvMyCreatedWalks.setAdapter(adapter);
                    lvMyCreatedWalks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent seeDetails = new Intent(MyWalks.this, JoinWalk.class);
                            startActivity(seeDetails);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<Photowalk>> call, Throwable t) {
                    Toast toast = Toast.makeText(MyWalks.this,"Oops. Something went wrong!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }



        CreateWalkBtn = (Button) findViewById(R.id.btnCreateWalk);
        MyWalksBtn = (Button) findViewById(R.id.btnMyWalks);
        PreviousWalksBtn = (Button) findViewById(R.id.btnPreviousWalks);
        LogoutBtn = (Button) findViewById(R.id.btnLogout);



        CreateWalkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToCreateWalk = new Intent(MyWalks.this, CreateWalk.class); //wenn Create Walk Btn geklickt wird, Wechsel zu CreateWalk Activity
                startActivity(moveToCreateWalk);
            }
        });

        MyWalksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToMyWalks = new Intent(MyWalks.this, MyWalks.class);
                startActivity(moveToMyWalks);
            }
        });

        PreviousWalksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToPreviousWalks = new Intent(MyWalks.this, PreviousWalks.class);
                startActivity(moveToPreviousWalks);
            }
        });

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToLogin = new Intent(MyWalks.this, Login.class); //wenn Logout Btn geklickt wird, Wechsel zu Login Activity
                startActivity(moveToLogin);
            }
        });
    }
}
