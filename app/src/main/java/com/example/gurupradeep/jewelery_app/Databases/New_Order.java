package com.example.gurupradeep.jewelery_app.Databases;

import com.example.gurupradeep.jewelery_app.New_orders;

/**
 * Created by Guru Pradeep on 16-06-2016.
 */
public class New_Order {
    String name;
    String items;
    String delivery_date;
    String amount;
    String amount_paid;

    public New_Order(String name, String items, String delivery_date, String amount, String amount_paid) {
        this.name = name;
        this.items = items;
        this.delivery_date = delivery_date;
        this.amount = amount;
        this.amount_paid = amount_paid;
    }
    public New_Order(){

    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(String amount_paid) {
        this.amount_paid = amount_paid;
    }
}
