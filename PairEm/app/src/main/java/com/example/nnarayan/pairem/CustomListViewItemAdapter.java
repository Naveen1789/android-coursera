package com.example.nnarayan.pairem;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nnarayan on 2/22/18.
 */

public class CustomListViewItemAdapter extends SimpleAdapter {

    LayoutInflater inflater;
    Context context;
    ArrayList<HashMap<String, String>> arrayList;

    public CustomListViewItemAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;
        inflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        ImageView info = (ImageView) view.findViewById(R.id.info_button);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = arrayList.get(position).get("info");
                if(info == null || info.equals("")){
                  info = "No information available.";
                }
                Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
            }
        });

        final ImageView likeButton = (ImageView) view.findViewById(R.id.like_button);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String actorName = arrayList.get(position).get("name");

                SharedPreferences preferences = context.getSharedPreferences("ActorPreferences", Context.MODE_PRIVATE);
                final SharedPreferences.Editor editor = preferences.edit();

                if (preferences.contains(actorName)) {
                    Boolean likesActor = preferences.getBoolean(actorName, false);
                    Boolean updatedPreference = !likesActor;

                    if (updatedPreference){
                        likeButton.setImageResource(R.drawable.like_button_yes);
                    }
                    else {
                        likeButton.setImageResource(R.drawable.like_button_no);
                    }
                    editor.putBoolean(actorName, updatedPreference);
                    editor.commit();
                }
                else {
                    likeButton.setImageResource(R.drawable.like_button_yes);
                    editor.putBoolean(actorName, true);
                    editor.commit();
                }
            }
        });
        return view;
    }
}
