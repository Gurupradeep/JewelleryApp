package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 16-06-2016.
 */
public class Dispatched_Order_db {
    String name;
    String items;
    String delivery;
    String percentage_completed;
    String amount_paid;
    String amount ;
    public Dispatched_Order_db(String name, String items, String delivery, String percentage_completed, String amount_paid, String amount) {
        this.name = name;
        this.items = items;
        this.delivery = delivery;
        this.percentage_completed = percentage_completed;
        this.amount_paid = amount_paid;
        this.amount = amount;
    }
    public Dispatched_Order_db()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPercentage_completed() {
        return percentage_completed;
    }

    public void setPercentage_completed(String percentage_completed) {
        this.percentage_completed = percentage_completed;
    }

    public String getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(String amount_paid) {
        this.amount_paid = amount_paid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
