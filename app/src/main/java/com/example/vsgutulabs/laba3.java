package com.example.vsgutulabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class laba3 extends AppCompatActivity {

    TextView resultField;
    EditText numberField;
    TextView operationField;
    Double operand = null;  // операнд операции
    String lastOperation = "="; // последняя операция
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba3);

        resultField = findViewById(R.id.text_result_number);
        numberField = findViewById(R.id.plaintext);
        operationField = findViewById(R.id.operator);

        findViewById(R.id.plus).setOnClickListener((view)->onOperationClick("+"));
        findViewById(R.id.minus).setOnClickListener((view)->onOperationClick("-"));
        findViewById(R.id.multiply).setOnClickListener((view)->onOperationClick("*"));
        findViewById(R.id.divide).setOnClickListener((view)->onOperationClick("/"));
        findViewById(R.id.equal).setOnClickListener((view)->onOperationClick("="));

        findViewById(R.id.number0).setOnClickListener((view)->onNumberClick("0"));
        findViewById(R.id.number1).setOnClickListener((view)->onNumberClick("1"));
        findViewById(R.id.number2).setOnClickListener((view)->onNumberClick("2"));
        findViewById(R.id.number3).setOnClickListener((view)->onNumberClick("3"));
        findViewById(R.id.number4).setOnClickListener((view)->onNumberClick("4"));
        findViewById(R.id.number5).setOnClickListener((view)->onNumberClick("5"));
        findViewById(R.id.number6).setOnClickListener((view)->onNumberClick("6"));
        findViewById(R.id.number7).setOnClickListener((view)->onNumberClick("7"));
        findViewById(R.id.number8).setOnClickListener((view)->onNumberClick("8"));
        findViewById(R.id.number9).setOnClickListener((view)->onNumberClick("9"));
        findViewById(R.id.point).setOnClickListener((view)->onNumberClick(","));
    }
    // сохранение состояния при повороте телефона
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("OPERATION", lastOperation);
        if(operand!=null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }
    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand= savedInstanceState.getDouble("OPERAND");
        resultField.setText(operand.toString());
        operationField.setText(lastOperation);
    }
    // обработка нажатия на числовую кнопку
    public void onNumberClick(String number){
        numberField.append(number);
        if(lastOperation.equals("=") && operand!=null){
            operand = null;
        }
    }
    // обработка нажатия на кнопку операции
    public void onOperationClick(String op){

        String number = numberField.getText().toString();
        // если введенно что-нибудь
        if(number.length()>0){
            number = number.replace(',', '.'); //из за того что использую double
            try{
                performOperation(Double.valueOf(number), op);
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        lastOperation = op;
        operationField.setText(lastOperation);
    }

    private void performOperation(Double number, String operation){

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if(operand ==null){
            operand = number;
        }
        else{
            if(lastOperation.equals("=")){
                lastOperation = operation;
            }
            switch(lastOperation){
                case "=":
                    operand =number;
                    break;
                case "/":
                    if(number==0){
                        operand =0.0;
                    }
                    else{
                        operand /=number;
                    }
                    break;
                case "*":
                    operand *=number;
                    break;
                case "+":
                    operand +=number;
                    break;
                case "-":
                    operand -=number;
                    break;
            }
        }
        resultField.setText(operand.toString().replace('.', ','));
        numberField.setText("");
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