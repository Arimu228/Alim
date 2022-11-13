package com.example.almi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {
TextView numberTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);
numberTextView = findViewById(R.id.number_tv);

        Intent intent = getIntent();

        numberTextView.setText(intent.getStringExtra("key"));



    }
}