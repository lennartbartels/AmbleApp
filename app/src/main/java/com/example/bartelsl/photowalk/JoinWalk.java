package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JoinWalk extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_walk);

        Button btnJoinWalk = (Button) findViewById(R.id.btnJoinWalk);
        Button btnMap = (Button) findViewById(R.id.btnMap);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToMap = new Intent(JoinWalk.this, Map.class);
                startActivity(moveToMap);
            }
        });

        // initialize onClick
        /*btnJoinWalk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //what happens onClick
            }
        });*/
    }
}
