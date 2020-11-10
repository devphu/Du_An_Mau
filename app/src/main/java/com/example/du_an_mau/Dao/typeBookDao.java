package com.example.du_an_mau.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.du_an_mau.Database.DbHelper;
import com.example.du_an_mau.Model.typeBook;

import java.util.ArrayList;

public class typeBookDao {
    DbHelper dbHelper;
    ArrayList<typeBook> arrayList;
    private SQLiteDatabase sqldatabase;

    public typeBookDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        sqldatabase = dbHelper.getWritableDatabase();
    }

    public ArrayList<typeBook> readAll() {
        SQLiteDatabase sqLiteDatabase;
        ArrayList<typeBook> arrayList = new ArrayList<>();
        Cursor cs = sqldatabase.rawQuery("select * from typeBook", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()) {
            String codeType = cs.getString(0);
            int amount = cs.getInt(1);
            int room = cs.getInt(2);
            String asm = cs.getString(3);
            arrayList.add(new typeBook(codeType, amount, room,asm));
            cs.moveToNext();


        }
        cs.close();
        return arrayList;
    }

    public long insert(typeBook item) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("codeType", item.getCodeType());
        contentValues.put("amount", item.getAmount());
        contentValues.put("room", item.getRoom());
        contentValues.put("asm", item.getAsm());
        return sqldatabase.insert("typeBook", null, contentValues);

    }

    public int update(typeBook book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount", book.getAmount());
        contentValues.put("asm", book.getAsm());
        return sqldatabase.update("typeBook", contentValues, "codeType=?", new String[]{
                String.valueOf(book.getCodeType())
        });
    }

    public int delete(typeBook book) {
        return
                sqldatabase.delete("typeBook", "codeType=?", new String[]{
                        String.valueOf(book.getCodeType())
                });
    }
}
