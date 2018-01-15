package com.example.android.testing_sql.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by TatianaM on 1/14/18.
 */

public class LaptopSighting {
    private String lastName;
    private String firstName;
    private long date;
    private long time;
    private String hairColor;

    public LaptopSighting(String lastName, String firstName, String hairColor, long date, long time) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.time = time;
        this.hairColor = hairColor;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String company) {
        this.hairColor = company;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
