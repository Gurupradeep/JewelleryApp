package com.example.gurupradeep.jewelery_app.Databases;

import com.example.gurupradeep.jewelery_app.Employee;

/**
 * Created by Guru Pradeep on 19-06-2016.
 */
public class Employee_Type {
    String no;
    String rich;
    String bargaining;
    String trustworthy;

    public Employee_Type(String no, String rich, String bargaining, String trustworthy) {
        this.no = no;
        this.rich = rich;
        this.bargaining = bargaining;
        this.trustworthy = trustworthy;
    }
    public Employee_Type()
    {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRich() {
        return rich;
    }

    public void setRich(String rich) {
        this.rich = rich;
    }

    public String getBargaining() {
        return bargaining;
    }

    public void setBargaining(String bargaining) {
        this.bargaining = bargaining;
    }

    public String getTrustworthy() {
        return trustworthy;
    }

    public void setTrustworthy(String trustworthy) {
        this.trustworthy = trustworthy;
    }
}
