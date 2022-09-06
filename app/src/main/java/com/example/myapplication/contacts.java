package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class contacts extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, View.OnClickListener {
    ListView fllv2;
    boolean NOE;
    int id;
    int num;
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
        id=0;
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
        num = i;
        opendalg();
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences.Editor pcsp = ap2.edit();
        pcsp.remove("fname"+i);
        pcsp.remove("lname"+i);
        pcsp.remove("imagenum"+i);
        pcsp.putString("fname"+i,"nada");
        pcsp.putString("lname"+i,"nada");
        pcsp.putString("imagenum"+i,"nada");
        pcsp.apply();
        alfl2.remove(i);
        AAFL2.notifyDataSetChanged();
    }



    @Override
    public void onClick(View view) {
        if(view==b1){
            opendalg();
            NOE = true;
        }else if(view == b2){
            editOaddname.dismiss();
            if(NOE){
                id++;
                SharedPreferences.Editor pcsp = ap2.edit();
                try{
                    pcsp.remove("idd:");
                }catch (Exception e){

                }
                pcsp.putInt("idd:",id);
                pcsp.putString("fname"+id,fname.getText().toString());
                pcsp.putString("lname"+id,lname.getText().toString());
                ivleague.setDrawingCacheEnabled(true);
                pcsp.putString("imagenum"+id,convertBitmapToString(ivleague.getDrawingCache()));
                contc ncont = new contc(ivleague.getDrawingCache(),fname.getText().toString(),lname.getText().toString(),getResources());
                pcsp.apply();
                alfl2.add(ncont);
                AAFL2.notifyDataSetChanged();
                NOE=false;
            }else {
                SharedPreferences.Editor pcsp = ap2.edit();
                pcsp.remove("fname"+num);
                pcsp.remove("lname"+num);
                pcsp.remove("imagenum"+num);
                pcsp.putString("fname"+num,fname.getText().toString());
                pcsp.putString("lname"+num,lname.getText().toString());
                ivleague.setDrawingCacheEnabled(true);
                pcsp.putString("imagenum"+num,convertBitmapToString(ivleague.getDrawingCache()));
                pcsp.apply();
                contc ncont = new contc(ivleague.getDrawingCache(),fname.getText().toString(),lname.getText().toString(),getResources());
                alfl2.add(ncont);
                AAFL2.notifyDataSetChanged();
            }
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
    public String convertBitmapToString(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();
        String encoded = Base64.encodeToString(b, Base64.DEFAULT);
        return encoded;
    }
    public Bitmap convertStringToBitmap(String encoded){
        if(encoded==null)
            return null;
        byte[] imageAsBytes = Base64.decode(encoded.getBytes(), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0,
                imageAsBytes.length);
        return bitmap;
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
    public void updatedat(){
        try{
            id = ap2.getInt("idd:",0);

        }catch (Exception e){

        }
        for (int i = 1; i <=id; i++) {
            if(!(ap2.getString("fname"+i,"").equals("nada"))){
                contc ncont = new contc(convertStringToBitmap(ap2.getString("imagenum"+i,"")),ap2.getString("fname"+i,""),ap2.getString("lname"+i,""),getResources());
                alfl2.add(ncont);
                AAFL2.notifyDataSetChanged();
            }

        }



    }
}