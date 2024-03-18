package com.example.vsgutulabs.LB4.RussianRoulette;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
public class RussianRouletteGame extends AppCompatActivity {

    private final static String TAG = "LIFECYCLE";
    private static final int MAX_PLAYERS = 6;
    private static final int DEFAULT_SKIPS = 1;
    private static final int DEFAULT_RELOADS = 1;

    private TextView playerTextView;
    private Button shotButton;
    private Button skipButton;
    private Button reloadButton;

    private int numPlayers;
    private int skipsPerPlayer;
    private int reloadsPerPlayer;

    private List<Player> players;
    private Revolver revolver;
    private int currentPlayerIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_roulette_game);

        // Initialize UI elements
        playerTextView = findViewById(R.id.playerTextView);
        shotButton = findViewById(R.id.shotButton);
        skipButton = findViewById(R.id.skipButton);
        reloadButton = findViewById(R.id.reloadButton);

        Intent intent = getIntent();

        numPlayers = intent.getIntExtra("numPlayers", MAX_PLAYERS);
        skipsPerPlayer = intent.getIntExtra("skipsPerPlayer", DEFAULT_SKIPS);
        reloadsPerPlayer = intent.getIntExtra("reloadsPerPlayer", DEFAULT_RELOADS);

        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1), skipsPerPlayer, reloadsPerPlayer));
        }

        shotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (revolver.fire()) {
                    // Player is out of the game
                    players.remove(currentPlayerIndex);
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                    revolver.reload();
                } else {
                    // Move to the next chamber
                    revolver.nextChamber();
                }
                updatePlayerTextView();
            }
        });

















        StringBuilder playerInfo = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                playerInfo.append("\n");
            }
            playerInfo.append(players.get(i).getName() + ": Skips - " + skipsPerPlayer + ", Reloads - " + reloadsPerPlayer);
        }

        playerTextView.setText(playerInfo.toString());
        Log.d(TAG, playerInfo.toString());
    }
    private void updatePlayerTextView() {
        StringBuilder playerInfo = new StringBuilder();
        playerInfo.append("Current player: " + players.get(currentPlayerIndex).getName());
        playerInfo.append("\nSkips remaining: " + players.get(currentPlayerIndex).getMissedTurns());
        playerInfo.append("\nReloads remaining: " + players.get(currentPlayerIndex).getReloads());
        playerTextView.setText(playerInfo.toString());
    }
}

