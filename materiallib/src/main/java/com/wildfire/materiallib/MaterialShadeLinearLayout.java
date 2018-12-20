package com.wildfire.materiallib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * Shade
 */
public class MaterialShadeLinearLayout extends LinearLayout implements IMaterialShadow {

    private final int[] attr = {R.attr.MShadowRadius, R.attr.MShadowColor};
    float shadowRadius = 0f;
    float shadowOffX = 0f;
    float shadowOffY = 0f;
    int shadowColor = Color.parseColor("#80333333");

    LayoutInflater layoutInflater;

    public MaterialShadeLinearLayout(Context context) {
        this(context, null);
    }

    public MaterialShadeLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialShadeLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, attr);
        array.getFloat(0,0f);
        array.recycle();

        layoutInflater = LayoutInflater.from(context);
        //layoutInflater.setFactory2(new ShadowFactory2());
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
