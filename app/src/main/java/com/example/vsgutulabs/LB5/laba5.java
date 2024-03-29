package com.example.vsgutulabs.LB5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;

import com.example.vsgutulabs.R;

public class laba5 extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba5);
        Log.d(TAG, "activity_laba5 onCreate");


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