package com.example.du_an_mau.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.du_an_mau.Dao.BillDao;
import com.example.du_an_mau.Model.Bill;
import com.example.du_an_mau.Model.Book;
import com.example.du_an_mau.R;

import java.util.ArrayList;

public class billAdapter extends RecyclerView.Adapter<billAdapter.billViewHolder> {
    ArrayList<Bill> arrayList;
    Activity activity;
    BillDao dao;

    public billAdapter(Activity mainActivity, ArrayList<Bill> arrayListAdapter) {
        this.activity = mainActivity;
        this.arrayList = arrayListAdapter;
    }

    @NonNull
    @Override
    public billViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_bill, parent, false);
        billViewHolder typeView = new billViewHolder(view);
        return typeView;
    }

    @Override
    public void onBindViewHolder(@NonNull billViewHolder holder, int position) {
        BillDao dao;
        final Bill bill = arrayList.get(position);
        holder.title.setText("Nhà Sách Phương Nam" + "Hóa Đơn Số" + bill.getCodeBill());
        holder.date.setText(bill.getDate());
        holder.titleNameBook.setText("Tên Sách");
        holder.nameBook.setText(bill.getNameBook());
        holder.titlePriceBook.setText("Giá Sách");
        holder.priceBook.setText(String.valueOf(bill.getPriceBook()));
        holder.titleAmount.setText("Số Lượng");
        holder.amount.setText(String.valueOf(bill.getAmount()));
        holder.titleTotal.setText("Tổng Tiền");
        int sl = Integer.parseInt(holder.amount.getText().toString());
        int gia = Integer.parseInt(holder.priceBook.getText().toString());
        int tong = sl * gia;
        holder.total.setText(String.valueOf(tong));
      int totalBill = Integer.parseInt(holder.total.getText().toString());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class billViewHolder extends RecyclerView.ViewHolder {
        private TextView title, titleDate, date, titleNameBook, nameBook, titlePriceBook, priceBook, titleAmount, amount, titleTotal, total;
        public  Button addDataBill;
        public billViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            titleDate = itemView.findViewById(R.id.txtTitleDate);
            date = itemView.findViewById(R.id.txtDate);
            titleNameBook = itemView.findViewById(R.id.txtTitleNameBook);
            nameBook = itemView.findViewById(R.id.txtNameBook);
            titlePriceBook = itemView.findViewById(R.id.txtTitlePriceBook);
            priceBook = itemView.findViewById(R.id.txtPriceBook);
            titleAmount = itemView.findViewById(R.id.txtTitleAmount);
            amount = itemView.findViewById(R.id.txtAmount);
            titleTotal = itemView.findViewById(R.id.txtTitleTotal);
            total = itemView.findViewById(R.id.txtTotal);

        }
    }
}
