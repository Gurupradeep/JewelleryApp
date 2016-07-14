package com.example.gurupradeep.jewelery_app.Simple_Constructors;

/**
 * Created by Guru Pradeep on 05-06-2016.
 */
public class Requested_order {
    public String name;
    public String items;
    public String Advance_paid;
    public String delivery;
    public String quotes;
    public Requested_order(String a,String b, String c,String d,String e)
    {
        this.name = a;
        this.items = b;
        this.Advance_paid = c;
        this.delivery = d;
        this.quotes = e;
    }
}
