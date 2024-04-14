package com.example.nothings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    ImageView logout,aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        logout = findViewById(R.id.logout);
        aboutus = findViewById(R.id.about_us);

        logout.setOnClickListener(v -> {
            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });

        aboutus.setOnClickListener(v -> {
//            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent);
        });


    }
}