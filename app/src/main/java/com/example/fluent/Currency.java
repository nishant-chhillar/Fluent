package com.example.fluent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Currency extends AppCompatActivity {
    private Button button9;
    private EditText editTextNumber4;
    private TextView textView15, textView17, textView18, textView19, textView20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        button9 = findViewById(R.id.button9);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        textView15 = findViewById(R.id.textView15);
        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s = editTextNumber4.getText().toString();
                    int rupee = Integer.parseInt(s);
                    double pounds = 0.011 * rupee;
                    double yen = 1.72 * rupee;
                    double dollar = 0.013 * rupee;
                    double dinar = 0.0038 * rupee;
                    double euro = 0.013 * rupee;
                    textView15.setText("Current value in Pounds: " + pounds);
                    textView17.setText("Current value in Yen: " + yen);
                    textView18.setText("Current value in Euro: " + euro);
                    textView19.setText("Current value in Kuwaiti Dinar: " + dinar);
                    textView20.setText("Current value in US Dollar: " + dollar);
                } catch (Exception e){
                    Toast.makeText(Currency.this, "Enter a digit to calculate.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}