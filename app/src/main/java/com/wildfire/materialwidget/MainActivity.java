package com.wildfire.materialwidget;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.wildfire.materiallib.ShadowFactory2;
import com.wildfire.materiallib.base.MaterialActivity;

public class MainActivity extends MaterialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater.Factory2 factory2 = getLayoutInflater().getFactory2();
        LayoutInflater.Factory factory = getLayoutInflater().getFactory();
//        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this),new ShadowFactory2());
        LayoutInflater f311 = getLayoutInflater();
        super.onCreate(savedInstanceState);
        LayoutInflater f322 = getLayoutInflater();
        LayoutInflater.Factory2 f1 = getLayoutInflater().getFactory2();
        LayoutInflater.Factory f2 = getLayoutInflater().getFactory();

        setContentView(R.layout.activity_main);

        View view1 = findViewById(R.id.tv_1);
        View view2 =findViewById(R.id.tv_2);
//        view1.setElevation(50);
        ViewCompat.setElevation(view1,23);
        ViewCompat.setElevation(view2,23);

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
