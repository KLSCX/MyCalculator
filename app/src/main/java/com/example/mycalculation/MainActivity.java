package com.example.mycalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button = (ImageButton) findViewById(R.id.btn6);
        button.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,UserActivity.class);
            startActivity(intent);
        });
    }
}