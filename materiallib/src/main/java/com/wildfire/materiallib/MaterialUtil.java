package com.wildfire.materiallib;

import android.view.LayoutInflater;

import androidx.core.view.LayoutInflaterCompat;

/**
 * Author:wildfire
 * Time:2018/12/20
 */
public class MaterialUtil {
    /**
     * install layoutInflater's factory
     * @param layoutInflater LayoutInflater
     */
    public static void installFactory(LayoutInflater layoutInflater){
        LayoutInflaterCompat.setFactory2(layoutInflater,ShadowFactory2.getInstance());
    }
}
