package com.example.vsgutulabs.LB4.RussianRoulette;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vsgutulabs.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RussianRouletteGame extends AppCompatActivity {

    private final static String TAG = "LIFECYCLE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_roulette_game);
        Log.d(TAG, "RussianRouletteGame onCreate");

        Button shootButton = findViewById(R.id.RuRo_btn_shot);
        TextView PlayPlayer = findViewById(R.id.RuRo_PlayPlayer);

        Intent intent = getIntent();

        String PLAYERS = intent.getStringExtra("num_players");
        String SKIPS = intent.getStringExtra("num_skips");
        String RELOADS = intent.getStringExtra("num_reloads");

        int numPlayers = Integer.parseInt(PLAYERS);
        int numSkips = Integer.parseInt(SKIPS);
        int numReloads = Integer.parseInt(RELOADS);

        ArrayList<String> players = intent.getStringArrayListExtra("players");


        Button skips = findViewById(R.id.RuRo_btn_options2);
        Button reloads = findViewById(R.id.RuRo_btn_options3);
        skips.setText("Пропустить ход (" + SKIPS + ")");
        reloads.setText("Пропустить ход (" + RELOADS + ")");

        TextView ListPlayer = findViewById(R.id.RuRo_ListPlayer);
        StringBuilder playerList = new StringBuilder();
        for (int i = 0; i < players.size(); i++){
            playerList.append((i + 1)).append(". ").append(players.get(i)).append("\n");
        }
        ListPlayer.setText(playerList.toString());
        TextView resultshot = findViewById(R.id.RuRo_resultShot);


        while (players.size() < 1){
            for ( int i = 0; i < players.size() ; i++){
                PlayPlayer.setText(players.get(i));


            }
        }
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