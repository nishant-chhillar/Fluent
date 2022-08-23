package com.example.fluent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        Button enterbtn = findViewById(R.id.enterbtn);
        TextView textView23 = findViewById(R.id.textView23);

        enterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView23.setText("                                        .\n" +
                        ".........................................\n" +
                        " ........................................\n" +
                        " ........................................\n" +
                        " ........................................\n" +
                        " ..........                             .\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........                        .\n" +
                        " ...................................\n" +
                        " ...................................\n" +
                        " ...................................\n" +
                        " ..........                        .\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        " ..........\n" +
                        "............");
            }
        });
    }
}