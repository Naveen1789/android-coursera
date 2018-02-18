package com.example.nnarayan.savingpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.layout);
        SharedPreferences preferences = getSharedPreferences("ColorPref", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        if (preferences.contains("color")) {
            cl.setBackgroundColor(preferences.getInt("color", 0));
        }

        RadioGroup colors = (RadioGroup) findViewById(R.id.radioGroup);
        colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int colorCode = 0;

                switch (i) {
                    case R.id.radioButtonBlue:
                        colorCode = Color.BLUE;
                        break;
                    case R.id.radioButtonMajenta:
                        colorCode = Color.MAGENTA;
                        break;
                    case R.id.radioButtonYellow:
                        colorCode = Color.YELLOW;
                        break;
                }
                cl.setBackgroundColor(colorCode);
                editor.putInt("color", colorCode);
                editor.commit();
            }
        });
    }
}
