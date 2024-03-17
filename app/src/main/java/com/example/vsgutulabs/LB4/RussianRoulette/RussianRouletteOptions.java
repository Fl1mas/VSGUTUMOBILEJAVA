package com.example.vsgutulabs.LB4.RussianRoulette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.vsgutulabs.LB4.AuthWindow;
import com.example.vsgutulabs.LB4.Users;
import com.example.vsgutulabs.LB4.UsersManager;
import com.example.vsgutulabs.R;

import java.util.ArrayList;
import java.util.List;

public class RussianRouletteOptions extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";

    EditText options1_players;
    EditText options2_skips;
    EditText options3_shots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_roulette_options);
        Log.d(TAG, "RussianRouletteOptions onCreate");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "RussianRouletteOptions onStart");
        // Код для выполнения, когда действие становится видимым пользователю
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "RussianRouletteOptions onResume");

        // Код, который будет выполняться, когда действие начнет взаимодействовать с пользователем
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "RussianRouletteOptions onPause");

        // Код для выполнения, когда действие больше не взаимодействует с пользователем
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "RussianRouletteOptions onStop");

        // Код для выполнения, когда действие больше не видно пользователю
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "RussianRouletteOptions onDestroy");

        // Код очистки здесь
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "RussianRouletteOptions onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "RussianRouletteOptions onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }

    public void StartGame(View view) {
        options1_players = findViewById(R.id.RuRo_options1);
        options2_skips = findViewById(R.id.RuRo_options2);
        options3_shots = findViewById(R.id.RuRo_options3);

        String _options1 = options1_players.getText().toString();
        String _options2 = options2_skips.getText().toString();
        String _options3 = options3_shots.getText().toString();

        List<String> players = new ArrayList<>();
        for (int i = 0; i <  Integer.parseInt(_options1); i++){
            players.add("Игрок " + (i +1));
        }

        Intent intent = new Intent(this, RussianRouletteGame.class);
        intent.putStringArrayListExtra("players", (ArrayList<String>) players);
        intent.putExtra("num_players", _options1);
        intent.putExtra("num_skips", _options2);
        intent.putExtra("num_reloads", _options3);

        startActivity(intent);
    }
}