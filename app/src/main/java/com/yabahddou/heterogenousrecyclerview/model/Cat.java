package com.yabahddou.heterogenousrecyclerview.model;

/**
 * Created by YABAHDDOU Abdelhadi on 18-Jun-16.
 */
public class Cat {
    private String name;
    private String color;

    public Cat(String name, String color) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
