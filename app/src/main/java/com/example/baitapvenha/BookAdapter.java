package com.example.baitapvenha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    ArrayList<Book> listBook;
    LayoutInflater inflater;
    Context context;

    public BookAdapter(ArrayList<Book> listBook,  Context context) {
        this.listBook = listBook;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }


    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder ;
        if(view == null){
            view = inflater.inflate(R.layout.book_item, parent, false);
            viewHolder.tvBookName = view.findViewById(R.id.tv_book_name_item);
            viewHolder.tvAuthorName = view.findViewById(R.id.tv_author_item);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvBookName.setText(listBook.get(position).getBookName());
        viewHolder.tvAuthorName.setText(listBook.get(position).getAuthor());
        return view;
    }

    class ViewHolder {
        TextView tvBookName;
        TextView tvAuthorName;
    }
}
