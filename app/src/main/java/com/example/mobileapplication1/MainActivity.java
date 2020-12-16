package com.example.mobileapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetContacts contacts = new GetContacts(MainActivity.this);
        // THIS IS THE API , THAT WE WILL EXECUTE AND PASSED TO ASYNC
        contacts.execute("https://api.github.com/repositories");


    }
}