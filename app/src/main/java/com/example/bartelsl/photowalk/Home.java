package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Home extends Activity {

    //ListView WalkListe;
    Button CreateWalkBtn;
    Button Walk1Btn;
    Button LogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //WalkListe = (ListView) findViewById(R.id.lvWalkListe);
        CreateWalkBtn = (Button) findViewById(R.id.btnCreateWalk);
        Walk1Btn = (Button) findViewById(R.id.btnWalk1);
        LogoutBtn = (Button) findViewById(R.id.btnLogout);



        /*WalkListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, CreateWalk.class);
                startActivity(moveToRegister);
            }
        });*/

        CreateWalkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Home.this, CreateWalk.class);
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
                Intent moveToRegister = new Intent(Home.this, Login.class);
                startActivity(moveToRegister);
            }
        });
    }


}
