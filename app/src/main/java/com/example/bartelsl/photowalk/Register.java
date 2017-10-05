package com.example.bartelsl.photowalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Register extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner selectRole;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //entfernt title bar
        setContentView(R.layout.activity_register);


        adapter = ArrayAdapter.createFromResource(this, R.array.role, android.R.layout.simple_spinner_item);

        selectRole = (Spinner) findViewById(R.id.spnSelectRole);
        selectRole.setAdapter(adapter);
        selectRole.setOnItemSelectedListener(Register.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView selectRoleText = (TextView) view;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
