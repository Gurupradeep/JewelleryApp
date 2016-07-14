package com.example.gurupradeep.jewelery_app.Simple_Constructors;

/**
 * Created by Guru Pradeep on 11-06-2016.
 */

/**
 * Created by Guru Pradeep on 11-06-2016.
 */
public class Chit_funds_managing_class {

    public String due_no_of_ppl;
    public String amount_due;
    public String name;
    public String date;
    public String pooled_amount;
    public String no_of_chits_done;
    public Chit_funds_managing_class(String a, String b, String c, String d, String e,String f)
    {
        this.due_no_of_ppl = a;
        this.amount_due = b;
        this.name = c;
        this.date = d;
        this.pooled_amount = e;
        this.no_of_chits_done = f;
    }
}
