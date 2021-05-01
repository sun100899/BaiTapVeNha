package com.example.baitapvenha;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnAddBookMain;
    ListView listView;
    BookAdapter bookAdapter;
    ArrayList<Book> listBook = new ArrayList<>();
    final static int REQUEST_ADD_BOOK = 1;
    final static int REQUEST_UPDATE_DETAIL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvListBook);
        btnAddBookMain = findViewById(R.id.btnAddBook);

        bookAdapter = new BookAdapter(listBook, MainActivity.this);
        listView.setAdapter(bookAdapter);

        btnAddBookMain.setOnClickListener(this);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, DetailBook.class);
                        String book = listBook.get(position).getBookName();
                        String author = listBook.get(position).getAuthor();
                        intent.putExtra("book", book);
                        intent.putExtra("author", author);
                        intent.putExtra("position", position);
                        startActivityForResult(intent, REQUEST_UPDATE_DETAIL);
                    }
                }
        );

        // Xoá item
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listBook.remove(position);
                bookAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ADD_BOOK){
            if(resultCode == AddBookScreen.ADD_BOOK){
                String bookName = data.getStringExtra("name");
                String authorName = data.getStringExtra("author");
                Book newBook = new Book(bookName, authorName);
                listBook.add(newBook);
                bookAdapter.notifyDataSetChanged();
            }
        }
        if(requestCode == REQUEST_UPDATE_DETAIL){
            if(resultCode == DetailBook.UPDATE_OK){
                String bookName = data.getStringExtra("name");
                String authorName = data.getStringExtra("author");
                int position = data.getIntExtra("positionList", 0);
                Book newBook = listBook.get(position);

                newBook.setBookName(bookName);
                newBook.setAuthor(authorName);
                bookAdapter.notifyDataSetChanged();
//                listBook.set(position, newBook);
            }
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddBookScreen.class);
        startActivityForResult(intent, REQUEST_ADD_BOOK);
    }

//    startActivityForResult dùng khi mình muốn nhảy sang màn khác và nhận về giá trị từ màn đó


}