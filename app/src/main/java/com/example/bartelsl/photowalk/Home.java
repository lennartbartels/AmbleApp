package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import amble.exceptions.NotLoggedinException;
import amble.main.RestClient;
import amble.model.Photowalk;
import amble.service.PhotowalkApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Activity {

    //ListView WalkListe
    Button CreateWalkBtn;
    Button MyWalksBtn;
    Button PreviousWalksBtn;
    Button LogoutBtn;
    ListView lvWalks;
    PhotowalkApiService retrofit =  RestClient.getPhotowalkClient();
    Photowalk photowalk;
    ImageButton Help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try{String token = RestClient.getToken();
            if (token == null ){throw new NotLoggedinException();}

            Call<List<Photowalk>> photowalksCall = retrofit.getPhotowalks(token);

            photowalksCall.enqueue(new Callback<List<Photowalk>>() {
            @Override
            public void onResponse(Call<List<Photowalk>> call, Response<List<Photowalk>> response) {
                List<Photowalk> walks = response.body();
                lvWalks = (ListView) findViewById(R.id.lvWalks);
                ListAdapter adapter = new ArrayAdapter<Photowalk>(Home.this, android.R.layout.simple_list_item_1,walks);
                lvWalks.setAdapter(adapter);
                lvWalks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(Home.this, JoinWalk.class);

                        startActivity(intent);


                    }
                });


                }

            @Override
            public void onFailure(Call<List<Photowalk>> call, Throwable t) {
                System.out.println("abc");
            }



            });}
        catch(Exception e){
            e.printStackTrace();
        }
       /* String[] walks = {"Walk 1", "Walk 2", "Walk 3", "..."}; //nur Beispiel, damit etwas angezeigt wird!
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, walks);
        ListView lvWalks = (ListView) findViewById(lvWalks);
        lvWalks.setAdapter(adapter);
*/


        CreateWalkBtn = (Button) findViewById(R.id.btnCreateWalk);
        MyWalksBtn = (Button) findViewById(R.id.btnMyWalks);
        PreviousWalksBtn = (Button) findViewById(R.id.btnPreviousWalks);
        LogoutBtn = (Button) findViewById(R.id.btnLogout);
        Help = (ImageButton) findViewById(R.id.btnHelpHome);



        CreateWalkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, CreateWalk.class); //wenn Create Walk Btn geklickt wird, Wechsel zu CreateWalk Activity
                startActivity(moveToRegister);
            }
        });

        MyWalksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, MyWalks.class);
                startActivity(moveToRegister);
            }
        });
        MyWalksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, MyWalks.class);
                startActivity(moveToRegister);
            }
        });
        PreviousWalksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, PreviousWalks.class);
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

        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelpHome = new Intent(Home.this,HelpHome.class);
                startActivity(moveToHelpHome);
                }
             });
    }




    }




