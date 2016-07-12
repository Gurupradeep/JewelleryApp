package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 16-06-2016.
 */
public class To_be_delivered_db {
    String name;
    String items;
    String percentage;
    String amount;
    String amount_paid;

    public To_be_delivered_db(String name, String items, String percentage, String amount, String amount_paid) {
        this.name = name;
        this.items = items;
        this.percentage = percentage;
        this.amount = amount;
        this.amount_paid = amount_paid;
    }
    public To_be_delivered_db()
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

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
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
