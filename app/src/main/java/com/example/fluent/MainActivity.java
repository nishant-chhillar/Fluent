package com.example.fluent;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton, floatingActionButton2, floatingActionButton3;
    ActivityResultLauncher<String[]> mPermissionResultLauncher;
    private boolean isNetworkPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton2 = findViewById(R.id.floatingActionButton2);
        floatingActionButton3 = findViewById(R.id.floatingActionButton3);
        mPermissionResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {
                if (result.get(Manifest.permission.INTERNET)!=null){
                    isNetworkPermissionGranted = result.get(Manifest.permission.INTERNET);
                }
            }
        });
        RequestPermission();
    }
    public void CalculatorScreen(View v){
        Intent intent = new Intent(this,Calculator.class);
        startActivity(intent);
    }
    public void UnitConverterScreen(View v){
        Intent intent = new Intent(this,UnitConverter.class);
        startActivity(intent);
    }
    public void CurrencyScreen(View v){
        Intent intent = new Intent(this,Currency.class);
        startActivity(intent);
    }
    public void LengthScreen(View v){
        Intent intent = new Intent(this,Length.class);
        startActivity(intent);
    }
    public void moreOptions(View v) {
        while (true) {
            floatingActionButton2.setVisibility(VISIBLE);
            floatingActionButton3.setVisibility(VISIBLE);

            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    floatingActionButton2.setVisibility(INVISIBLE);
                    floatingActionButton3.setVisibility(INVISIBLE);
                }
            });break;
        }
    }

    public void settings(View v){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }

    public void mail(View v){
        Toast.makeText(this, "Mail will be available soon.", Toast.LENGTH_SHORT).show();
    }

    public void ExitApp(View v){
        finish();
        System.exit(0);
    }


    private void RequestPermission(){

        isNetworkPermissionGranted = ContextCompat.checkSelfPermission(
                this, Manifest.permission.INTERNET)
                == PackageManager.PERMISSION_GRANTED;

        List<String> permissionRequest = new ArrayList<String>();

        if(!isNetworkPermissionGranted){
            permissionRequest.add(Manifest.permission.INTERNET);
        }
        if(!permissionRequest.isEmpty()){
            mPermissionResultLauncher.launch(permissionRequest.toArray(new String[0]));
        }
    }
}