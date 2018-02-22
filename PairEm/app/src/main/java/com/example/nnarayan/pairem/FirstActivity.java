package com.example.nnarayan.pairem;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class FirstActivity extends AppCompatActivity {

    String[] itemName ={
            "Antartica",
            "Boats",
            "Chalk",
            "Damarr",
            "Eleven",
            "Fun",
            "Googly",
            "Happy",
            "Infinity",
            "Jack",
            "King"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ListView firstListOfActors = (ListView) findViewById(R.id.firstListViewOfActors);
        firstListOfActors.setAdapter(new ArrayAdapter<String>(
                this, R.layout.list_items_layout,
                R.id.penguin_text,itemName));


    }
}
