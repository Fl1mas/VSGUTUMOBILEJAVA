package com.example.vsgutulabs.LB5.NumberBigger;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.vsgutulabs.LB4.RussianRoulette.RussianRouletteGame;
import com.example.vsgutulabs.R;


public class NumberBiggerOptions extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";

    static final String ACCESS_MESSAGE = "ACCES";
    static final String PLAYERS_KEY = "PLAYERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bigger_options);

        EditText numPlayersEditText = findViewById(R.id.numPlayersEditText);
        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(view -> {
            int numPlayers = Integer.parseInt(numPlayersEditText.getText().toString());

            Intent intent = new Intent(this, NumberBiggerGame.class);
            intent.putExtra("numPlayers", numPlayers);
            startActivity(intent);
        });


    }

}