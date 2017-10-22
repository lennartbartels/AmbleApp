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

import static com.example.bartelsl.photowalk.R.id.parent;

public class Home extends Activity {

    //ListView WalkListe
    Button CreateWalkBtn;
    Button MyWalksBtn;
    Button PreviousWalksBtn;
    Button LogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String[] walks = {"Walk 1", "Walk 2", "Walk 3", "..."}; //nur Beispiel, damit etwas angezeigt wird!
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, walks);
        ListView lvWalks = (ListView) findViewById(R.id.lvWalks);
        lvWalks.setAdapter(adapter);



        CreateWalkBtn = (Button) findViewById(R.id.btnCreateWalk);
        MyWalksBtn = (Button) findViewById(R.id.btnMyWalks);
        PreviousWalksBtn = (Button) findViewById(R.id.btnPreviousWalks);
        LogoutBtn = (Button) findViewById(R.id.btnLogout);



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
    }


}
