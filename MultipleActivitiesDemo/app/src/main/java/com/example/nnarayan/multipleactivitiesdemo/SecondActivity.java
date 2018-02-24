package com.example.nnarayan.multipleactivitiesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent caller = getIntent();
        float rating = caller.getFloatExtra("numOfStars", 0);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Welcome to Second activity!\nYour rating was " + rating + " stars!");
    }
}
