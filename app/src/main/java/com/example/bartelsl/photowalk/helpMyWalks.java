package com.example.bartelsl.photowalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class helpMyWalks extends AppCompatActivity {

    ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_my_walks);

        exit =(ImageButton) findViewById(R.id.exitHelpMyWalk);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelpHome = new Intent(helpMyWalks.this,MyWalks.class);
                startActivity(moveToHelpHome);

            }
        });
    }
}
