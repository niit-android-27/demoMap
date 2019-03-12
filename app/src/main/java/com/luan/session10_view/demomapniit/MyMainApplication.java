package com.luan.session10_view.demomapniit;

import android.app.Application;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;

public class MyMainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Places.initialize(getApplicationContext(),"AIzaSyCKCAcALK7MgtMRX2tiq_agha5J348DkZ0");

    }
}
