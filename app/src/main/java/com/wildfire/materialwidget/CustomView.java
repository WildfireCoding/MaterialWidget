package com.wildfire.materialwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 0.57735f (1/3的开方)      12.047
     * radius > 0 ? BLUR_SIGMA_SCALE * radius + 0.5f : 0.0f;
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        setLayerType(View.LAYER_TYPE_SOFTWARE,paint);
        int width = getMeasuredWidth()-50;
        int height = getMeasuredHeight()-50;
        paint.setShadowLayer(23,0,0, Color.BLACK);
        canvas.drawRect(50,50,width,height,paint);
    }
}
