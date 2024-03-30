package com.example.vsgutulabs.LB5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vsgutulabs.R;

public class lb5_auth_window extends AppCompatActivity {
    private final static String TAG = "LIFECYCLE";
    TextView printname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lb5_auth_window);
        Log.d(TAG, "activity_lb5_auth_window onCreate");

        printname = findViewById(R.id.printname);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString(laba5.NAME_KEY);
            String secondname = extras.getString(laba5.NAMESECOND_KEY);
            printname.setText(name + secondname);
            btn_1.setText("Привет, " + name + " " + secondname);
            btn_2.setText(name + " Ваша фамилия " + secondname);
            btn_3.setText(name + secondname);
            btn_4.setText("Отмена");

        }
        buttonInitialize();
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("ВСГУТУ ЛАБЫ ПО МП"); // Title для приложения(надпись в самом верху)
        }
    }
    private void buttonInitialize(){
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = ((Button) view).getText().toString();
                Intent data = new Intent();
                data.putExtra(laba5.ACCESS_MESSAGE, message);
                setResult(RESULT_OK, data);
                finish();
            }
        };
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }


}
