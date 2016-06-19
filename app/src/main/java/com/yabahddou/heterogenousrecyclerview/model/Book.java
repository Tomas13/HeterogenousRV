package com.yabahddou.heterogenousrecyclerview.model;

/**
 * Created by YABAHDDOU Abdelhadi on 19-Jun-16.
 */
public class Book {
    private String name;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String name, String author) {

        this.author = author;
        this.name = name;
    }
}
