package com.example.bartelsl.photowalk;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateWalk extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_walk);
        //initializing the button and editTexts
        Button btnCreateWalk = (Button) findViewById(R.id.btnCreateWalk);
        EditText eTDate = (EditText) findViewById(R.id.eTDate);
        EditText eTStartPoint = (EditText) findViewById(R.id.eTStartPoint);
        EditText eTEndPoint = (EditText) findViewById(R.id.eTEndPoint);
        EditText eTDuration = (EditText) findViewById(R.id.eTDuration);
        EditText eTDescription = (EditText) findViewById(R.id.eTDescription);
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
