package com.example.du_an_mau.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.audiofx.NoiseSuppressor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.Dao.typeBookDao;
import com.example.du_an_mau.MainActivity;
import com.example.du_an_mau.Model.typeBook;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class typeBookAdapter extends RecyclerView.Adapter<typeBookAdapter.TypeBookViewHolder> {

    Activity mainActivity;
    ArrayList<typeBook> arrayList;
    com.example.du_an_mau.Dao.typeBookDao typeBookDao;

    public typeBookAdapter(MainActivity mainActivity, ArrayList<typeBook> arrayList) {
        this.mainActivity = mainActivity;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public TypeBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.typebook_list, parent, false);
        TypeBookViewHolder typeBookViewHolder = new TypeBookViewHolder(view);
        return typeBookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TypeBookViewHolder holder, int position) {
        final typeBook typeBook = arrayList.get(position);
        holder.titleAmount.setText("Số lượng sách:"+" ");
        holder.nametypeBook.setText(String.valueOf(typeBook.getCodeType()));
        holder.titleRoom.setText("Số phòng:"+" ");
        holder.amount.setText(String.valueOf(typeBook.getAmount()));
        holder.asm.setText(String.valueOf(typeBook.getAsm()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class TypeBookViewHolder extends RecyclerView.ViewHolder {
        public TextView nametypeBook, titleAmount, amount, titleRoom, asm;
        public ImageView logo;

        public TypeBookViewHolder(@NonNull View itemView) {
            super(itemView);
            nametypeBook = itemView.findViewById(R.id.txtTypeBook);
            titleAmount = itemView.findViewById(R.id.txtTitleAmount);
            amount = itemView.findViewById(R.id.txtAmount);
            titleRoom = itemView.findViewById(R.id.txtTitleRoom);
            asm = itemView.findViewById(R.id.txtAsm);


        }
    }
}
