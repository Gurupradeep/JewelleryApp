package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 19-06-2016.
 */
public class Employee_skill {
    String no;
    String bangles;
    String necklaces;
    String rings;
    String Braclets;
    String chains;

    public Employee_skill(String no, String bangles, String necklaces, String braclets, String rings, String chains) {
        this.no = no;
        this.bangles = bangles;
        this.necklaces = necklaces;
        this.Braclets = braclets;
        this.rings = rings;
        this.chains = chains;
    }
    public Employee_skill()
    {

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBangles() {
        return bangles;
    }

    public void setBangles(String bangles) {
        this.bangles = bangles;
    }

    public String getNecklaces() {
        return necklaces;
    }

    public void setNecklaces(String necklaces) {
        this.necklaces = necklaces;
    }

    public String getRings() {
        return rings;
    }

    public void setRings(String rings) {
        this.rings = rings;
    }

    public String getBraclets() {
        return Braclets;
    }

    public void setBraclets(String braclets) {
        Braclets = braclets;
    }

    public String getChains() {
        return chains;
    }

    public void setChains(String chains) {
        this.chains = chains;
    }
}
