package com.wildfire.materiallib.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.wildfire.materiallib.MaterialUtil;
import com.wildfire.materiallib.ShadowFactory2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 统一声明：若只需为一个Activity使用，只需在需要使用的Activity中使用
 * Author:wildfire
 * Time:2018/12/20
 */
@SuppressLint("Registered")
public class MaterialActivity extends AppCompatActivity {

    /**
     * 第一种方式
     * @param savedInstanceState state
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        MaterialUtil.installFactory(getLayoutInflater());
        super.onCreate(savedInstanceState);
    }

    /**
     * 第二种方式
     * @param parent parent
     * @param name name
     * @param context context
     * @param attrs attrs
     * @return view
     */
//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//        return ShadowFactory2.getInstance().getViewCreateHelper().onCreateView(parent,name,context,attrs);
//    }
}
