package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 16-06-2016.
 */
public class Employee_db {
    String name;
    String address;
    String phone_no;
    String experience;
    String joining_date;
    String Salary;

    public Employee_db(String name, String address, String phone_no, String experience, String salary, String joining_date) {
        this.name = name;
        this.address = address;
        this.phone_no = phone_no;
        this.experience = experience;
        Salary = salary;
        this.joining_date = joining_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
