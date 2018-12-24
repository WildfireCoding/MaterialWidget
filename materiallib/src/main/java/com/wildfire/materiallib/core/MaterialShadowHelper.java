package com.wildfire.materiallib.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;

import com.wildfire.materiallib.MaterialUtil;
import com.wildfire.materiallib.widget.MaterialTextView;

/**
 * Author:wildfire
 * Time:2018/12/23
 */
public class MaterialShadowHelper {

    private Paint shadowPaint = new Paint();
    private RectF rectShadow = new RectF();
    private Path path = new Path();

    private ViewGroup parent;

    public MaterialShadowHelper(ViewGroup view) {
        this.parent = view;
        parent.setWillNotDraw(false);
        parent.setLayerType(View.LAYER_TYPE_SOFTWARE, shadowPaint);
        shadowPaint.setAntiAlias(true);
    }

    /**
     * 分发绘制
     *
     * @param canvas canvas
     */
    public void dispatchDrawShadow(Canvas canvas) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof MaterialTextView) {
                drawShadow((MaterialTextView) child, canvas);
            }
        }
    }

    /**
     * 绘制子View的Shadow
     */
    private void drawShadow(MaterialTextView child, Canvas canvas) {
        int shadowColor = child.getMShadowColor();
        float shadowCorner = child.getMShadowCorner();
        float shadowOffset = child.getMShadowOffset();
        float shadowRadius = child.getMShadowRadius();
        int direction = child.getMShadowDirection();
        //not draw shadow if shadowRadius is zero
        if (shadowRadius <= 0f) {
            return;
        }
        //calculate offset
        float[] offset = MaterialUtil.calculateOffset(direction, shadowOffset);
        shadowPaint.setShadowLayer(shadowRadius, offset[0], offset[1], shadowColor);
        rectShadow.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        path.reset();
        path.addRoundRect(rectShadow, shadowCorner, shadowCorner, Path.Direction.CW);
        canvas.save();
        canvas.clipRect(0, 0, parent.getMeasuredWidth(), parent.getMeasuredHeight());
        //clip shadow area
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawPath(path, shadowPaint);
        canvas.restore();
    }
}
