package com.example.axity.lithoexample;

import android.app.Application;

import com.facebook.soloader.SoLoader;

/**
 * Created by javierrodriguez on 4/6/18.
 */

public class LithoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SoLoader.init(this, false);
    }
}
