package com.example.vsgutulabs.LB4.RussianRoulette;
import com.example.vsgutulabs.LB4.RussianRoulette.Revolver;

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
import android.widget.LinearLayout;
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

    private TextView playercurrentTextView;
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
        playercurrentTextView = findViewById(R.id.playercurrent);
        playerTextView = findViewById(R.id.playerTextView);
        shotButton = findViewById(R.id.shotButton);
        skipButton = findViewById(R.id.skipButton);
        reloadButton = findViewById(R.id.reloadButton);


        Intent intent = getIntent();

        numPlayers = intent.getIntExtra("numPlayers", MAX_PLAYERS);
        skipsPerPlayer = intent.getIntExtra("skipsPerPlayer", DEFAULT_SKIPS);
        reloadsPerPlayer = intent.getIntExtra("reloadsPerPlayer", DEFAULT_RELOADS);

        revolver = new Revolver();

        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1), skipsPerPlayer, reloadsPerPlayer));
        }


        shotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shootRevolver();
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipTurn();
            }
        });
        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloads();
            }
        });


        printPlayersInfo();

    }
    private void shootRevolver() {
        Player currentPlayer = players.get(currentPlayerIndex);
            if (revolver.shoot()) {
                // Player got shot
                playercurrentTextView.setText("Игрок " + currentPlayer.getName() + " погиб!");
                currentPlayer.setEliminated(true);
                printPlayersInfo();

                // Update the current player index
                nextPlayerPlay();
                revolver.reload();
                checkWinner();
            } else {
                // No bullet in the chamber
                nextPlayerPlay();

            }



    }
    private void skipTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);

        if (currentPlayer.getSkips() > 0) {
            // Skip the current player's turn
            playercurrentTextView.setText("Игрок " + currentPlayer.getName() + " пропустил ход.");

            currentPlayer.useSkip();
            printPlayersInfo();

            // Update the current player index
            nextPlayerPlay();

            // Check if the current player has used up all their skips
            if (currentPlayer.getSkips() == 0) {
                //Toast.makeText(this, "Игрок " + currentPlayer.getName() + " не может больше пропускать ходы.", Toast.LENGTH_SHORT).show();
                skipButton.setEnabled(true);
            }
            printPlayersInfo();

        } else {
            // The current player has used up all their skips
            Toast.makeText(this, "Игрок " + currentPlayer.getName() + " не может больше пропускать ходы.", Toast.LENGTH_SHORT).show();
        }
    }
    private void reloads(){
        Player currentPlayer = players.get(currentPlayerIndex);

        if (currentPlayer.getSkips() > 0) {
            // Skip the current player's turn
            playercurrentTextView.setText("Игрок " + currentPlayer.getName() + " перезарядился.");

            currentPlayer.useReload();
            printPlayersInfo();

            // Update the current player index
            revolver.reload();

            // Check if the current player has used up all their skips
            if (currentPlayer.getSkips() == 0) {
                Toast.makeText(this, "Игрок " + currentPlayer.getName() + " не может больше перезаряжаться.", Toast.LENGTH_SHORT).show();
                reloadButton.setEnabled(true);
            }
            printPlayersInfo();

        } else {
            // The current player has used up all their skips
            Toast.makeText(this, "Игрок " + currentPlayer.getName() + " не может больше перезаряжаться.", Toast.LENGTH_SHORT).show();
        }

    }



    private void printPlayersInfo(){
        StringBuilder playerInfo = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                playerInfo.append("\n");
            }
            playerInfo.append(players.get(i).getName() + ": Skips - " + players.get(i).getMissedTurns() + "," + " Reloads - "
                    + players.get(i).getReloads() + ", No Alive? - " + players.get(i).isEliminated());
        }

        playerTextView.setText(playerInfo.toString());
        Log.d(TAG, playerInfo.toString());
    }
    private void nextPlayerPlay(){
        do {
            int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayerIndex = nextPlayerIndex;
        } while (players.get(currentPlayerIndex).isEliminated());

        playercurrentTextView.setText("Играет " + players.get(currentPlayerIndex).getName());
    }
//        int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
//        playercurrentTextView.setText("Играет " + players.get(nextPlayerIndex).getName());
//        currentPlayerIndex = nextPlayerIndex;
//    }
    private void checkWinner(){
        int numPlayersLeft = 0;
        for (Player player : players) {
            if (!player.isEliminated()) {
                numPlayersLeft++;
            }
        }

        if (numPlayersLeft == 1) {
            // There is only one player left who has not been eliminated
            Player winner = players.get(0);
            for (Player player : players) {
                if (!player.isEliminated()) {
                    winner = player;
                }
            }
            playercurrentTextView.setText("\nИгра окончена! Победил игрок " + winner.getName() + "!");
            shotButton.setEnabled(false);
            skipButton.setEnabled(false);
            reloadButton.setEnabled(false);
            Toast.makeText(this, "Чтобы начать заново нажмите на любое место на экране", Toast.LENGTH_SHORT).show();
            endGame();
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    private void endGame(){
        LinearLayout rootView = findViewById(R.id.root_view);
        rootView.setOnTouchListener((view, event) -> {
            finish();
            return true;
        });
    }
}


