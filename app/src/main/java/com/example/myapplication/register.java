package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity implements View.OnClickListener {
private EditText t1;
private EditText t2;
private Button b1;
private Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        t1 = findViewById(R.id.vriscool);
        t2 = findViewById(R.id.imdoingthisinvr);
        b1=findViewById(R.id.submit);
        b2=findViewById(R.id.changevis);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view2) {
        if(view2==b1){
            b2.setVisibility(View.VISIBLE);
        }else {
            startActivity(new Intent(register.this,contacts.class));
        }
    }
}