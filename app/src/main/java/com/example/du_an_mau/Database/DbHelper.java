package com.example.du_an_mau.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String Database_name = "book";
    public static final int veson = 7;

    public DbHelper(Context context) {
        super(context, Database_name, null, veson);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String sql1 = "CREATE TABLE hoaDon(codeHd integer primary key autoincrement,  "
        String sql_typeBook = "CREATE TABLE typeBook(codeType text primary key ,amount integer not null,roomBook integer,asm text)";
        sqLiteDatabase.execSQL(sql_typeBook);
        sql_typeBook = "INSERT INTO typeBook(codeType,amount,roomBook,asm ) VALUES('CNTT',10,1,'Sach cho sinh vien it')";
        sqLiteDatabase.execSQL(sql_typeBook);
        sql_typeBook = "INSERT INTO typeBook(codeType,amount,roomBook,asm ) VALUES('Văn Học',30,2,'Sach cho giao vien')";
        sqLiteDatabase.execSQL(sql_typeBook);
        sql_typeBook = "INSERT INTO typeBook(codeType,amount,roomBook,asm ) VALUES('Thiên Văn Học',40,4,'sach cho giao vien ')";
        sqLiteDatabase.execSQL(sql_typeBook);
        // Table book


        String sql_Book = "CREATE TABLE book(codeBook integer primary key autoincrement ,nameBook text not null,priceBook integer not null,nsb text,codeType text not null references typeBook(codeType))";
        sqLiteDatabase.execSQL(sql_Book);
        sql_Book = "INSERT INTO book(nameBook,priceBook,nsb,codeType) VALUES('Hành Lang lập trình',30000,'FPT','CNTT')";
        sqLiteDatabase.execSQL(sql_Book);
        sql_Book = "INSERT INTO book(nameBook,priceBook,nsb,codeType) VALUES('Chí Phèo',30000,'HCM','Văn Học')";
        sqLiteDatabase.execSQL(sql_Book);
        sql_Book = "INSERT INTO book(nameBook,priceBook,nsb,codeType) VALUES('Khám phá sao hỏa',20000,'HN','Thiên Văn Học')";
        sqLiteDatabase.execSQL(sql_Book);

        // Table bill
        String sql_Bill = "CREATE TABLE bill(codeBill integer primary key autoincrement, nameBook text not null,date text not null,priceBook integer not null,amount integer not null, total integer)";
        sqLiteDatabase.execSQL(sql_Bill);
        sql_Bill = "INSERT INTO bill(nameBook,date,amount,priceBook,total) VALUES('Thiên Đường tình ái','04/02/2020',2,2000,4000)";
        sqLiteDatabase.execSQL(sql_Bill);
//        String sqlUser = "CREATE TABLE user(username text primary key , password text)";
//        sqLiteDatabase.execSQL(sqlUser);
//        sqlUser = "INSERT INTO user(username,password) VALUES('admin'," +
//                "'admin')";
//        sqLiteDatabase.execSQL(sqlUser);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("Drop table if exists book");
//        sqLiteDatabase.execSQL("Drop table if exists typeBook");
//        sqLiteDatabase.execSQL("Drop table if exists bill");
//        onCreate(sqLiteDatabase);
    }
}
