package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity implements AdapterView.OnItemSelectedListener {

   // Spinner selectRole;
    Spinner sp1;
    CustomAdapter adapter;
    String[] names = {"Photographer", "Model", "Photographer/Model"};
    int[] images = {R.drawable.photographer, R.drawable.model, R.drawable.photographerormodel};
    //ArrayAdapter adapter;
    Button RegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //entfernt title bar
        setContentView(R.layout.activity_register);

        sp1 = (Spinner)findViewById(R.id.spnSelectRole);
        adapter = new CustomAdapter(this, names, images);

        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                //Toast.makeText(getApplicationContext(), names[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        /*adapter = ArrayAdapter.createFromResource(this, R.array.role, android.R.layout.simple_spinner_item);

        selectRole = (Spinner) findViewById(R.id.spnSelectRole);
        selectRole.setAdapter(adapter);
        selectRole.setOnItemSelectedListener(Register.this);*/


        RegisterBtn = (Button) findViewById(R.id.btnRegister);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegister = new Intent(Register.this, Home.class);
                startActivity(moveToRegister);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        //TextView selectRoleText = (TextView) view;
       // Toast.makeText(getApplicationContext(), names[i], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
