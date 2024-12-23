package com.example.myapplicationrecyclerview;

import java.util.ArrayList;

public class Country {
    private String name;

    public Country(String name, ArrayList<Cities> cities) {
        this.name = name;
        this.cities = cities;
    }

    private ArrayList<Cities> cities;

    public String getName() {
        return name;
    }

    public ArrayList<Cities> getCities() {
        return cities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
    }
}
