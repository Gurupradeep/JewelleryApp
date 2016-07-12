package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 22-06-2016.
 */
public class Monthly_Profit {

    String name;
    String category;
    String amount;

    Monthly_Profit(){

    }

    public Monthly_Profit(String name, String category, String amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
