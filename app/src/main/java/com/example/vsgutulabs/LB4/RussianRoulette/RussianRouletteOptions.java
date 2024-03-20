package com.example.vsgutulabs.LB4.RussianRoulette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vsgutulabs.LB4.AuthWindow;
import com.example.vsgutulabs.LB4.Users;
import com.example.vsgutulabs.LB4.UsersManager;
import com.example.vsgutulabs.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class RussianRouletteOptions extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";
    private final int MAX_PLAYERS =6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_roulette_options);
        Log.d(TAG, "RussianRouletteOptions onCreate");

        EditText numPlayersEditText = findViewById(R.id.numPlayersEditText);
        Spinner skipsPerPlayerSpinner = findViewById(R.id.skipsPerPlayerSpinner);
        Spinner reloadsPerPlayerSpinner = findViewById(R.id.reloadsPerPlayerSpinner);
        Button startButton = findViewById(R.id.startButton);

        // Set the start button onClick listener
        startButton.setOnClickListener(view -> {
            int numPlayers = Integer.parseInt(numPlayersEditText.getText().toString());
            int skipsPerPlayer = (int) skipsPerPlayerSpinner.getSelectedItemId() + 1;
            int reloadsPerPlayer = (int) reloadsPerPlayerSpinner.getSelectedItemId() + 1;

            // Return to the MainActivity with the user input
            Intent intent = new Intent(this, RussianRouletteGame.class);
            intent.putExtra("numPlayers", numPlayers);
            intent.putExtra("skipsPerPlayer", skipsPerPlayer);
            intent.putExtra("reloadsPerPlayer", reloadsPerPlayer);
            startActivity(intent);
        });
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
