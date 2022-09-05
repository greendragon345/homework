package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class contc {
    private Bitmap pics;
    private String fname;
    private String lname;


    public contc(Bitmap picsnam, String actn, String movien, Resources r1) {
        pics = picsnam;
        this.fname = actn;
        this.lname = movien;


    }
    public String getfname(){return fname;}
    public String getlname(){return lname;}
    public Bitmap getPics(){return pics;}

}
