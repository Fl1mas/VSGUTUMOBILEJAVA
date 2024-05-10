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
    private TextView infoscoreTextView;

    private Button choiceCardsButton;
    private List<Player>  players;

    private int currentPlayerIndex = 0;
    private boolean allPlayersHaveChosen = false;

    static final String PLAYERS_KEY = "PLAYERS";
    static final String ACCESS_MESSAGE = "ACCES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bigger_game);
        infoscoreTextView = findViewById(R.id.infoscore);
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
                printPlayersInfo();

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
    private void whoHaveBigCard(){
        if (allPlayersHaveChosen) {
            Player playerWithHighestCard = getPlayerWithHighestCard(players);
            if (playerWithHighestCard != null) {
                playerWithHighestCard.setScore(playerWithHighestCard.getScore());
                infoscoreTextView.setText("Игрок " + playerWithHighestCard.getName() + " получает одно очко ");
                checkForWinner();
            } else {
                System.out.println("No players have picked a card.");
            }
            resetPlayerCards();
            allPlayersHaveChosen = false;
        }

    }

    private void resetPlayerCards() {
        for (Player player : players) {
            player.setPickcard(0);
        }
    }
    private void checkForWinner() {
        for (Player player : players) {
            if (player.getScore() >= 5) {
                infoscoreTextView.setText("Игрок " + player.getName() + " выиграл!");
                // Game over, do something here
                return;
            }
        }
    }
    private void nextPlayerPlay(){
        int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
        playercurrentTextView.setText("Играет " + players.get(nextPlayerIndex).getName());
        currentPlayerIndex = nextPlayerIndex;
        if (nextPlayerIndex == 0) {
            allPlayersHaveChosen = true;
        }
    }

    private void printPlayersInfo(){
        StringBuilder playerInfo = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            if (i > 0) {
                playerInfo.append("\n");
            }
            playerInfo.append(players.get(i).getName()
                    + ": карточки - " + players.get(i).getCards()
                    + players.get(i).getPickcard()
                    + " Очков:" + players.get(i).getScore());
        }

        playerTextView.setText(playerInfo.toString());
        Log.d(TAG, playerInfo.toString());
    }

    public Player getPlayerWithHighestCard(List<Player> players) {
        Player playerWithHighestCard = null;
        int highestCard = 0;
        for (Player player : players) {
            int currentCard = player.getPickcard();
            if (currentCard > highestCard) {
                highestCard = currentCard;
                playerWithHighestCard = player;
            }

        }
        if (playerWithHighestCard != null) {
            playerWithHighestCard.setScore(playerWithHighestCard.getScore() + 1);
        }
        return playerWithHighestCard;
    }
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        players = (List<Player>) data.getSerializableExtra("players"); // Update the players field

                        whoHaveBigCard();
                        printPlayersInfo();
                    } else
                        System.out.println("Ошибка доступа");
                }
            }
    );
    // реализуй удаление выбранной карточки
}