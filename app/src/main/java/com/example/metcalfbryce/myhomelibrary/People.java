package com.example.metcalfbryce.myhomelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class People extends AppCompatActivity {
    private final String PEOPLE_TITLE = "People";
    private final String ADD_TITLE = "ADD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);



        //title
        TextView peopleTitle = findViewById(R.id.peopleTitle);
        peopleTitle.setText(PEOPLE_TITLE);
        //add button
        Button addPerson = findViewById(R.id.AddPerson);
        addPerson.setText(ADD_TITLE);


        //Spinner


    }
}
