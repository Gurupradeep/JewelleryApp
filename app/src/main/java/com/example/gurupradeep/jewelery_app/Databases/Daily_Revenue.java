package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 22-06-2016.
 */
public class Daily_Revenue {
    String name;
    String category;
    String amount;

    Daily_Revenue()
    {

    }

    public Daily_Revenue(String name, String amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

