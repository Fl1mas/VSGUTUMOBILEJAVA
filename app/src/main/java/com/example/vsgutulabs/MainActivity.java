package com.example.vsgutulabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    // все что принадлежит верхней части приложения
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }

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
            Intent intent = new Intent(this, laba1.class);
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
}