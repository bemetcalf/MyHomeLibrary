package com.example.metcalfbryce.myhomelibrary;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import database.DBHelper;

public class StartingMenu extends AppCompatActivity {
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //database creation
        SQLiteOpenHelper dbHelper = new DBHelper(this);
        dbHelper.getWritableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_menu);
        //test

        /*main menu buttons
        *
        */
        //bookshelf
        Button bookshelfBtn = findViewById(R.id.bookshelfBtn);
        bookshelfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               startActivity(new Intent(StartingMenu.this, BookShelves.class));

            }
        });

        //people
        Button peopleBtn = findViewById(R.id.peopleBtn);
        peopleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartingMenu.this, People.class));

            }
        });

    }
}
