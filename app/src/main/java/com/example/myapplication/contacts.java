package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class contacts extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    ListView fllv2;
    ArrayList<contc> alfl2;
    contadapat AAFL2;
    SharedPreferences ap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        fllv2 = findViewById(R.id.lv);
        alfl2 = new ArrayList<>();
        AAFL2 = new contadapat(this,0,0,alfl2);
        fllv2.setAdapter(AAFL2);
        fllv2.setOnItemLongClickListener(this);
        fllv2.setOnItemClickListener(this);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}