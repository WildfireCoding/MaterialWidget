package com.wildfire.materiallib.config;

import android.app.Application;
import android.view.LayoutInflater;

import com.wildfire.materiallib.ShadowFactory2;

import androidx.core.view.LayoutInflaterCompat;

public class MaterialConfig {

    /**
     * 初始化
     * 为每个Activity设置Factory2
     * @param application application
     */
    public static void init(Application application){
//        LayoutInflaterCompat.setFactory2(LayoutInflater.from(application),new ShadowFactory2());
//        LayoutInflater.from(application).setFactory2(new ShadowFactory2());
//        application.registerActivityLifecycleCallbacks(new MaterialActivityCallback());
    }
}
