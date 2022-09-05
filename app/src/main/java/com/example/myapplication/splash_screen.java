package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread SSS  = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                    startActivity(new Intent(splash_screen.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

    }
    public void startsplahscree(){




    }
}