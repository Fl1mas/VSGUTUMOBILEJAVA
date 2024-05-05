package com.example.vsgutulabs.LB5.NumberBigger;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vsgutulabs.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NumberBiggerGame extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";
    private final int MAX_PLAYERS =6;

    private TextView playerTextView;
    private TextView playercurrentTextView;
    private TextView cardsmoveTextView;

    private Button choiceCardsButton;
    private List<Player>  players;

    private int currentPlayerIndex = 0;

    static final String PLAYERS_KEY = "PLAYERS";
    static final String ACCESS_MESSAGE = "ACCES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bigger_game);
        cardsmoveTextView = findViewById(R.id.cards);
        playerTextView = findViewById(R.id.playerTextView);
        playercurrentTextView = findViewById(R.id.playercurrent);
        choiceCardsButton = findViewById(R.id.choiceCardsButton);

        Intent intent = getIntent();
        int numPlayers = intent.getIntExtra("numPlayers", MAX_PLAYERS);

        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
        for (Player player : players) {
            System.out.println("Player name: " + player.getName());
            System.out.println("Player cards: " + player.getCards());
        }
        printPlayersInfo();
        choiceCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseCards();
                nextPlayerPlay();

            }
        });

    }
    private void chooseCards(){
        int currentPlayer = currentPlayerIndex % players.size();
        Intent intent = new Intent(this, NumberBiggerChoose.class);
        intent.putExtra("currentplayer", currentPlayer);
        intent.putExtra("players", (Serializable) players);
        mStartForResult.launch(intent);
    }
    private void nextPlayerPlay(){
        int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
        playercurrentTextView.setText("Играет " + players.get(nextPlayerIndex).getName());
        currentPlayerIndex = nextPlayerIndex;
    }

    private void printPlayersInfo(){
        StringBuilder playerInfo = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                playerInfo.append("\n");
            }
            playerInfo.append(players.get(i).getName() + ": карточки - " + players.get(i).getCards() + players.get(i).getPickcard());
        }

        playerTextView.setText(playerInfo.toString());
        Log.d(TAG, playerInfo.toString());
    }
    public void assignCardValue(Player player, int cardValue) {
        player.setPickcard(cardValue);
    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        players = (List<Player>) data.getSerializableExtra("players"); // Update the players field
                        printPlayersInfo();
                        // do something with the updated list of players
                    } else
                        System.out.println("Ошибка доступа");
                }
            }
    );

}