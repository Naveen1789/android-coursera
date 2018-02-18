package com.example.nnarayan.buttonsandtoasts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_for_invisible_man, button_for_pink_panther, button_for_lfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_for_invisible_man = (Button) findViewById(R.id.button_for_invisible_man);
        button_for_pink_panther = (Button) findViewById(R.id.button_for_pink_panther);
        button_for_lfc = (Button) findViewById(R.id.button_for_lfc);
        button_for_lfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Champions league!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toDo(View view) {
        if(view == button_for_invisible_man){
            view.setVisibility(View.INVISIBLE);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "to do, to do, to do",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
