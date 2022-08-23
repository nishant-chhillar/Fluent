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

public class Login extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fluent-20-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.login);
        Button signup = findViewById(R.id.signup);
        EditText emailAddress = findViewById(R.id.LoginEmailAddress);
        EditText password = findViewById(R.id.LoginPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String passwordTxt = password.getText().toString();
                final String emailaddressTxt = emailAddress.getText().toString();

                if(passwordTxt.isEmpty() || emailaddressTxt.isEmpty()){
                    Toast.makeText(Login.this, "Please fill the required fields.", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(emailaddressTxt)){
                                final String getpassword = snapshot.child(emailaddressTxt).child("password").getValue(String.class);

                                if (getpassword.equals(passwordTxt)){
                                    Toast.makeText(Login.this, "Logged in Sucessfully.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(Login.this, "Wrong Password.", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(Login.this, "Email not found.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}