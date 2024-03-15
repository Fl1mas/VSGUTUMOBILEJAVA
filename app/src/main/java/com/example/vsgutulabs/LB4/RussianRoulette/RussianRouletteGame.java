package com.example.vsgutulabs.LB4.RussianRoulette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.vsgutulabs.R;

public class RussianRouletteGame extends AppCompatActivity {

    private final static String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_roulette_game);
        Log.d(TAG, "RussianRouletteGame onCreate");

        Intent intent = getIntent();

        String option1 = intent.getStringExtra("option1");
        String option2 = intent.getStringExtra("option2");
        String option3 = intent.getStringExtra("option3");

        TextView option2TextView = findViewById(R.id.option1TextView);
        option1TextView.setText(option2);


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "RussianRouletteGame onStart");

        // Код для выполнения, когда действие становится видимым пользователю
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "RussianRouletteGame onResume");

        // Код, который будет выполняться, когда действие начнет взаимодействовать с пользователем
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "RussianRouletteGame onPause");

        // Код для выполнения, когда действие больше не взаимодействует с пользователем
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "RussianRouletteGame onStop");

        // Код для выполнения, когда действие больше не видно пользователю
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "RussianRouletteGame onDestroy");

        // Код очистки здесь
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "RussianRouletteGame onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "RussianRouletteGame onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }
}