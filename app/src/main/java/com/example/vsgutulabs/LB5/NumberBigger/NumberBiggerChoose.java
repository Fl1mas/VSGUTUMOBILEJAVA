package com.example.vsgutulabs.LB5.NumberBigger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vsgutulabs.LB5.laba5;
import com.example.vsgutulabs.R;

import java.io.Serializable;
import java.util.List;

public class NumberBiggerChoose extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";
    private TextView currentplayerTextView;
    static final String ACCESS_MESSAGE = "ACCES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_bigger_choose);

        currentplayerTextView = findViewById(R.id.currentplayerTextView);
        LinearLayout cardContainer = findViewById(R.id.cardContainer);

        Intent intent = getIntent();
        List<Player> players = (List<Player>) intent.getSerializableExtra("players");
        int currentPlayerIndex = intent.getIntExtra("currentplayer", -1);

        Player currentPlayer = players.get(currentPlayerIndex);
        String currentPlayerName = currentPlayer.getName();

        TextView currentPlayerTextView = findViewById(R.id.currentplayerTextView);
        currentPlayerTextView.setText(currentPlayerName + " " + (currentPlayerIndex + 1));


        for (int i = 0; i < currentPlayer.getCards().size(); i++) {
            for (int j = 0; j < currentPlayer.getCards().size(); j++) {
                int card = currentPlayer.getCards().get(j);
                Button cardButton = new Button(this);

                cardButton.setText(String.valueOf(card));
                cardButton.setId(i);
                cardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String numbercard = ((Button) v).getText().toString();
                    int pickcardValue = Integer.parseInt(numbercard);

                    currentPlayer.setPickcard(pickcardValue);

                    currentPlayer.removeCard(pickcardValue);

                    players.set(currentPlayerIndex, currentPlayer);
                    for (Player player : players) {
                        System.out.println("Player name: " + player.getName());
                        System.out.println("Player cards: " + player.getCards());
                        System.out.println("Players PickCard: " + player.getPickcard());
                    }
                    Intent intent = new Intent();
                    intent.putExtra("players", (Serializable) players);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                });

                cardContainer.addView(cardButton);
            }
        }

    }
}