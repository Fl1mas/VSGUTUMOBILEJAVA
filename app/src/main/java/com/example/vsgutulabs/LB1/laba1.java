package com.example.vsgutulabs.LB1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vsgutulabs.R;

public class laba1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba1);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }
    @SuppressLint("SetTextI18n")
    public void onButtonCalcClick(View view) {

        EditText text_get_number1 = (EditText) findViewById(R.id.editTextText1);
        EditText text_get_number2 = (EditText) findViewById(R.id.editTextText2);
        TextView result = (TextView) findViewById(R.id.result);

        String number1 = text_get_number1.getText().toString();
        String number2 = text_get_number2.getText().toString();

        if (number1.isEmpty() || number2.isEmpty()) {
            text_get_number1.setError("Please enter a number");
            text_get_number2.setError("Please enter a number");
        } else if (!isAllDigits(number1) || !isAllDigits(number2)) {
            text_get_number1.setError("Please enter a valid number");
            text_get_number2.setError("Please enter a valid number");}
        else{
            int num = Integer.parseInt(number1) + Integer.parseInt(number2);
            result.setText(number1 + "+" + number2 + "=" + num);
        }
    }
    private boolean isAllDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}