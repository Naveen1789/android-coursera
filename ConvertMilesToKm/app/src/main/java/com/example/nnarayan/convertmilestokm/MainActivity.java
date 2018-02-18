package com.example.nnarayan.convertmilestokm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonConMilesToKms = (Button) findViewById(R.id.buttonConvertMilesToKms);
        buttonConMilesToKms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextMiles = (EditText) findViewById(R.id.editTextMiles);
                EditText editTextKms = (EditText) findViewById(R.id.editTextkms);

                double vMiles = Double.valueOf(editTextMiles.getText().toString());
                double vKms = vMiles / 0.62137;
                DecimalFormat format = new DecimalFormat("##.##");

                editTextKms.setText(format.format(vKms));
            }
        });

        Button buttonConKmsToMiles = (Button) findViewById(R.id.buttonConvertKmsToMiles);
        buttonConKmsToMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextMiles = (EditText) findViewById(R.id.editTextMiles);
                EditText editTextKms = (EditText) findViewById(R.id.editTextkms);

                double vKms = Double.valueOf(editTextKms.getText().toString());
                double vMiles = vKms * 0.62137;
                DecimalFormat format = new DecimalFormat("##.##");

                editTextMiles.setText(format.format(vMiles));
            }
        });
    }
}
