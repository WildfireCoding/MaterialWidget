package com.wildfire.materiallib;

/**
 * Author:wildfire
 * Time:2018/12/23
 */
public class MaterialUtil {
    /**
     * 计算偏移值
     *
     * @param direction 顺时针360度
     * @return 偏移值
     */
    public static float[] calculateOffset(int direction, float shadowOffset) {
        float[] offset = new float[2];
        //Math.sin参数为角度对应的弧度（弧度的计算公式：2*PI/360;即PI/180）
        offset[0] = shadowOffset * (float) (Math.cos((double) direction * Math.PI / 180));
        offset[1] = shadowOffset * (float) (Math.sin((double) direction * Math.PI / 180));
        return offset;
    }
}
