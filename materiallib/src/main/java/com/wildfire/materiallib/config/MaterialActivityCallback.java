package com.wildfire.materiallib.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.wildfire.materiallib.ShadowFactory2;

/**
 * activity生命周期回调
 */
public class MaterialActivityCallback implements Application.ActivityLifecycleCallbacks {

    private ShadowFactory2 shadowFactory2;

    public MaterialActivityCallback() {
    }

    /**
     * 设置shadowFactory
     * 源码调用时机：需要在super.onCreate（）之前调用(默认Factory为AppCompatActivityImpl)
     * @param activity activity
     * @param savedInstanceState state
     */
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if(shadowFactory2 == null){
//            shadowFactory2 = new ShadowFactory2();
        }
        LayoutInflater.Factory2 factory2 = activity.getLayoutInflater().getFactory2();
//        activity.getLayoutInflater().setFactory2(shadowFactory2);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
