package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 17-06-2016.
 */
public class chit_fund_due {
    String name;
    String person_name ;
    String amount;
    public chit_fund_due()
    {

    }

    public chit_fund_due(String name, String person_name, String amount) {
        this.name = name;
        this.person_name = person_name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
