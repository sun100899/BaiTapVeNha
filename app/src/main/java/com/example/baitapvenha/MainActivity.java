package com.example.baitapvenha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnAddBookMain;
    ListView listView;
    BookAdapter bookAdapter;
    ArrayList<Book> listBook = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvListBook);
        btnAddBookMain = findViewById(R.id.btnAddBook);

        bookAdapter = new BookAdapter(listBook, MainActivity.this);
        listView.setAdapter(bookAdapter);

        btnAddBookMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddBookScreen.class);
        startActivity(intent);
    }

}