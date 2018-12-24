package com.wildfire.materialwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.widget.SeekBar;

import com.wildfire.materiallib.UnitsUtil;
import com.wildfire.materiallib.widget.MaterialTextView;

public class MaterialButton1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_button1);
        final MaterialTextView tv = findViewById(R.id.tv_textView);
        /**
         * 阴影方向
         */
        AppCompatSeekBar seekBarDirection = findViewById(R.id.sb_direction);
        seekBarDirection.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setMShadowDirection(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /**
         * 阴影偏移
         */
        AppCompatSeekBar seekBarOffset = findViewById(R.id.sb_offset);
        seekBarOffset.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setMShadowOffset(UnitsUtil.dp2px(MaterialButton1Activity.this, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /**
         * 阴影模糊半径
         */
        AppCompatSeekBar seekBarRadius = findViewById(R.id.sb_radius);
        seekBarRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setMShadowRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /**
         * 阴影圆角
         */
        AppCompatSeekBar seekBarCorner = findViewById(R.id.sb_corner);
        seekBarCorner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setMShadowCorner(UnitsUtil.dp2px(MaterialButton1Activity.this, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
