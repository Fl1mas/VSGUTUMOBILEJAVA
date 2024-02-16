package com.example.vsgutulabs;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import java.util.Arrays;

import java.util.List;



public class laba2 extends AppCompatActivity {

    private String currentNumber = "0";
    private TextView numberTextView;
//=====

    private TextView countXwin;
    private TextView countYwin;
    private int winCounterX = 0;
    private int winCounterO = 0;


private String currentPlayer = "X";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba2);

        //===

        countXwin = findViewById(R.id.scorex);
        countYwin = findViewById(R.id.scorey);
        //==
        numberTextView = findViewById(R.id.result);

        Button plusOneButton = findViewById(R.id.btn_plus1);
        plusOneButton.setOnClickListener(v -> incrementNumber("1"));

        Button minusOneButton = findViewById(R.id.btn_minus1);
        minusOneButton.setOnClickListener(v -> decrementNumber("1"));

        Button plusTwoButton = findViewById(R.id.btn_plus2);
        plusTwoButton.setOnClickListener(v -> incrementNumber("2"));

        Button minusTwoButton = findViewById(R.id.btn_minus2);
        minusTwoButton.setOnClickListener(v -> decrementNumber("2"));

    }
    //====
    private boolean checkRowWin(Button b1, Button b2, Button b3) {
        return (b1.getText().toString().equals(b2.getText().toString()) &&
                b1.getText().toString().equals(b3.getText().toString()) &&
                !b1.getText().toString().equals(""));
    }
    private boolean checkColWin(Button b1, Button b2, Button b3) {
        return (b1.getText().toString().equals(b2.getText().toString()) &&
                b1.getText().toString().equals(b3.getText().toString()) &&
                !b1.getText().toString().equals(""));
    }
    private boolean checkDiagWin(Button b1, Button b2, Button b3) {
        return (b1.getText().toString().equals(b2.getText().toString()) &&
                b1.getText().toString().equals(b3.getText().toString()) &&
                !b1.getText().toString().equals(""));
    }
    private boolean checkWin(Button b1, Button b2, Button b3, Button b4, Button b5,
                             Button b6, Button b7, Button b8, Button b9) {
        if (checkRowWin(b1, b2, b3) || checkRowWin(b4, b5, b6) || checkRowWin(b7, b8, b9)) {
            return true;
        }
        if (checkColWin(b1, b4, b7) || checkColWin(b2, b5, b8) || checkColWin(b3, b6, b9)) {
            return true;
        }
        if (checkDiagWin(b1, b5, b9) || checkDiagWin(b3, b5, b7)) {
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        Button button = (Button) view;
        if (button.getText().toString().equals("")) {
            button.setText(currentPlayer);
            int moves = countMoves();
            if (moves == 9) {
                // Check for a draw
                Toast.makeText(this, "Ничья!", Toast.LENGTH_SHORT).show();
                blockcell();
                return;
            }
            if (checkWin(findViewById(R.id.cell1), findViewById(R.id.cell2), findViewById(R.id.cell3),
                    findViewById(R.id.cell4), findViewById(R.id.cell5), findViewById(R.id.cell6),
                    findViewById(R.id.cell7), findViewById(R.id.cell8), findViewById(R.id.cell9))) {
                Toast.makeText(this, "Игрок " + currentPlayer + " победил!", Toast.LENGTH_SHORT).show();
                if (currentPlayer.equals("X")) {
                    winCounterX++;
                    countXwin.setText("Кол-во побед X:" + winCounterX);
                }
                if (currentPlayer.equals("O")) {
                    winCounterO++;
                    countYwin.setText("Кол-во побед O:" + winCounterO);
                }
                blockcell();
            } else {
                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            }
        }
    }
    private int countMoves() {
        int moves = 0;
        List<Button> buttons = Arrays.asList(
                findViewById(R.id.cell1),
                findViewById(R.id.cell2),
                findViewById(R.id.cell3),
                findViewById(R.id.cell4),
                findViewById(R.id.cell5),
                findViewById(R.id.cell6),
                findViewById(R.id.cell7),
                findViewById(R.id.cell8),
                findViewById(R.id.cell9)
        );
        for (Button button : buttons) {
            if (!button.getText().toString().equals("")) {
                moves++;
            }
        }
        return moves;
    }
    private void blockcell(){
        List<Button> buttons = Arrays.asList(
                findViewById(R.id.cell1),
                findViewById(R.id.cell2),
                findViewById(R.id.cell3),
                findViewById(R.id.cell4),
                findViewById(R.id.cell5),
                findViewById(R.id.cell6),
                findViewById(R.id.cell7),
                findViewById(R.id.cell8),
                findViewById(R.id.cell9)
        );
        for (Button cellbutton : buttons) {
            cellbutton.setEnabled(false);
        }
    }
    public void onNewGameClick(View view) {
        List<Button> buttons = Arrays.asList(
                findViewById(R.id.cell1),
                findViewById(R.id.cell2),
                findViewById(R.id.cell3),
                findViewById(R.id.cell4),
                findViewById(R.id.cell5),
                findViewById(R.id.cell6),
                findViewById(R.id.cell7),
                findViewById(R.id.cell8),
                findViewById(R.id.cell9)
        );
        for (Button button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
    }
//====


    private void incrementNumber(String increment) {
        currentNumber = String.valueOf(Integer.parseInt(currentNumber) + Integer.parseInt(increment));
        numberTextView.setText(currentNumber);
    }

    private void decrementNumber(String decrement) {
        currentNumber = String.valueOf(Integer.parseInt(currentNumber) - Integer.parseInt(decrement));
        numberTextView.setText(currentNumber);
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
