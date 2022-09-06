package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class contacts extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, View.OnClickListener {
    ListView fllv2;
    boolean NOE;
    Dialog editOaddname;
    ArrayList<contc> alfl2;
    contadapat AAFL2;
    Button b1,b2,takepic;
    ImageView ivleague;
    EditText fname,lname;
    SharedPreferences ap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        b1.findViewById(R.id.fucked);
        b1.setOnClickListener(this);
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



    @Override
    public void onClick(View view) {
        if(view==b1){
            opendalg();
        }else if(view == b2){
            editOaddname.dismiss();
        }else if(view == takepic){
            Intent inter = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(inter,0);
        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivleague.setImageBitmap(imageBitmap);
        }
    }
    public void opendalg(){
        editOaddname = new Dialog(this);
        editOaddname.setContentView(R.layout.enterdata);
        editOaddname.setTitle("yasssqueen");
        editOaddname.setCancelable(true);
        b2 = editOaddname.findViewById(R.id.submit);
        takepic = editOaddname.findViewById(R.id.picpun);
        fname = editOaddname.findViewById(R.id.firsnam);
        lname = editOaddname.findViewById(R.id.lastnam);
        ivleague = editOaddname.findViewById(R.id.pic);
        editOaddname.show();

    }
}