package com.example.vsgutulabs.LB5;

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

    private TextView print;
    private EditText name;
    private EditText secondname;
    static final String NAME_KEY = "NAME";
    static final String NAMESECOND_KEY = "NAMESECOND";
    static final String ACCESS_MESSAGE = "ACCES";
    private static final int REQUEST_ACCESS_TYPE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba5);
        Log.d(TAG, "activity_laba5 onCreate");

        print = findViewById(R.id.print);

    }

    public void _btn_lb5_Auth(View view) {
        name = findViewById(R.id.name);
        secondname = findViewById(R.id.secondname);

        String Name = name.getText().toString();
        String SecondName = secondname.getText().toString();

        Intent intent = new Intent(this, laba5.class);
        intent.putExtra(NAME_KEY, Name);
        intent.putExtra(NAMESECOND_KEY, SecondName);
        startActivityForResult(intent, REQUEST_ACCESS_TYPE);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
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
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }


}