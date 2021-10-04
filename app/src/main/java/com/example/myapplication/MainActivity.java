package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enter = findViewById(R.id.enter);            //button
        EditText username = findViewById(R.id.username);    //username
        EditText password= findViewById(R.id.password);     //password

        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //username && password:
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Log.i("Test","login ok");   //it works
                }else{
                    Log.i("Test","login ko");   //not works
                }
            }
        });
    }
}