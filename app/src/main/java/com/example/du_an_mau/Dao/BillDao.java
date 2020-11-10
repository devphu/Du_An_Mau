package com.example.du_an_mau.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_mau.Database.DbHelper;
import com.example.du_an_mau.Model.Bill;
import com.example.du_an_mau.Model.Book;

import java.util.ArrayList;

public class BillDao {
    public DbHelper dbHelper;

    public BillDao(Context context) {
        dbHelper = new DbHelper(context);


    }

    ArrayList<Bill> arrayList = new ArrayList<>();

    public ArrayList<Bill> readALl() {
        SQLiteDatabase data = dbHelper.getReadableDatabase();
        ArrayList<Bill> arrayList = new ArrayList<>();
        Cursor cs = data.rawQuery("select * from bill", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            int codeBill = cs.getInt(0);
            String nameBook = cs.getString(1);
            String date = cs.getString(2);
            int priceBook = cs.getInt(3);
            int amount = cs.getInt(4);

            int total = cs.getInt(5);
            arrayList.add(new Bill(codeBill, nameBook,date,amount,priceBook,total));
            cs.moveToNext();
        }
        cs.close();
        return arrayList;
    }

    public long insert(Bill item) {

        SQLiteDatabase data = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("codeBill",item.getCodeBill());
        contentValues.put("nameBook",item.getNameBook());
        contentValues.put("date",item.getDate());
        contentValues.put("amount",item.getAmount());
        contentValues.put("priceBook",item.getPriceBook());
        contentValues.put("total",item.getTotal());
        return data.insert("bill", null, contentValues);

    }

    public int update(Bill item) {
        SQLiteDatabase data = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameBook",item.getNameBook());
        contentValues.put("date",item.getDate());
        contentValues.put("amount",item.getAmount());
        contentValues.put("priceBook",item.getPriceBook());
        contentValues.put("total",item.getTotal());
        return data.update("bill", contentValues, "codeBill=?", new String[]{
                String.valueOf(item.getCodeBill())
        });
    }

    public int delete(Bill item) {
        SQLiteDatabase data = dbHelper.getWritableDatabase();
        return data.delete("bill", "codeBill=?", new String[]{
                String.valueOf(item.getCodeBill())
        });
    }

}
