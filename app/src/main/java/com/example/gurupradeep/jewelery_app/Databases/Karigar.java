package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 21-06-2016.
 */
public class Karigar {

    String name;
    String rating;
    String specialisation;
    String phone_no;
    String address;

    public Karigar(String name, String rating, String specialisation, String phone_no, String address) {
        this.name = name;
        this.rating = rating;
        this.specialisation = specialisation;
        this.phone_no = phone_no;
        this.address = address;
    }
    public Karigar()
    {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
