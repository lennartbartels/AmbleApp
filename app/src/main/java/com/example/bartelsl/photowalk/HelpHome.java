package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HelpHome extends Activity {

    ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_home);

        exit =(ImageButton) findViewById(R.id.exitHelpHome);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelpHome = new Intent(HelpHome.this,Home.class);
                startActivity(moveToHelpHome);

            }
        });
    }
}
