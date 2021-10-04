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
                if(username.getText().toString().equals("Hola") && password.getText().toString().equals("Hola")){
                    Log.i("Test","login ok");
                    openActivity2();
                }else{
                    Log.i("Test","login ko");
                }
            }
        });
    }

    public void openActivity2(){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }


}