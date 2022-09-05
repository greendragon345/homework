package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class contadapat extends ArrayAdapter<contc> {
    Context context;
    List<contc> obj;
    public contadapat(Context context, int resource, int textviewresourceid, List<contc> olk) {
        super(context, resource, textviewresourceid, olk);
        this.context = context;
        this.obj = olk;
    }
    public View getView(int pos, View conview, ViewGroup parnet) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.zfxcv, parnet, false);
        TextView fname = view.findViewById(R.id.firstname);
        TextView lname = view.findViewById(R.id.lastname);
        ImageView ibv =view.findViewById(R.id.JC);
        contc temp = obj.get(pos);
        fname.setText(temp.getfname());
        lname.setText(temp.getlname());
        ibv.setImageBitmap(temp.getPics());
        return view;
    }
}
