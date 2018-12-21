package com.wildfire.materiallib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.wildfire.materiallib.core.ViewCreateHelper;

/**
 * 每个Activity都有不同的LayoutInflater对象
 * 每个Activity都需要为LayoutInflater设置Factory
 */
public class ShadowFactory2 implements LayoutInflater.Factory2 {

    private ShadowFactory2() {
    }

    private ViewCreateHelper viewCreateHelper = new ViewCreateHelper();

    private static class ShadowFactory2Factory {
        private static ShadowFactory2 factory2 = new ShadowFactory2();
    }

    public static ShadowFactory2 getInstance() {
        return ShadowFactory2Factory.factory2;
    }


    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return viewCreateHelper.onCreateView(parent,name,context,attrs);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return null;
    }

    public ViewCreateHelper getViewCreateHelper() {
        return viewCreateHelper;
    }
}
