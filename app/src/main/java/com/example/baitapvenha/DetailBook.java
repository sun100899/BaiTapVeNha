package com.example.baitapvenha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailBook extends AppCompatActivity implements View.OnClickListener {

    TextView book, author;
    Button btnUpdate;
    static final int UPDATE_OK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        book = findViewById(R.id.tv_detail_book); // lỗi ở đây
        author = findViewById(R.id.tv_detail_author);
        btnUpdate = findViewById(R.id.btnUpdateScreen);

        book.setText(getIntent().getStringExtra("book"));
        author.setText(getIntent().getStringExtra("author"));
        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String bookName = book.getText().toString();
        String authorName = author.getText().toString();
        int positionBook = getIntent().getIntExtra("position", -1);

        Intent intent = new Intent();
        intent.putExtra("name", bookName);
        intent.putExtra("author", authorName);
        intent.putExtra("positionList", positionBook);
        setResult(UPDATE_OK, intent);
        finish();

    }
}