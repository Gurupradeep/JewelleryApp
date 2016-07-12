package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 21-06-2016.
 */
public class Karigar_specialisation {

    String no;
    String item;
    String commission;
    String rating;

    public Karigar_specialisation(String no, String item, String commission, String rating) {
        this.no = no;
        this.item = item;
        this.commission = commission;
        this.rating = rating;
    }
    public Karigar_specialisation()
    {

    }
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
