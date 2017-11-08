package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class helpCreateWalk extends Activity {

    ImageButton exitCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_create_walk);

        exitCreate =(ImageButton) findViewById(R.id.exitHelpCreate);
        exitCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelpCreate = new Intent(helpCreateWalk.this,CreateWalk.class);
                startActivity(moveToHelpCreate);

            }
        });

    }
}
