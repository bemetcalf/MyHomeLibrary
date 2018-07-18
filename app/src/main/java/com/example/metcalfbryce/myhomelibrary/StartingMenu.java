package com.example.metcalfbryce.myhomelibrary;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import database.BookItem;
import database.DBHelper;
import database.DataSource;

public class StartingMenu extends AppCompatActivity {
    //string for text of objects
    private final String MAIN_MENU_TEXT = "Main Menu";
    private final String BOOKSHELF_BTN_TEXT = "MY BOOKSHELVES";
    private final String PEOPLE_BTN_TEXT = "MY PEOPLE";
    //private final String SETTINGS_BTN_TEXT = "settings";

    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_menu);




        //database creation
        mDataSource= new DataSource(this);
        mDataSource.open();
        //Toast.makeText(this, "Books Loaded",Toast.LENGTH_SHORT).show();

        //Main Menu Text
        TextView mainMenuText = findViewById(R.id.MainMenuText);
        mainMenuText.setText(MAIN_MENU_TEXT);
        mDataSource.testDB();

        /*main menu buttons
        *
        */
        //bookshelf
        Button bookshelfBtn = findViewById(R.id.bookshelfBtn);
        bookshelfBtn.setText(BOOKSHELF_BTN_TEXT);
        bookshelfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               startActivity(new Intent(StartingMenu.this, BookShelves.class));

            }
        });

        //people
        Button peopleBtn = findViewById(R.id.peopleBtn);
        peopleBtn.setText(PEOPLE_BTN_TEXT);
        peopleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartingMenu.this, People.class));

            }
        });

    }
    @Override
    protected void onPause(){
        super.onPause();
        mDataSource.close();
    }
    @Override
    protected void onResume(){
        super.onResume();
        mDataSource.open();
    }
}
