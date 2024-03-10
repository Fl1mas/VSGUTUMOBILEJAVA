package com.example.vsgutulabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;

public class laba4 extends AppCompatActivity {

    private final static String TAG = "Activity_laba4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba4);
        Log.d(TAG, "onCreate");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

        // Код для выполнения, когда действие становится видимым пользователю
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

        // Код, который будет выполняться, когда действие начнет взаимодействовать с пользователем
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

        // Код для выполнения, когда действие больше не взаимодействует с пользователем
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

        // Код для выполнения, когда действие больше не видно пользователю
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

        // Код очистки здесь
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "nRestoreInstanceState");
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