package com.example.fluent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    private Button button2;
    private TextView textView9;
    private EditText editTextNumber, editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        button2 = findViewById(R.id.button2);
        textView9 = findViewById(R.id.textView9);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String a = editTextNumber.getText().toString();
                    String b = editTextNumber2.getText().toString();
                    int number1 = Integer.parseInt(a);
                    int number2 = Integer.parseInt(b);
                    int sum = number1 + number2;
                    textView9.setText("Sum: " + sum);
                } catch (Exception e){
                    Toast.makeText(Calculator.this, "Enter number/s to calculate.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}