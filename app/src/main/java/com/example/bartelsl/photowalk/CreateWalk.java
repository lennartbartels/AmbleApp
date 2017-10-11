package com.example.bartelsl.photowalk;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import amble.main.RestClient;
import amble.model.Photowalk;
import amble.model.User;
import amble.service.PhotowalkApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateWalk extends Activity {

    PhotowalkApiService retrofit = RestClient.getPhotoWalk();

    EditText name;
    EditText date;
    EditText startPoint;
    EditText endPoint;
    EditText duration;
    EditText description;


    Button CreateWalkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_walk);
        //initializing the button and editTexts

        CreateWalkBtn = (Button) findViewById(R.id.btnCreateWalk);
        name = (EditText) findViewById(R.id.etName);
        date = (EditText) findViewById(R.id.eTDate);
        startPoint= (EditText) findViewById(R.id.eTStartPoint);
        endPoint = (EditText) findViewById(R.id.eTEndPoint);
        duration = (EditText) findViewById(R.id.eTDuration);
        description= (EditText) findViewById(R.id.eTDescription);
        // initialize onClick

        CreateWalkBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                    public void onClick(View v){
                    //what happens onClick
                                    Photowalk photowalk = new Photowalk(
                                            name.getText().toString(),
                                            Integer.parseInt(duration.getText().toString()),
                                           // Date.(.getText().toString()),
                                    startPoint.getText().toString(),
                                    endPoint.getText().toString(),
                                    description.getText().toString()
                            );

                            sendPhotowalkNetworkrequest(photowalk);
        }
    });
    }

    private void sendPhotowalkNetworkrequest(Photowalk photowalk) {
        //UserClient client = retrofit.getUserClient();
        Call<Void> photoWalkcall = retrofit.createPhotoWalk(photowalk);
        photoWalkcall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                retrofit.getPhotoWalkByName(photowalk.getPhotoWalk()).enqueue(new Callback<Photowalk>() {
                    @Override
                    public void onResponse(Call<Photowalk> call, Response<Photowalk> response) {
                        Photowalk phtwlk = response.body();
                        if (phtwlk != null) {
                            Toast.makeText(CreateWalk.this, "success Photowalk:" + response.body().getPhotoWalk(), Toast.LENGTH_SHORT).show();
                            RestClient.setCurrentPhotowalk(phtwlk);
                            Intent moveToRegister = new Intent(CreateWalk.this, Home.class);
                            startActivity(moveToRegister);
                        } else {
                            Toast.makeText(CreateWalk.this, "Creation of Walk failed", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(CreateWalk.this, "Creation failed completly.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*public void jumpToPage(View view) {
        mViewPager.setCurrentItem(1);
    }*/
}
