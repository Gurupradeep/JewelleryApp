package com.example.gurupradeep.jewelery_app.Databases;

/**
 * Created by Guru Pradeep on 17-06-2016.
 */
public class chit_fund {
    String name;
    String start_date;
    String pooled_amount;
    String no_of_chits_done;
    String no_of_ppl ;
    String no_of_ppl_due;
    String due_amount;

    public chit_fund()
    {

    }
    public chit_fund(String name, String start_date, String pooled_amount, String no_of_chits_done, String no_of_ppl, String no_of_ppl_due, String due_amount) {
        this.name = name;
        this.start_date = start_date;
        this.pooled_amount = pooled_amount;
        this.no_of_chits_done = no_of_chits_done;
        this.no_of_ppl = no_of_ppl;
        this.no_of_ppl_due = no_of_ppl_due;
        this.due_amount = due_amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getPooled_amount() {
        return pooled_amount;
    }

    public void setPooled_amount(String pooled_amount) {
        this.pooled_amount = pooled_amount;
    }

    public String getNo_of_chits_done() {
        return no_of_chits_done;
    }

    public void setNo_of_chits_done(String no_of_chits_done) {
        this.no_of_chits_done = no_of_chits_done;
    }

    public String getNo_of_ppl() {
        return no_of_ppl;
    }

    public void setNo_of_ppl(String no_of_ppl) {
        this.no_of_ppl = no_of_ppl;
    }

    public String getNo_of_ppl_due() {
        return no_of_ppl_due;
    }

    public void setNo_of_ppl_due(String no_of_ppl_due) {
        this.no_of_ppl_due = no_of_ppl_due;
    }

    public String getDue_amount() {
        return due_amount;
    }

    public void setDue_amount(String due_amount) {
        this.due_amount = due_amount;
    }
}
