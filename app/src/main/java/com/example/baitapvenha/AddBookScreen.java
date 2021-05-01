package com.example.baitapvenha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddBookScreen extends AppCompatActivity implements View.OnClickListener {

    TextView tvBook, tvAuthor;
    Button btnAdd;

    static final int ADD_BOOK = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_screen);

        tvBook = findViewById(R.id.edtName);
        tvAuthor = findViewById(R.id.edtAuthor);
        btnAdd = findViewById(R.id.btnAddScreen);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = tvBook.getText().toString();
        String author = tvAuthor.getText().toString();

//        khi nào màn Main nhận được giá trị này, thì nó sẽ xử lý data và rồi update view

        Intent intent = new Intent();

        intent.putExtra("name", name);
        intent.putExtra("author", author);

        setResult(ADD_BOOK, intent);
        finish();
    }
}