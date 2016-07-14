package com.example.gurupradeep.jewelery_app.Simple_Constructors;

/**
 * Created by Guru Pradeep on 14-07-2016.
 */
public class chit_fund_part_of_constructor {
    public String no_of_ppl;
    public String due_amount;
    public String name;
    public String date;
    public String pooled_amount;
    public String no_of_chits_done;

    public chit_fund_part_of_constructor(String no_of_ppl, String due_amount, String name, String date, String pooled_amount, String no_of_chits_done) {
        this.no_of_ppl = no_of_ppl;
        this.due_amount = due_amount;
        this.name = name;
        this.date = date;
        this.pooled_amount = pooled_amount;
        this.no_of_chits_done = no_of_chits_done;
    }
}
