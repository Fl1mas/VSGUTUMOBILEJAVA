package com.example.vsgutulabs.LB5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vsgutulabs.R;

public class laba5 extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";
    private static final String PRINT_TEXT_KEY = "PRINT_TEXT";
    private static final int REQUEST_ACCESS_TYPE = 1;
    private TextView print;
    private EditText name;
    private EditText secondname;
    static final String NAME_KEY = "NAME";
    static final String NAMESECOND_KEY = "NAMESECOND";
    static final String ACCESS_MESSAGE = "ACCES";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba5);
        Log.d(TAG, "activity_laba5 onCreate");

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }

        print = findViewById(R.id.print);
        name = findViewById(R.id.name);
        secondname = findViewById(R.id.secondname);

        if (savedInstanceState != null) {
            name.setText(savedInstanceState.getString(NAME_KEY));
            secondname.setText(savedInstanceState.getString(NAMESECOND_KEY));
        }
    }
    public void _btn_lb5_Auth(View view) {
        String Name = name.getText().toString();
        String SecondName = secondname.getText().toString();

        Intent intent = new Intent(this, lb5_auth_window.class);
        intent.putExtra(NAME_KEY, Name);
        intent.putExtra(NAMESECOND_KEY, SecondName);
        startActivityForResult(intent, REQUEST_ACCESS_TYPE);
        Log.d(TAG, "activity_laba5 отправил данные во 2-ую активити");


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "activity_laba5 получил данные");
        if (requestCode == REQUEST_ACCESS_TYPE){
            if (resultCode == RESULT_OK){
                String accessMessage = data.getStringExtra(ACCESS_MESSAGE);
                print.setText(accessMessage);

            } else {
                print.setText("ошибка доступа");
            }

        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "activity_laba5 onSaveInstanceState called");
        outState.putString(NAME_KEY, name.getText().toString());
        outState.putString(NAMESECOND_KEY, secondname.getText().toString());
        outState.putString(PRINT_TEXT_KEY, print.getText().toString());
        Log.d(TAG, "activity_laba5 onSaveInstanceState finish");

    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "activity_laba5 onRestoreInstanceState called");
        print.setText(savedInstanceState.getString(PRINT_TEXT_KEY));
        name.setText(savedInstanceState.getString(NAME_KEY));
        secondname.setText(savedInstanceState.getString(NAMESECOND_KEY));
        Log.d(TAG, "activity_laba5 onRestoreInstanceState finish");
    }
}