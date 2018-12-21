package com.wildfire.materiallib;

/**
 *
 */
public interface IMaterialShadow {

    /**
     * 获取阴影偏移
     */
    float getMShadowOffset();

    /**
     * 阴影圆角
     */
    float getMShadowCorner();

    /**
     * 阴影颜色
     */
    int getMShadowColor();

    /**
     * 阴影偏移方向（顺时针360度）
     */
    int getMShadowDirection();

    /**
     * 阴影的模糊半径
     */
    float getMShadowRadius();
}
