package com.example.vsgutulabs.LB4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.vsgutulabs.R;
import com.example.vsgutulabs.LB4.Users;

public class laba4 extends AppCompatActivity {

    EditText Nickname;
    EditText Password;

    private final static String TAG = "LIFECYCLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba4);
        Log.d(TAG, "activity_laba4 onCreate");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "activity_laba4 onStart");

        // Код для выполнения, когда действие становится видимым пользователю
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "activity_laba4 onResume");

        // Код, который будет выполняться, когда действие начнет взаимодействовать с пользователем
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "activity_laba4 onPause");

        // Код для выполнения, когда действие больше не взаимодействует с пользователем
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "activity_laba4 onStop");

        // Код для выполнения, когда действие больше не видно пользователю
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "activity_laba4 onDestroy");

        // Код очистки здесь
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "activity_laba4 onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "activity_laba4 onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }
    public void _btnAuth(View view) {
        Nickname = findViewById(R.id.nickname);
        Password = findViewById(R.id.password);

        String nickname = Nickname.getText().toString();
        String password = Password.getText().toString();

        Users users = UsersManager.findUserByCredentials(nickname, password);
        if (users != null) {
            Intent intent = new Intent(this, AuthWindow.class);
            intent.putExtra(Users.class.getSimpleName(), users);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, AuthWindow.class);
            startActivity(intent);
        }



    }
}