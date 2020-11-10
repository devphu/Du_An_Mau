package com.example.du_an_mau.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_mau.Database.DbHelper;
import com.example.du_an_mau.Model.Book;

import java.util.ArrayList;

public class bookDao {
    public DbHelper dbHelper;

    public bookDao(Context context) {
        dbHelper = new DbHelper(context);


    }

    ArrayList<Book> arrayList = new ArrayList<>();

    public ArrayList<Book> readALl() {
        SQLiteDatabase data = dbHelper.getReadableDatabase();
        ArrayList<Book> arrayList = new ArrayList<>();
        Cursor cursor = data.rawQuery("select * from book", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int codeBook = cursor.getInt(0);
            String nameBook = cursor.getString(1);
            int priceBook = cursor.getInt(2);
            String nsb = cursor.getString(3);
            String codeType = cursor.getString(4);
            arrayList.add(new Book( nameBook, priceBook, nsb, codeType));
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }

    public long insert(Book book) {

        SQLiteDatabase data = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put("codeBook", book.getCodeBook());
        contentValues.put("nameBook", book.getNameBook());
        contentValues.put("price", book.getPriceBook());
        contentValues.put("nsb", book.getNsb());
        contentValues.put("codeType", book.getCodeType());
        return data.insert("book", null, contentValues);

    }

    public int update(Book book) {
        SQLiteDatabase data = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameBook", book.getNameBook());
        contentValues.put("price", book.getPriceBook());
        contentValues.put("nsb", book.getNsb());
//        contentValues.put("codeType", book.getCodeType());
        return data.update("book", contentValues, "codeBook=?", new String[]{
                String.valueOf(book.getCodeBook())
        });
    }

    public int delete(Book book) {
        SQLiteDatabase data = dbHelper.getWritableDatabase();
        return data.delete("book", "codeBook=?", new String[]{
                String.valueOf(book.getCodeBook())
        });
    }

}
