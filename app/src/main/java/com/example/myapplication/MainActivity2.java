package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);  //BottomNavigationView

        //bottomNav.setOnItemSelectedListener(item -> {
        bottomNav.setOnNavigationItemSelectedListener(item ->{
            Fragment selectedFragment = null;                       //Is no selected with anyone of the 3 fragments
            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new fragmentHome();          //Go to fragment HOME
                    break;

                case R.id.llistat:
                    selectedFragment = new llistfragment();         //Go to fragment LISTA
                    break;

                case R.id.formulari:
                    selectedFragment = new formufragment();         //Go to fragment FORMULARIO
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });

    }
}