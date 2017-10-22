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
import android.widget.Toast;

import amble.main.RestClient;
import amble.model.Photowalk;
import amble.model.User;
import amble.service.PhotowalkApiService;
import amble.service.UserClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateWalk extends Activity {

    PhotowalkApiService retrofit = RestClient.getPhotowalkApiService();

    EditText eTName;
    EditText eTDate;
    EditText eTStartPoint;
    EditText eTEndPoint;
    EditText eTDuration;
    EditText eTDescription;
    Button btnCreateWalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_walk);
        //initializing the button and editTexts
        btnCreateWalk = (Button) findViewById(R.id.btnCreateWalk);
        eTName = (EditText) findViewById(R.id.eTName);
        eTDate = (EditText) findViewById(R.id.eTDate);
        eTStartPoint = (EditText) findViewById(R.id.eTStartPoint);
        eTEndPoint = (EditText) findViewById(R.id.eTEndPoint);
        eTDuration = (EditText) findViewById(R.id.eTDuration);
        eTDescription = (EditText) findViewById(R.id.eTDescription);
        // initialize onClick
        btnCreateWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Photowalk photowalk = new Photowalk(
                        eTName.getText().toString(),
                        eTDate.getText().toString(),
                        eTStartPoint.getText().toString(),
                        eTEndPoint.getText().toString(),
                        Integer.parseInt(eTDuration.getText().toString()),
                        eTDescription.getText().toString()
                );

                sendNetworkrequest(photowalk);
            }
        });
    }

    private void sendNetworkrequest(Photowalk photowalk) {
        Call<Void> walkcall = retrofit.createWalk(photowalk);
        walkcall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                retrofit.getSinglePW(photowalk.getName()).enqueue(new Callback<Photowalk>() {
                    @Override
                    public void onResponse(Call<Photowalk> call, Response<Photowalk> response) {
                        Photowalk phwalk = response.body();
                        if (phwalk != null) {
                            Toast.makeText(CreateWalk.this, "Create Walk successful:" + response.body().getName(), Toast.LENGTH_SHORT).show();
                            Intent moveToRegister = new Intent(CreateWalk.this, Home.class);
                            startActivity(moveToRegister);
                        } else {
                            Toast.makeText(CreateWalk.this, "Creation failed.", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Photowalk> call, Throwable t) {

                        Toast.makeText(CreateWalk.this, "Creation failed.", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast toast = Toast.makeText(CreateWalk.this, "Creation failed completely.", Toast.LENGTH_SHORT);
                toast.show();
            }


        });

    }
    /*public void jumpToPage(View view) {
        mViewPager.setCurrentItem(1);
    }*/
}

