package com.example.bookingapptim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {

    private boolean isPermissions = true;
    private String [] permissions = {
            android.Manifest.permission.INTERNET
    };
    private static final int REQUEST_PERMISSIONS = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, HomeScreen.class);

                startActivity(intent);
            }
        });
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, RegisterScreen.class);

                startActivity(intent);
            }
        });
        onRequestPermission();
    }



    private void onRequestPermission(){
        Log.i("ShopApp", "onRequestPermission");
        ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSIONS);
    }
}