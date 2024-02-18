package com.example.vsgutulabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class laba3 extends AppCompatActivity {

    public float numberfirst;
    public float numbersecond;
    
    public String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba3);

        TextView text_result = (TextView) findViewById(R.id.text_result_number);
        TextView text_operator = (TextView) findViewById(R.id.operator);
        EditText text_plain = (EditText) findViewById(R.id.plaintext);

        Button number0 = findViewById(R.id.number0);
        Button number1 = findViewById(R.id.number1);
        Button number2 = findViewById(R.id.number2);
        Button number3 = findViewById(R.id.number3);
        Button number4 = findViewById(R.id.number4);
        Button number5 = findViewById(R.id.number5);
        Button number6 = findViewById(R.id.number6);
        Button number7 = findViewById(R.id.number7);
        Button number8 = findViewById(R.id.number8);
        Button number9 = findViewById(R.id.number9);
        Button point = findViewById(R.id.point);
        Button operator_divide = findViewById(R.id.divide);
        Button operator_multiply = findViewById(R.id.multiply);
        Button operator_plus = findViewById(R.id.plus);
        Button operator_minus = findViewById(R.id.minus);
        Button equal = findViewById(R.id.equal);


        point.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text_plain.setText(text_plain.getText().toString() + ",");
            }
        });
        operator_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_operator.setText("/");
                operator = text_operator.getText().toString();
                numberfirst = Float.parseFloat(text_plain.getText().toString());
            }
        });

        operator_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_operator.setText("*");
                operator = text_operator.getText().toString();
                numberfirst = Float.parseFloat(text_plain.getText().toString());
            }
        });

        operator_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_operator.setText("+");
                operator = text_operator.getText().toString();
                numberfirst = Float.parseFloat(text_plain.getText().toString());
            }
        });

        operator_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_operator.setText("-");
                operator = text_operator.getText().toString();
                numberfirst = Float.parseFloat(text_plain.getText().toString());
            }
        });
        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "0");
            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "1");
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "2");
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "3");
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "4");
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "5");
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "6");
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "7");
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "8");
            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_plain.setText(text_plain.getText().toString() + "9");
            }
        });

        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numbersecond = Float.parseFloat(text_plain.getText().toString());
                switch (operator){
                    case "+":
                        float res = numberfirst + numbersecond;
                        text_result.setText(String.valueOf(res));
                        
                }
            }
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