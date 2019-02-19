package com.devdarkco.smssender;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class SmsSender extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }
}
