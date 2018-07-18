package com.example.metcalfbryce.myhomelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import database.BookItem;
import database.DataSource;

public class BookShelves extends AppCompatActivity {
    private final String SEARCH_BUTTON = "Search";
    private final String SEARCH_BY_NAME_TEXT = "Search by Name";
    DataSource mDataSource;
    private ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_shelves);

        //database creation
        mDataSource= new DataSource(this);
        mDataSource.open();
        List<BookItem> bookList;

        //list
        /*
        ListView bookHolder = findViewById(R.id.BookHolder);
        bookList = mDataSource.getAllBooks();
        List<String> bookStings=new ArrayList<String>();

        for (BookItem book: bookList
             ) {
                bookStings.add(book.toString());
        }
        listAdapter = new ArrayAdapter<String>(this, R.layout.listlayout, bookStings);
        for(String book : bookStings){
            listAdapter.add(book);
        }
        bookHolder.setAdapter(listAdapter);
        */
        final TextView temp = findViewById(R.id.TempView);
        temp.setText(mDataSource.toString());

        //search by Name
        TextView searchByNameText = findViewById(R.id.searchByName);
        searchByNameText.setText(SEARCH_BY_NAME_TEXT);

        final EditText searchByNameBar = findViewById(R.id.searchByNameBar);

        Button searchByNameButton = findViewById(R.id.searchByNameButton);
        searchByNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchByNameBar.getText()!=null && searchByNameBar.getText().length()>0){
                    temp.setText(mDataSource.toNameString(searchByNameBar.getText().toString()));
                }
            }
        });
        //search by series
        TextView searchBySeriesText = findViewById(R.id.searchByName);
        searchByNameText.setText(SEARCH_BY_NAME_TEXT);

        final EditText searchBySeriesBar = findViewById(R.id.SearchBySeriesBar);

        Button searchBySeriesButton = findViewById(R.id.SearchBySeriesBtn);
        searchBySeriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchBySeriesBar.getText()!=null && searchBySeriesBar.getText().length()>0){
                    temp.setText(mDataSource.toSeriesString(searchBySeriesBar.getText().toString()));
                }
            }
        });

        //all books button
        Button allBooksButton = findViewById(R.id.AllBooks);
        allBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    temp.setText(mDataSource.toString());

            }
        });

        //add btn
        Button addBookBtn = findViewById(R.id.AddBookBtn);
        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataSource.close();
                startActivity(new Intent(BookShelves.this, AddBooks.class));
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
        TextView temp = findViewById(R.id.TempView);
        temp.setText(mDataSource.toString());
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mDataSource.close();

    }

}
