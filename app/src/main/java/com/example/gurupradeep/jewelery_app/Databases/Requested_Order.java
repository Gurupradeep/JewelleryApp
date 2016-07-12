package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 16-06-2016.
 */
public class Requested_Order {
    String name;
    String items;
    String delivery;
    String quotes_dispatched;
    String quotes_recieved;
    String amount;
    String amount_paid;

    public Requested_Order(String name, String items, String delivery, String quotes_dispatched, String quotes_recieved, String amount, String amount_paid) {
        this.name = name;
        this.items = items;
        this.delivery = delivery;
        this.quotes_dispatched = quotes_dispatched;
        this.quotes_recieved = quotes_recieved;
        this.amount = amount;
        this.amount_paid = amount_paid;
    }
    public Requested_Order()
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

    public String getQuotes_dispatched() {
        return quotes_dispatched;
    }

    public void setQuotes_dispatched(String quotes_dispatched) {
        this.quotes_dispatched = quotes_dispatched;
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

    public String getQuotes_recieved() {
        return quotes_recieved;
    }

    public void setQuotes_recieved(String quotes_recieved) {
        this.quotes_recieved = quotes_recieved;
    }
}
