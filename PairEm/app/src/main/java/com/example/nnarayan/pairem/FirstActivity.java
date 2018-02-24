package com.example.nnarayan.pairem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class FirstActivity extends AppCompatActivity {

    String[] actors ={
            "Christian Bale",
            "Leonardo Dicaprio",
            "Jim Carrey",
            "Robert Downey Jr",
            "Johnny Depp",
            "Martin Freeman"
    };

    HashMap<String, String> actorsInfoMap = new HashMap<String, String>(){{
        put("Christian Bale", "Christian Bale\n" +
                "Born: Christian Charles Philip Bale\n" +
                "30 January 1974");

        put("Leonardo Dicaprio", "Leonardo Dicaprio\n" +
                "Born: Leonardo Wilhelm DiCaprio\n" +
                "November 11, 1974");

        put("Jim Carrey", "Jim Carrey\n" +
                "Born: James Eugene Carrey\n" +
                "January 17, 1962");

        put("Robert Downey Jr", "Robert Downey Jr\n" +
                "Born: Robert John Downey Jr.\n" +
                "April 4, 1965");

        put("Johnny Depp", "Johnny Depp\n" +
                "Born: John Christopher Depp II\n" +
                "June 9, 1963");
    }};

    String firstActor = "";
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.firstListOfActors);

        // Each row in the list stores the actor's name and an image
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<actors.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("name", actors[i]);
            hm.put("info", actorsInfoMap.get(actors[i]));
            hm.put("info_button", Integer.toString(R.drawable.info_icon_small));

            String actor_image_file_name = actors[i].replaceAll(" ", "_").toLowerCase();
            int image_id = this.getResources().getIdentifier(actor_image_file_name, "drawable", this.getPackageName());
            if (image_id > 0) {
                hm.put("actor_image", Integer.toString(image_id));
            }
            else {
                hm.put("actor_image", Integer.toString(R.drawable.no_image_available));
            }

            SharedPreferences preferences = getSharedPreferences("ActorPreferences", Context.MODE_PRIVATE);
            if (preferences.contains(actors[i])) {
                Boolean savedPreference = preferences.getBoolean(actors[i], false);
                if (savedPreference){
                    hm.put("like_button", Integer.toString(R.drawable.like_button_yes));
                }
                else{
                    hm.put("like_button", Integer.toString(R.drawable.like_button_no));
                }
            }
            else {
                hm.put("like_button", Integer.toString(R.drawable.like_button_no));
            }
            list.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "info_button", "actor_image", "like_button"};

        // Ids of views in listview_layout
        int[] to = { R.id.info_button, R.id.actor_image, R.id.like_button};

        // Instantiating an adapter to store each items
        // R.layout.list_items_layout defines the layout of each item
        CustomListViewItemAdapter adapter = new CustomListViewItemAdapter(getBaseContext(), list, R.layout.list_items_layout, from, to);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        nextButton = (Button) findViewById(R.id.firstNextButton);
        nextButton.setEnabled(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                firstActor = actors[i];
                nextButton.setEnabled(true);
                for(int a = 0; a < adapterView.getChildCount(); a++)
                {
                    adapterView.getChildAt(a).setBackgroundColor(Color.TRANSPARENT);
                }

                view.setBackgroundColor(Color.parseColor("#b3e5fc"));
            }
        });
    }

    public void goToSecondActivity(View v){
        Intent goToSecondActivity = new Intent();
        goToSecondActivity.setClass(this, SecondActivity.class);
        goToSecondActivity.putExtra("actorName", firstActor);
        startActivity(goToSecondActivity);
    }
}

