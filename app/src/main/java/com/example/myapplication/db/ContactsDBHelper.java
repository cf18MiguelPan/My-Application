package com.example.myapplication.db;

import static com.example.myapplication.db.ContactsContract.ContactsEntry.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.db.ContactsContract.*;

import java.util.ArrayList;

public class ContactsDBHelper extends SQLiteOpenHelper {

    public ContactsDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            ContactsContract.ContactsEntry.TABLE_NAME + "(" +
            ContactsContract.ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ContactsContract.ContactsEntry.COLUMN_NAME_TITLE + " TEXT)";


    public void insertContact(SQLiteDatabase db, Contact c){
        //Check the bd is open
        if (db.isOpen()){
            ContentValues values = new ContentValues();

            values.put(ContactsContract.ContactsEntry.COLUMN_NAME_TITLE, c.getNombre());

            db.insert(ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

}
