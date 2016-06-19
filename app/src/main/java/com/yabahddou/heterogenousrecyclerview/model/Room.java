package com.yabahddou.heterogenousrecyclerview.model;

/**
 * Created by YABAHDDOU Abdelhadi on 18-Jun-16.
 */
public class Room {
    private String title;
    private String Desc;
    private int nbr;
    private String img;

    public Room(String title, String desc, int nbr, String img) {
        Desc = desc;
        this.img = img;
        this.nbr = nbr;
        this.title = title;
    }

    public Room() {

    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
