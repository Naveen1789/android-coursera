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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends AppCompatActivity {

    String[] actors ={
            "Hugh Jackman",
            "Benedict Cumberbatch",
            "Michael Caine",
            "Kate Winslet",
            "Keira Knightley",
            "Emma Watson"
    };

    HashMap<String, String> actorsInfoMap = new HashMap<String, String>(){{
        put("Hugh Jackman", "Hugh Jackman\n" +
                "Born: Hugh Michael Jackman\n" +
                "12 October 1968");

        put("Benedict Cumberbatch", "Benedict Cumberbatch\n" +
                "Born: Benedict Timothy Carlton Cumberbatch\n" +
                "19 July 1976");

        put("Michael Caine", "Michael Caine\n" +
                "Born: Maurice Joseph Micklewhite Jr.\n" +
                "14 March 1933");

        put("Kate Winslet", "Kate Winslet\n" +
                "Born: Kate Elizabeth Winslet\n" +
                "5 October 1975");

        put("Keira Knightley", "Keira Knightley\n" +
                "Born: Keira Christina Knightley\n" +
                "26 March 1985");

        put("Emma Watson", "Emma Watson\n" +
                "Born: Emma Charlotte Duerre Watson\n" +
                "15 April 1990");
    }};

    String secondActor = "";
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.secondListOfActors);

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
        nextButton = (Button) findViewById(R.id.secondNextButton);
        nextButton.setEnabled(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                secondActor = actors[i];
                nextButton.setEnabled(true);
                for(int a = 0; a < adapterView.getChildCount(); a++)
                {
                    adapterView.getChildAt(a).setBackgroundColor(Color.TRANSPARENT);
                }

                view.setBackgroundColor(Color.parseColor("#b3e5fc"));
            }
        });
    }

    public void goToThirdActivity(View v){
        Intent caller = getIntent();
        String firstActor = caller.getStringExtra("actorName");

        Intent goToThirdActivity = new Intent();
        goToThirdActivity.setClass(this, ThirdActivity.class);
        goToThirdActivity.putExtra("firstActorName", firstActor);
        goToThirdActivity.putExtra("secondActorName", secondActor);
        startActivity(goToThirdActivity);

    }
}
