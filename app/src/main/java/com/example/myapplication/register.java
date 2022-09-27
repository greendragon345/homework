package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {
private EditText t1;
private EditText t2;
private Button b1;
private Button b2;
private EditText t3;
private SharedPreferences aads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        t1 = findViewById(R.id.vriscool);
        t2 = findViewById(R.id.imdoingthisinvr);
        t3 = findViewById(R.id.lname);
        b1=findViewById(R.id.submit);
        b2=findViewById(R.id.changevis);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        aads = getSharedPreferences("jhony",0);
        getthisMF();
    }


    public void getthisMF(){
        try {


    t1.setText(aads.getString("id:",""));
        t2.setText(aads.getString("fname:",""));
        t3.setText(aads.getString("lname:",""));}catch (Exception e){

        }



    }
    @Override
    public void onClick(View view2) {
        if(view2==b1){
            b2.setVisibility(View.VISIBLE);
            SharedPreferences.Editor spl1 = aads.edit();
            spl1.putString("id:",t1.getText().toString());
            spl1.putString("fname:",t2.getText().toString());
            spl1.putString("lname:",t3.getText().toString());
            spl1.apply();
            Toast.makeText(this,"data saved",Toast.LENGTH_LONG);
        }else {
            startActivity(new Intent(register.this,contacts.class));
        }
    }
}