package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class polishcow extends Service {
    private MediaPlayer plr;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        plr = MediaPlayer.create(this,R.raw.mii);
        plr.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        try {
//
//
//         plr = MediaPlayer.create(this,R.raw.jhony);
//        }
//        catch (Exception e){ plr = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);}

        plr.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
