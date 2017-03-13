package com.priyabrat.retrofitexample.models;

import java.io.Serializable;

/**
 * Created by PriyabratP on 13-03-2017.
 */

public class City implements Serializable {

    private String name;

    private String state;

    private String description;

    public City(){}

    public City(String name, String state, String description) {
        this.name = name;
        this.state = state;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
