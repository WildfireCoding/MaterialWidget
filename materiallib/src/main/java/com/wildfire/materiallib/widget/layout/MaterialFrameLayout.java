package com.wildfire.materiallib.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wildfire.materiallib.core.MaterialShadowHelper;

import androidx.annotation.Nullable;

/**
 * MaterialLinearLayout
 */
public class MaterialFrameLayout extends FrameLayout {

    MaterialShadowHelper helper;

    public MaterialFrameLayout(Context context) {
        this(context, null);
    }

    public MaterialFrameLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialFrameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        helper = new MaterialShadowHelper(this);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        helper.dispatchDrawShadow(canvas);
        super.dispatchDraw(canvas);
    }
}
