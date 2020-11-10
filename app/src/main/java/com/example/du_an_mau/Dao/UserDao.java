package com.example.du_an_mau.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.du_an_mau.Database.DbHelper;
import com.example.du_an_mau.Model.User;

import java.util.ArrayList;

public class UserDao {
    DbHelper dbHelper;
    ArrayList<User> arrayList;
    private SQLiteDatabase sqLitedatabase;
    public UserDao(Context context){
        DbHelper dbHelper = new DbHelper(context);
       sqLitedatabase = dbHelper.getWritableDatabase();
    }
    public ArrayList<User> readAll(){
        DbHelper dbHelper;
        SQLiteDatabase sqLiteDatabase;
        ArrayList<User> user = new ArrayList<>();
        Cursor cs = sqLitedatabase.rawQuery("select * from user",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String username = cs.getString(0);
            String pass = cs.getString(1);
            arrayList.add(new User(username,pass));
            cs.moveToNext();
        }
        cs.close();
        return arrayList;
    }
    public long insert(User user){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
      contentValues.put("username",user.getUser());
      contentValues.put("password",user.getPassword());
      return  sqLiteDatabase.insert("user",null,contentValues);
    }
    public int update(User user){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",user.getPassword());
        return sqLiteDatabase.update("user",contentValues,"id=?",new String[]{
                String.valueOf(user.getUser())
        });
    }
}
