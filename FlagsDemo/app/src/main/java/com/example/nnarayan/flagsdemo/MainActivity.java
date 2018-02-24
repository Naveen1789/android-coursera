package com.example.nnarayan.flagsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] football_clubs = {
            "Liverpool",
            "Barcelona",
            "Real Madrid",
            "Bayern Munich",
            "AC Milan"
    };

    int[] flags = new int[]{
            R.drawable.liverpool,
            R.drawable.barcelona,
            R.drawable.real_madrid,
            R.drawable.bayern_munich,
            R.drawable.ac_milan
    };

    String[] captains = {
            "Gerrard",
            "Messi",
            "Alonso",
            "Neuer",
            "Ronaldinho"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Each row in the list stores a club name, its captain and an image
        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<5;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("club", "Club : " + football_clubs[i]);
            hm.put("player","Captain : " + captains[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            list.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","club","player" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.football_club,R.id.captain};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), list, R.layout.list_item_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
    }
}
