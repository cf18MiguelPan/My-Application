package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.myapplication.db.ContactsDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    //Create the instance of dbHelper
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);  //BottomNavigationView

        //Creation of the dbHelper
        dbHelper = new ContactsDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        //bottomNav.setOnItemSelectedListener(item -> {
        bottomNav.setOnNavigationItemSelectedListener(item ->{
            Fragment selectedFragment = null;                                   //Is no selected with anyone of the 3 fragments
            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new fragmentHome();                      //Go to fragment HOME
                    break;

                case R.id.llistat:
                    selectedFragment = new llistfragment(dbHelper, db);         //Go to fragment LISTA
                    break;

                case R.id.formulari:
                    selectedFragment = new formufragment(dbHelper, db);         //Go to fragment FORMULARIO
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        });

    }

    @Override
    protected void onDestroy(){
        dbHelper.close();
        db.close();
        super.onDestroy();
    }

}