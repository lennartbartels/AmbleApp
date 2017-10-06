package com.example.bartelsl.photowalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

public class CreateWalk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_walk);
        //initializing the button and editTexts
        AppCompatButton btnCreateWalk = (AppCompatButton) findViewById(R.id.btnCreateWalk);
        AppCompatEditText eTDate = (AppCompatEditText) findViewById(R.id.eTDate);
        AppCompatEditText eTStartPoint = (AppCompatEditText) findViewById(R.id.eTStartPoint);
        AppCompatEditText eTEndPoint = (AppCompatEditText) findViewById(R.id.eTEndPoint);
        AppCompatEditText eTDuration = (AppCompatEditText) findViewById(R.id.eTDuration);
        AppCompatEditText eTDescription = (AppCompatEditText) findViewById(R.id.eTDescription);
        // initialize onClick
        /*
        btnCreateWalk.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //what happens onClick
        }
    });
    */
    }

    /*public void jumpToPage(View view) {
        mViewPager.setCurrentItem(1);
    }*/
}
