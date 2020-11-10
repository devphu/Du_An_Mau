package com.example.du_an_mau.Model;

public class typeBook {
    String codeType;
    int amount;
    int room;
    String asm;

    public typeBook(String codeType, int amount, int room, String asm) {
        this.codeType = codeType;
        this.amount = amount;
        this.room = room;
        this.asm = asm;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getAsm() {
        return asm;
    }

    public void setAsm(String asm) {
        this.asm = asm;
    }
}
