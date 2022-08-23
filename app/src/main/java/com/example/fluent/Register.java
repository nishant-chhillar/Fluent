package com.example.fluent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fluent-20-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.signup);
        EditText fullname = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        EditText emailAddress = findViewById(R.id.editTextTextEmailAddress);
        EditText phone = findViewById(R.id.editTextPhone);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String fullnameTxt = fullname.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String emailaddressTxt = emailAddress.getText().toString();
                final String phoneTxt = phone.getText().toString();

                if(fullnameTxt.isEmpty() || passwordTxt.isEmpty() || emailaddressTxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill the required fields.", Toast.LENGTH_SHORT).show();
                }

                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt) && !phoneTxt.isEmpty()) {
                                    Toast.makeText(Register.this, "Phone number is already registered.", Toast.LENGTH_SHORT).show();
                                }
                            else if(snapshot.hasChild(emailaddressTxt)){
                                Toast.makeText(Register.this, "Email Address already registered.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                databaseReference.child("users").child(emailaddressTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(emailaddressTxt).child("email").setValue(emailaddressTxt);
                                databaseReference.child("users").child(emailaddressTxt).child("password").setValue(passwordTxt);
                                databaseReference.child("users").child(emailaddressTxt).child("phone").setValue(phoneTxt);
                                Toast.makeText(Register.this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

    }
}