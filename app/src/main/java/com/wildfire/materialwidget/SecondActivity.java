package com.wildfire.materialwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater.Factory2 f1 = getLayoutInflater().getFactory2();
        LayoutInflater.Factory f2 = getLayoutInflater().getFactory();
        LayoutInflater f11 = getLayoutInflater();
        super.onCreate(savedInstanceState);
        LayoutInflater f3 = getLayoutInflater();
        LayoutInflater.Factory f4 = getLayoutInflater().getFactory();
        setContentView(R.layout.activity_second);
    }
}
