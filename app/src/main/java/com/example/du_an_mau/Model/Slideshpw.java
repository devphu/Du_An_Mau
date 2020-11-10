package com.example.du_an_mau.Model;

public class Slideshpw {
    public int img;
    public String title;
    public  String nd;

    public Slideshpw(int img, String title, String nd) {
        this.img = img;
        this.title = title;
        this.nd = nd;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }
}
