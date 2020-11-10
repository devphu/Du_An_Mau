package com.example.du_an_mau.Model;

import androidx.recyclerview.widget.RecyclerView;

public class Book  {
    public int codeBook;
    public String nameBook;
    public int priceBook;
    public String nsb;
    public String codeType;


    public Book(String nameBook, int priceBook, String nsb, String codeType) {
        this.nameBook = nameBook;
        this.priceBook = priceBook;
        this.nsb = nsb;
        this.codeType = codeType;
    }

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(int priceBook) {
        this.priceBook = priceBook;
    }

    public String getNsb() {
        return nsb;
    }

    public void setNsb(String nsb) {
        this.nsb = nsb;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
}
