package com.example.masroufi;

import java.util.Date;

public class masrouf {
    private String thing;
    private String date;
    private int cost;
    int id ;


    public masrouf(String thing, String date, int cost) {
        this.thing = thing;
        this.date = date;
        this.cost = cost;
    }

    public masrouf() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
