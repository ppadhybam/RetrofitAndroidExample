package com.priyabrat.retrofitexample.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PriyabratP on 13-03-2017.
 */

public class CityList implements Serializable {

    private ArrayList<City> cities;

    CityList(){}

    public CityList(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }
}
