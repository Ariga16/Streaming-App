package com.dacasa.streamingapp;

public class Cast {

    String name;
    int  img_Link;


    public Cast(String name, int img_Link) {
        this.name = name;
        this.img_Link = img_Link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_Link() {
        return img_Link;
    }

    public void setImg_Link(int img_Link) {
        this.img_Link = img_Link;
    }
}
