package com.wildfire.materiallib.factory;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import com.wildfire.materiallib.R;
import com.wildfire.materiallib.core.ViewCreateHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class FactoryTextView extends AppCompatTextView {

    private int[] attrs = ViewCreateHelper.attr;
    private Context context;

    private float mShadowRadius = 0f;
    private float mShadowOffsetX = 0f;
    private float mShadowOffsetY = 0f;
    private int mShadowColor = Color.parseColor("#80333333");

    public FactoryTextView(Context context) {
        this(context, null);
    }

    public FactoryTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FactoryTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this.context = context;
        if(attrs != null){
            initAttr(attrs);
        }

    }

    /**
     * 初始化参数
     * @param attrs attributeSet
     */
    public void initAttr(AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs,this.attrs);
        mShadowRadius = array.getFloat(0,0f);
        mShadowColor = array.getColor(1,Color.parseColor("#80333333"));
        mShadowOffsetX = array.getFloat(2,0f);
        mShadowOffsetY = array.getFloat(3,0f);
        array.recycle();
    }

    public float getmShadowRadius() {
        return mShadowRadius;
    }

    public void setmShadowRadius(float mShadowRadius) {
        this.mShadowRadius = mShadowRadius;
    }

    public float getmShadowOffsetX() {
        return mShadowOffsetX;
    }

    public void setmShadowOffsetX(float mShadowOffsetX) {
        this.mShadowOffsetX = mShadowOffsetX;
    }

    public float getmShadowOffsetY() {
        return mShadowOffsetY;
    }

    public void setmShadowOffsetY(float mShadowOffsetY) {
        this.mShadowOffsetY = mShadowOffsetY;
    }

    public int getmShadowColor() {
        return mShadowColor;
    }

    public void setmShadowColor(int mShadowColor) {
        this.mShadowColor = mShadowColor;
    }
}
