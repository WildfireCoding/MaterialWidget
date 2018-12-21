package com.wildfire.materiallib.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.wildfire.materiallib.IMaterialShadow;
import com.wildfire.materiallib.R;
import com.wildfire.materiallib.factory.MaterialTextView;

/**
 * Author:wildfire
 * Time:2018/12/20
 */
public class ViewCreateHelper {



    /**
     * 创建View
     *
     * @param parent  parent
     * @param name    name
     * @param context context
     * @param attrs   attrs
     * @return view
     */
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = null;
        if (parent instanceof IMaterialShadow) {
            switch (name) {
                case "TextView":
                    /*if (checkShadow(context, attrs)) {
                        view = new MaterialTextView(context,attrs);
                        int id = view.getId();
                    }*/
                    break;

            }
        }

        return view;
    }

    /**
     * 检查是否使用了自定义的attr（若使用Radius为必传参数）
     *
     * @return 是否使用shadow
     */
    /*private boolean checkShadow(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, new int[]{attr[0]});
        float radius = array.getFloat(0,0f);
        array.recycle();
        return radius != 0f;
    }*/

}
