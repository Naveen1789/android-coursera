package com.example.nnarayan.multipleactivitiesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void enter(View v){
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        float numOfStars = ratingBar.getRating();

//        Toast.makeText(getApplicationContext(),
//                numOfStars + " stars!",
//                Toast.LENGTH_SHORT).show();

        Intent goToSecondActivity = new Intent();
        goToSecondActivity.setClass(this, SecondActivity.class);
        goToSecondActivity.putExtra("numOfStars", numOfStars);
        startActivity(goToSecondActivity);
        finish();
    }
}
