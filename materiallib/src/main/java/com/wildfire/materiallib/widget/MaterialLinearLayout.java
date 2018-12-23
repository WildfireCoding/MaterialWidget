package com.wildfire.materiallib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.wildfire.materiallib.core.MaterialShadowHelper;

import androidx.annotation.Nullable;

/**
 * MaterialLinearLayout
 */
public class MaterialLinearLayout extends LinearLayout {
    MaterialShadowHelper helper;

    public MaterialLinearLayout(Context context) {
        this(context, null);
    }

    public MaterialLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        helper = new MaterialShadowHelper(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        helper.dispatchDrawShadow(canvas);
        super.dispatchDraw(canvas);
    }
}
