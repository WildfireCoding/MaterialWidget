package com.wildfire.materiallib.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.wildfire.materiallib.IMaterialShadow;
import com.wildfire.materiallib.R;
import com.wildfire.materiallib.UnitsUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * MaterialTextView
 */
public class MaterialTextView extends AppCompatTextView implements IMaterialShadow {

    /**
     * 阴影偏移
     */
    private float mShadowOffset;
    private float mShadowOffsetReal;
    private float[] shadowOffset = new float[2];
    /**
     * 阴影颜色
     */
    private int mShadowColor;
    /**
     * 阴影圆角
     */
    private float mShadowCorner;
    /**
     * 阴影模糊半径
     */
    private float mShadowRadius;
    /**
     * 顺时针360度
     */
    private int mShadowDirection;

    /**
     * Ripple半径
     */
    private float rippleMaxRadius = 0f;
    private float rippleRadius = 0f;
    private float rippleCenterX = 0f;
    private float rippleCenterY = 0f;

    private Paint ripplePaint = new Paint();

    private boolean hasAction = false;
    private int action = -1;

    private int mRippleColor;
    private float mRippleRate;
    /**
     * 该view所在矩形
     */
    private Path path = new Path();
    private RectF rectF = new RectF();

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
        ripplePaint.setColor(mRippleColor);
        setClickable(true);
    }

    private static final int ATTR_SHADOW_COLOR = R.styleable.MaterialTextView_MShadowColor;
    private static final int ATTR_SHADOW_CORNER = R.styleable.MaterialTextView_MShadowCorner;
    private static final int ATTR_SHADOW_DIRECTION = R.styleable.MaterialTextView_MShadowDirection;
    private static final int ATTR_SHADOW_RADIUS = R.styleable.MaterialTextView_MShadowRadius;
    private static final int ATTR_SHADOW_OFFSET = R.styleable.MaterialTextView_MShadowOffset;
    private static final int ATTR_RIPPLE_COLOR = R.styleable.MaterialTextView_MRippleColor;
    private static final int ATTR_RIPPLE_RATE = R.styleable.MaterialTextView_MRippleRate;

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
        if (mShadowOffset < 0) {
            mShadowOffset = 0;
        }
        mShadowOffsetReal = mShadowOffset;
        //阴影圆角
        mShadowCorner = array.getDimension(ATTR_SHADOW_CORNER, 0f);
        //阴影方向（默认右下）
        mShadowDirection = array.getInteger(ATTR_SHADOW_DIRECTION, 45);
        //阴影模糊半径（默认5dp）
        mShadowRadius = array.getDimension(ATTR_SHADOW_RADIUS, UnitsUtil.dp2px(context, 5f));

        //波纹颜色
        mRippleColor = array.getColor(ATTR_RIPPLE_COLOR, Color.parseColor("#3f999999"));
        //波纹速度（默认30）
        mRippleRate = array.getDimension(ATTR_RIPPLE_RATE, 30f);
        array.recycle();

        //set corner
        setMShadowCorner(mShadowCorner);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        onSizeChange(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onSizeChange(w, h);
    }

    /**
     * 计算RippleRadius
     */
    public void onSizeChange(int width, int height) {
        rippleMaxRadius = (float) Math.sqrt(width * width + height * height);
        rectF.set(0, 0, width, height);
        //update path
        updateBackgroundPath();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawRipple(canvas);
    }

    /**
     * 更新Path
     */
    private void updateBackgroundPath() {
        path.reset();
        path.addRoundRect(rectF, mShadowCorner, mShadowCorner, Path.Direction.CW);
    }

    /**
     * 绘制Ripple
     *
     * @param canvas canvas
     */
    public void drawRipple(Canvas canvas) {
        if (!isClickable() || !hasAction) return;
        //2.绘制ripple
        rippleRadius += mRippleRate;
        canvas.save();
        canvas.clipPath(path);
        canvas.drawCircle(rippleCenterX, rippleCenterY, rippleRadius, ripplePaint);
        canvas.restore();
        if (rippleRadius <= rippleMaxRadius) {
            invalidate();
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        action = event.getAction();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rippleRadius = 0f;
                hasAction = true;
                rippleCenterY = event.getY();
                rippleCenterX = event.getX();
                invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                hasAction = false;
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }



    @Override
    public float[] getMShadowOffset() {
        shadowOffset[0] = mShadowOffset;
        shadowOffset[1] = mShadowOffsetReal;
        return shadowOffset;
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


    public void setMShadowDirection(int mShadowDirection) {
        this.mShadowDirection = mShadowDirection;
        invalidate();
    }

    @Override
    public void setMShadowOffset(float mShadowOffset) {
        this.mShadowOffset = mShadowOffset;
        this.mShadowOffsetReal = mShadowOffset;
        invalidate();
    }
    public void setShadowOfForNow(float offset){
        mShadowOffset = offset;
    }
    public void setMShadowRadius(float mShadowRadius) {
        this.mShadowRadius = mShadowRadius;
        invalidate();
    }

    public void setMShadowCorner(float mShadowCorner) {
        this.mShadowCorner = mShadowCorner;
        Drawable bg = getBackground();
        if (bg != null) {
            if (bg instanceof GradientDrawable) {
                ((GradientDrawable) bg).setCornerRadius(mShadowCorner);
                updateBackgroundPath();
            }
        }
    }
    public boolean getHasAction(){
        return hasAction;
    }
    public int getAction(){
        return action;
    }
    public void setMShadowColor(int mShadowColor) {
        this.mShadowColor = mShadowColor;
        invalidate();
    }
}