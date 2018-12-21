package com.wildfire.materiallib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.wildfire.materiallib.factory.MaterialTextView;

import androidx.annotation.Nullable;

/**
 * Shade
 */
public class MaterialLinearLayout extends LinearLayout {

    private Paint shadowPaint = new Paint();
    private RectF rectShadow = new RectF();

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
        setWillNotDraw(false);
        setLayerType(View.LAYER_TYPE_SOFTWARE, shadowPaint);
        shadowPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child instanceof MaterialTextView) {
                drawShadow((MaterialTextView) child, canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    /**
     * 绘制子View的Shadow
     */
    private void drawShadow(MaterialTextView view, Canvas canvas) {
        int shadowColor = view.getMShadowColor();
        float shadowCorner = view.getMShadowCorner();
        float shadowOffset = view.getMShadowOffset();
        float shadowRadius = view.getMShadowRadius();
        int direction = view.getMShadowDirection();
        float[] offset = calculateOffset(direction, shadowOffset);
        shadowPaint.setShadowLayer(shadowRadius, offset[0], offset[1], shadowColor);
        rectShadow.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        canvas.drawRoundRect(rectShadow, shadowCorner, shadowCorner, shadowPaint);
    }

    /**
     * 计算偏移值
     *
     * @param direction 顺时针360度
     * @return 偏移值
     */
    private float[] calculateOffset(int direction, float shadowOffset) {
//        if (direction < 0 || direction > 360) {
//            return new float[]{0f, 0f};
//        }
        float[] offset = new float[2];
        //Math.sin参数为角度对应的弧度（弧度的计算公式：2*PI/360;即PI/180）
        offset[0] = shadowOffset * (float) (Math.cos((double) direction * Math.PI / 180));
        offset[1] = shadowOffset * (float) (Math.sin((double) direction * Math.PI / 180));
        return offset;
    }
}
