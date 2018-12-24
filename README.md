# MaterialWighet

A android material design library（支持5.0以下）

![2018-12-24 12.37.58](https://github.com/WildfireCoding/MaterialWidget/blob/master/data/gif_material_button.gif)

## 功能

1. 支持RaisedButton/FlatButton
   * 不占据view大小
   * 在相邻view，阴影不会相互阻挡
   * 自定义阴影方向/颜色/模糊半径
   * 自定义波纹颜色/速度/背景

### 使用

1. 使用MaterialLinearLayout/MaterialFrameLayout/MaterialRelativeLayout作为直接父布局
2. 使用MaterialTextView作为RaisedButton/FlatButton

> 注：Material…Layout并不是作为Button的包裹类（即MaterialTextView可以与其他任何View在Material…Layout里进行布局）。

#### sample

```xml
<com.wildfire.materiallib.widget.layout.MaterialLinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".FirstActivity">
    <com.wildfire.materiallib.widget.MaterialTextView
        android:id="@+id/tv_textView"
        android:layout_width="300dp"
        android:layout_height="60dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="100dp"
        android:background="@drawable/shadow_shape"
        android:gravity="center"
        android:text="Raised Button"
        android:textColor="#fff"
        android:textSize="15sp"
        app:MShadowCorner="10dp"
        app:MShadowDirection="45"
        app:MShadowOffset="5dp"
        app:MShadowRadius="10" />
    <TextView
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="100dp"
        android:text="阴影方向（顺时针0～360度）" />
</com.wildfire.materiallib.widget.layout.MaterialLinearLayout>
```

#### attribute

```xml
<declare-styleable name="MaterialTextView">
        <!--阴影颜色-->
        <attr name="MShadowColor" format="color" />
        <!--阴影圆角（若background为shape（gradientDrawable）,background也会进行圆角）-->
        <attr name="MShadowCorner" format="dimension" />
        <!--阴影偏移-->
        <attr name="MShadowOffset" format="dimension" />
        <!--阴影方向（顺时针360度）-->
        <attr name="MShadowDirection" format="integer" />
        <!--阴影模糊半径-->
        <attr name="MShadowRadius" format="integer" />
        <!--波纹背景色（仅当扁平按钮时绘制在波纹以下，即阴影的偏移为0（不恰当的说法））-->
        <attr name="MRippleBgColor" format="color" />
        <!--波纹颜色-->
        <attr name="MRippleColor" format="color" />
        <!--波纹速度-->
        <attr name="MRippleRate" format="dimension" />
        <!--是否启用波纹-->
        <attr name="MRippleEnable" format="boolean" />
    </declare-styleable>
```