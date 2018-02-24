package com.example.nnarayan.webpagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker picker;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (NumberPicker) findViewById(R.id.numberPicker);
        webView = (WebView) findViewById(R.id.webView);

        String[] options= {"Android", "Coursera - wiki", "Coursera - Home", "Superlec"};

        picker.setDisplayedValues(options);
        picker.setMinValue(0);
        picker.setMaxValue(options.length - 1);
    }

    public void navigate(View v){
        int optionPicked = picker.getValue();
        if (optionPicked == 1) {
//          // Avoids that links open into a browser activity.
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("file:///android_asset/coursera.html");
        }
        if (optionPicked == 2) {
            webView.loadUrl("http://www.coursera.org");
        }
    }
}
