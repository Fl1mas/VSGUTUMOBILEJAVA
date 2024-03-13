package com.example.vsgutulabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vsgutulabs.LB1.laba1;
import com.example.vsgutulabs.LB2.laba2;
import com.example.vsgutulabs.LB3.laba3;
import com.example.vsgutulabs.LB4.laba4;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "LIFECYCLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity onCreate");

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП");
        } // Title для приложения(надпись в самом верху)
        setSupportActionBar(toolbar);
    }
    // все что принадлежит верхней части приложения
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
//        }
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.laba1) {
            Intent intent = new Intent(this, laba1.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba2) {
            Intent intent = new Intent(this, laba2.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba3) {
            Intent intent = new Intent(this, laba3.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba4) {
            Intent intent = new Intent(this, laba4.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba5) {
            Intent intent = new Intent(this, laba1.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba6) {
            Intent intent = new Intent(this, laba1.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba7) {
            Intent intent = new Intent(this, laba1.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.laba8) {
            Intent intent = new Intent(this, laba1.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity onStart");

        // Код для выполнения, когда действие становится видимым пользователю
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity onResume");

        // Код, который будет выполняться, когда действие начнет взаимодействовать с пользователем
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity onPause");

        // Код для выполнения, когда действие больше не взаимодействует с пользователем
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity onStop");

        // Код для выполнения, когда действие больше не видно пользователю
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity onDestroy");

        // Код очистки здесь
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "MainActivity onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "MainActivity onRestoreInstanceState");
    }
}