package com.wildfire.materiallib.factory;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

import com.wildfire.materiallib.IMaterialShadow;
import com.wildfire.materiallib.R;
import com.wildfire.materiallib.UnitsUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MaterialTextView extends AppCompatTextView implements IMaterialShadow {

    private float mShadowOffset;
    private int mShadowColor;
    private float mShadowCorner;
    private float mShadowRadius;
    /**
     * 顺时针360度
     */
    private int mShadowDirection;

    public MaterialTextView(Context context) {
        this(context, null);
    }

    public MaterialTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaterialTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        //初始化属性
        if (attrs != null) {
            initAttr(context, attrs);
        }

    }

    private static final int ATTR_SHADOW_COLOR = R.styleable.MaterialTextView_MShadowColor;
    private static final int ATTR_SHADOW_CORNER = R.styleable.MaterialTextView_MShadowCorner;
    private static final int ATTR_SHADOW_DIRECTION = R.styleable.MaterialTextView_MShadowDirection;
    private static final int ATTR_SHADOW_RADIUS = R.styleable.MaterialTextView_MShadowRadius;
    private static final int ATTR_SHADOW_OFFSET = R.styleable.MaterialTextView_MShadowOffset;

    /**
     * 初始化参数
     *
     * @param attrs attributeSet
     */
    public void initAttr(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MaterialTextView);
        //阴影颜色
        mShadowColor = array.getColor(ATTR_SHADOW_COLOR, Color.parseColor("#80333333"));
        //阴影偏移（可理解为由elevation带来的阴影偏移）
        mShadowOffset = array.getDimension(ATTR_SHADOW_OFFSET, 0f);
        //阴影圆角
        mShadowCorner = array.getDimension(ATTR_SHADOW_CORNER, 0f);
        //阴影方向（默认向下）
        mShadowDirection = array.getInteger(ATTR_SHADOW_DIRECTION, 90);
        //阴影模糊半径（默认2dp）
        mShadowRadius = array.getDimension(ATTR_SHADOW_RADIUS, UnitsUtil.dp2px(context, 10f));
        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public float getMShadowOffset() {
        return mShadowOffset;
    }

    @Override
    public float getMShadowCorner() {
        return mShadowCorner;
    }

    @Override
    public int getMShadowColor() {
        return mShadowColor;
    }

    @Override
    public int getMShadowDirection() {
        return mShadowDirection;
    }

    @Override
    public float getMShadowRadius() {
        return mShadowRadius;
    }
}
