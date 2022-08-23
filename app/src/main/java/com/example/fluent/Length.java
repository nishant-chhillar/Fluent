package com.example.fluent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Length extends AppCompatActivity {
    private Button button8;
    private EditText editTextNumber3;
    private TextView textView11, textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        button8 = findViewById(R.id.button8);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
    }
    public void length(View v) {
        try {
            String a = editTextNumber3.getText().toString();
            int number = Integer.parseInt(a);
            double yard = 1093.61 * number;
            double mile = 0.62 * number;
            textView11.setText("Distance in Mile: " + mile);
            textView12.setText("Distance in Yard: " + yard);
        } catch (Exception e){
            Toast.makeText(this, "Enter a digit to calculate.", Toast.LENGTH_SHORT).show();
        }
    }
}