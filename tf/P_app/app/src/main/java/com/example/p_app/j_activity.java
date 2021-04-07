package com.example.p_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class j_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_activity);

        Intent intent = getIntent();
        this.setTitle("Sergio Cechin/Nome Aluno");
        String message = intent.getStringExtra("message");
    }
}