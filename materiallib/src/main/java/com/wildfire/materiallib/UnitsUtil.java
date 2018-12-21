package com.wildfire.materiallib;

import android.content.Context;
import android.util.TypedValue;

public class UnitsUtil {

    public static int dp2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int sp2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int pt2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PT, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int in2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_IN, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int mm2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, value, context.getResources().getDisplayMetrics()) + 0.5f);
    }
}