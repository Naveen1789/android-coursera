package com.example.nnarayan.pairem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    HashMap<String, String[]> actorsToMoviesMap = new HashMap<String, String[]>(){{
        put("Christian Bale", new String[]{"Batman Begins", "The Prestige", "The Dark Knight", "The Dark Knight Rises"});
        put("Leonardo Dicaprio", new String[]{"Titanic", "Catch Me If You Can", "Inception", "Revolutionary Road"});
        put("Jim Carrey", new String[]{"Dumb and Dumber", "The Truman Show", "The Majestic", "Eternal Sunshine of the Spotless Mind"});
        put("Robert Downey Jr", new String[]{"Iron Man", "Sherlock Holmes", "Captain America: Civil War"});
        put("Johnny Depp", new String[]{"Pirates of the Caribbean: The Curse of the Black Pearl", "Pirates of the Caribbean: Dead Man's Chest", "Pirates of the Caribbean: At World's End"});

        put("Hugh Jackman", new String[]{"The Prestige", "The Wolverine", "Les Misérables", "X-Men Origins: Wolverine"});
        put("Benedict Cumberbatch", new String[]{"The Imitation Game"});
        put("Michael Caine", new String[]{"Batman Begins", "The Dark Knight", "The Dark Knight Rises"});
        put("Kate Winslet", new String[]{"Revolutionary Road", "Titanic", "Eternal Sunshine of the Spotless Mind"});
        put("Keira Knightley", new String[]{"Pirates of the Caribbean: The Curse of the Black Pearl", "The Imitation Game", "Pirates of the Caribbean: Dead Man's Chest", "Pirates of the Caribbean: At World's End"});
        put("Emma Watson", new String[]{"Harry Potter and the Philosopher's Stone", "Beauty and the Beast", "Harry Potter and the Chamber of Secrets"});
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent caller = getIntent();
        String firstActorName = caller.getStringExtra("firstActorName");
        String secondActorName = caller.getStringExtra("secondActorName");

        if( actorsToMoviesMap.get(firstActorName) == null) {
            Toast.makeText(getApplicationContext(),
                    "No information available for " + firstActorName,
                    Toast.LENGTH_SHORT).show();
        }
        else if (actorsToMoviesMap.get(secondActorName) == null) {
            Toast.makeText(getApplicationContext(),
                    "No information available for " + secondActorName,
                    Toast.LENGTH_SHORT).show();
        }
        else {
            ArrayList<String> moviesList = new ArrayList<String>();

            for (String movie : actorsToMoviesMap.get(firstActorName)) {
                List<String> moviesOfSecondActor = Arrays.asList(actorsToMoviesMap.get(secondActorName));
                if (moviesOfSecondActor.contains(movie)){
                    moviesList.add(movie);
                }
            }

            if (moviesList.isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        firstActorName + " & " + secondActorName + " have not appeared in any movies together.",
                        Toast.LENGTH_LONG).show();
            }
            else {
                // Getting a reference to listview of main.xml layout file
                ListView listView = ( ListView ) findViewById(R.id.listOfMovies);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, moviesList);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String message = "Hey! I think you will like the movie, " + arrayAdapter.getItem(i) + "!";
                        Uri destination = Uri.parse("smsto:5556");
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination);
                        smsIntent.putExtra("sms_body", message);
                        startActivity(smsIntent);
                    }
                });
            }
        }
    }

    public void goToHome(View v) {
        Intent goToFirstActivity = new Intent();
        goToFirstActivity.setClass(this, FirstActivity.class);
        startActivity(goToFirstActivity);
    }
}
