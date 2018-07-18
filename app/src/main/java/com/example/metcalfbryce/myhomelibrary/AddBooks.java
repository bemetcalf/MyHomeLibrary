package com.example.metcalfbryce.myhomelibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import database.BookItem;
import database.DataSource;

public class AddBooks extends AppCompatActivity {
    DataSource mDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
      final Context mContext = this;
        mDataSource= new DataSource(this);
        mDataSource.open();
        final TextView title = findViewById(R.id.TitleField);
        final TextView volume = findViewById(R.id.VolumeField);
        final TextView author = findViewById(R.id.AuthorField);
        final TextView series = findViewById(R.id.SeriesField);



        Button addBtn = findViewById(R.id.AddBookButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().length() >0 && volume.getText().length()>0){
                    BookItem newBook = new BookItem(title.getText().toString(),volume.getText().toString());
                    if(author.getText().length()>0){
                        newBook.setAuthor(author.getText().toString());
                    }
                    if(series.getText().length()>0){
                        newBook.setSeries(series.getText().toString());
                    }
                    mDataSource.createItem(newBook);
                    Toast.makeText(mContext, "Book Added",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(mContext, "Title and Volume Required",Toast.LENGTH_SHORT).show();
                }

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
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mDataSource.close();

    }
}
