package com.example.nnarayan.sounddemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this, R.raw.applause);
        Switch switchToLoop = (Switch) findViewById(R.id.switch_to_loop);
        switchToLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                music.setLooping(b);
            }
        });
    }

    public void playMusic(View v){
        music.start();
    }

    public void stopMusic(View v){
        if(music.isPlaying()){
            music.pause();
        }
    }
}
