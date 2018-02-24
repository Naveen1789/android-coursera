package com.example.nnarayan.imagedemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageViewLarge = (ImageView) findViewById(R.id.imageViewLarge);
        imageViewLarge.setImageResource(R.drawable.penguin);
        
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarPos;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarPos = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imageViewLarge.setColorFilter(Color.argb(255, 0, seekBarPos, 255 - seekBarPos));
            }
        });
    }
}
