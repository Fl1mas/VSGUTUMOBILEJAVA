package com.example.vsgutulabs.LB4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vsgutulabs.R;

public class AuthWindow extends AppCompatActivity {

    private final static String TAG = "LIFECYCLE";

    TextView Nickname;
    TextView Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_window);
        Log.d(TAG, "AuthWindow onCreate");

        Nickname = findViewById(R.id.nickname);
        Password = findViewById(R.id.password);

        Bundle arguments = getIntent().getExtras();
        final Users users;
        if(arguments != null){
            users = (Users) arguments.getSerializable
                    (Users.class.getSimpleName());
        Nickname.setText("Nickname: " + users.getNickname());
        Password.setText("Password: " + users.getPassword());

        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "AuthWindow onStart");

        // Код для выполнения, когда действие становится видимым пользователю
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "AuthWindow onResume");

        // Код, который будет выполняться, когда действие начнет взаимодействовать с пользователем
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "AuthWindow onPause");

        // Код для выполнения, когда действие больше не взаимодействует с пользователем
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "AuthWindow onStop");

        // Код для выполнения, когда действие больше не видно пользователю
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "AuthWindow onDestroy");

        // Код очистки здесь
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "AuthWindow onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "AuthWindow onRestoreInstanceState");
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }

    public void _btnBack(View view) {
        finish();
    }
}