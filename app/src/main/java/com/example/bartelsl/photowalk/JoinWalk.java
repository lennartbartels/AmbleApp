package com.example.bartelsl.photowalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

public class JoinWalk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_walk);
        //initializing the button and editTexts
        AppCompatButton btnJoinWalk = (AppCompatButton) findViewById(R.id.btnJoinWalk);
        AppCompatEditText eTDate = (AppCompatEditText) findViewById(R.id.eTDate);
        AppCompatEditText eTStartPoint = (AppCompatEditText) findViewById(R.id.eTStartPoint);
        AppCompatEditText eTEndPoint = (AppCompatEditText) findViewById(R.id.eTEndPoint);
        AppCompatEditText eTDuration = (AppCompatEditText) findViewById(R.id.eTDuration);
        AppCompatEditText eTDescription = (AppCompatEditText) findViewById(R.id.eTDescription);
        AppCompatEditText eTParticipants = (AppCompatEditText) findViewById(R.id.eTParticipants);
        // initialize onClick
        btnJoinWalk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //what happens onClick
            }
        });
    }
}
