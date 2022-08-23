package com.example.fluent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Settings extends AppCompatActivity {
    private FloatingActionButton developersbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button rate = findViewById(R.id.rate);
        FloatingActionButton developersbtn = findViewById(R.id.developersbtn);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        WebView webView = (WebView) findViewById(R.id.webView2);
        webView.loadUrl("file:///android_asset/index.html");

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingBar.setRating(5);
                ratingBar.setEnabled(false);
            }
        });
        developersbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(Settings.this, Developer.class);
                startActivity(intent);
            }
        });
    }
}