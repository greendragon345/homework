package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secndactv extends AppCompatActivity implements View.OnClickListener {
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.yesmyking);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(secndactv.this,register.class));

    }
}