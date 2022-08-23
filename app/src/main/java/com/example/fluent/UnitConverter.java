package com.example.fluent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UnitConverter extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editTextTextPersonName7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s = editTextTextPersonName7.getText().toString();
                    int kg = Integer.parseInt(s);
                    double pound = 2.205 * kg;
                    textView.setText(kg + "kg is equal to " + pound + " pounds.");
                } catch (Exception e){
                    Toast.makeText(UnitConverter.this, "Enter a digit to calculate.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}