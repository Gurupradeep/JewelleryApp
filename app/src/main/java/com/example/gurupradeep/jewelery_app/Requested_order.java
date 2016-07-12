package com.example.gurupradeep.jewelery_app;

/**
 * Created by Guru Pradeep on 05-06-2016.
 */
public class Requested_order {
    String name;
    String items;
    String Advance_paid;
    String delivery;
    String quotes;
    Requested_order(String a,String b, String c,String d,String e)
    {
        this.name = a;
        this.items = b;
        this.Advance_paid = c;
        this.delivery = d;
        this.quotes = e;
    }
}
