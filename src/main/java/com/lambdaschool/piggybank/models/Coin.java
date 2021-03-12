package com.lambdaschool.piggybank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//the coins data! use "" not ''! (note) --------------------------------------
@Entity
@Table(name ="coins")
public class Coin {

    //This generates an id (long) of a coin object. Unique to all coins
    //Fields ----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;
    private String name;
    private String nameplural;
    private double value;
    private int quantity;

    //Default Constructor ---------------------------------------------------
    public Coin()
    {
    }

    //Constructor for Coin --------------------------------------------------
    public Coin(String name, String nameplural, double value, int quantity)
    {
        this.name = name;
        this.nameplural = nameplural;
        this.value = value;
        this.quantity = quantity;
    }
    //Generated Getters & Setters (how handy!) -------------------------------
    public long getCoinid() {
        return coinid;
    }

    public void setCoinid(long coinid) {
        this.coinid = coinid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getnameplural() {
        return nameplural;
    }

    public void setNameplural(String nameplural) {
        this.nameplural = nameplural;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Overriding the toString() ---------------------------------------

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", name='" + name + '\'' +
                ", nameplural='" + nameplural + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}
