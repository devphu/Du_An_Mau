package com.example.du_an_mau.Model;

public class Bill {
    int codeBill;
    String nameBook;
    String date;
    int priceBook;
    int amount;
    int total;

    public Bill(int codeBill, String nameBook, String date, int priceBook, int amount, int total) {
        this.codeBill = codeBill;
        this.nameBook = nameBook;
        this.date = date;
        this.priceBook = priceBook;
        this.amount = amount;
        this.total = total;
    }

    public int getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(int codeBill) {
        this.codeBill = codeBill;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(int priceBook) {
        this.priceBook = priceBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
