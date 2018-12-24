package com.wildfire.materiallib.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wildfire.materiallib.core.MaterialShadowHelper;

import androidx.annotation.Nullable;

/**
 * MaterialLinearLayout
 */
public class MaterialRelativeLayout extends RelativeLayout {

    MaterialShadowHelper helper;

    public MaterialRelativeLayout(Context context) {
        this(context, null);
    }

    public MaterialRelativeLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialRelativeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        helper = new MaterialShadowHelper(this);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        helper.dispatchDrawShadow(canvas);
        super.dispatchDraw(canvas);
    }
}
