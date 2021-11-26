package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //description
        Button enter = findViewById(R.id.enter);            //button
        EditText username = findViewById(R.id.username);    //username
        EditText password= findViewById(R.id.password);     //password

        CheckBox mantener = findViewById(R.id.sesion);      //checkbox

        SharedPreferences preference= getSharedPreferences("SharedP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();

        if(preference.getBoolean("login", false) == true){      //save login
            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        }

        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //username: admin && password: admin
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Log.i("Test","login ok");   //works

                    if(mantener.isChecked()){
                        editor.putBoolean("login", true).commit();
                    }

                    openActivity2();                     //Go to the next activity
                }else{
                    Log.i("Test","login ko");   //not works
                }
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}