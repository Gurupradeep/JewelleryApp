package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 15-06-2016.
 */
public class Loyality {
    String Scheme_name;
    String customers;
    String profit;
    String ornaments;

    public Loyality( String scheme_name, String customers, String profit, String ornaments) {
        Scheme_name = scheme_name;
        this.customers = customers;
        this.profit = profit;
        this.ornaments = ornaments;
    }
    public Loyality()
    {

    }

    public String getScheme_name() {
        return Scheme_name;
    }

    public void setScheme_name(String scheme_name) {
        Scheme_name = scheme_name;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(String ornaments) {
        this.ornaments = ornaments;
    }
}
