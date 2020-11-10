package com.example.du_an_mau.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.Dao.bookDao;
import com.example.du_an_mau.Model.Book;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.bookViewHolder> {
    ArrayList<Book> arrayList;
    Context context;
    Activity MainActivity;
    bookDao dao;

    public bookAdapter(Activity mainActivity, ArrayList<Book> arrayListAdapter) {
        this.MainActivity = mainActivity;
        this.arrayList = arrayListAdapter;
    }

    @NonNull
    @Override
    public bookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_book, parent, false);
        bookViewHolder typeView = new bookViewHolder(view);
        return typeView;
    }

    @Override
    public void onBindViewHolder(@NonNull bookViewHolder holder, int position) {
        final Book book = arrayList.get(position);
        holder.nameBook.setText(book.getNameBook());
        holder.typeName.setText(book.getCodeType());
        String imgLoai = holder.nameBook.getText().toString();
        if (imgLoai.equals("Chí Phèo")) {
            holder.imgBook.setImageResource(R.drawable.cntt);
        } else if (imgLoai.equals("Văn Học")) {
            holder.imgBook.setImageResource(R.drawable.suhoc);


        } else {
            holder.imgBook.setImageResource(R.drawable.thienvan);
        }

        holder.priceBook.setText("Giá sách:" +" "+ String.valueOf(book.getPriceBook()));
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class bookViewHolder extends RecyclerView.ViewHolder {
        public TextView nameBook, typeName,priceBook;
        public ImageView imgBook;
        public CardView cardView;

        public bookViewHolder(@NonNull View itemView) {
            super(itemView);
            nameBook = itemView.findViewById(R.id.txtNameBook);
            typeName = itemView.findViewById(R.id.txtTypeBook1);
            imgBook = itemView.findViewById(R.id.imgLogoBook);
            priceBook = itemView.findViewById(R.id.txtPriceBook);
        }
    }
}
