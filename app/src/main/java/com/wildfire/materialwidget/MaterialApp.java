package com.wildfire.materialwidget;

import android.app.Application;

import com.wildfire.materiallib.config.MaterialConfig;

/**
 * Author:wildfire
 * Time:2018/12/20
 */
public class MaterialApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MaterialConfig.init(this);
    }
}
