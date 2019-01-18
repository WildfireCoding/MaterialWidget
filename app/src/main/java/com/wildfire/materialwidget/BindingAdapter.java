package com.wildfire.materialwidget;

import com.wildfire.materiallib.widget.MaterialTextView;

/**
 * Author:wildfire
 * Time:2019/1/18
 */
public class BindingAdapter {


    @androidx.databinding.BindingAdapter(value = {
            "MShadowRadius",
            "MShadowCorner"},requireAll = false)
    public static void bindMaterial(MaterialTextView textView) {
        
    }
}
