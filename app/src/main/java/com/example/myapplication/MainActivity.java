package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enter = findViewById(R.id.enter);
        EditText username = findViewById(R.id.username);
        EditText password= findViewById(R.id.password);
        //TextView lblLoginResult = findViewById(R.id.lblLoginResult);

        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Log.i("Test","login ok");
                }else{
                    Log.i("Test","login ko");
                }
            }
        });
    }
}