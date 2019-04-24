package com.eomsbd.newsportal;

import android.app.Application;
import android.content.Context;

import com.esotericsoftware.minlog.Log;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
