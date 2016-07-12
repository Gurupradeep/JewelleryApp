package com.example.gurupradeep.jewelery_app;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chit_funds_managing_chit1 extends Fragment {


    public Chit_funds_managing_chit1() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    ArrayList<chit_class> temp;
    ArrayList<Entry> entries;
    Login_database_handler login_database_handler;
    SQLiteDatabase db;
    Cursor cursor;
    String query;
    String txt;
    List<String> name;
    List<String > amount;
    TextView chit_name;
    TextView start_date;
    TextView _amount;
    TextView no_of_chits;
    TextView no_of_ppl;
    TextView total_no_of_ppl;
    TextView due_amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        txt = getArguments().getString("CID");
  //      Toast.makeText(getActivity(),txt, Toast.LENGTH_SHORT).show();
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();

        cursor = db.query(login_database_handler.TABLE_CHIT_FUND_DUE, new String[]{login_database_handler.key_due_chit_name, login_database_handler.key_due_person, login_database_handler.key_due_amount}, login_database_handler.key_due_chit_name + "=?",
                new String[]{txt}, null, null, null, null);

       // Toast.makeText(getActivity(),Integer.toString(cursor.getCount()), Toast.LENGTH_SHORT).show();
        name = new ArrayList<>();
        amount = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                name.add(cursor.getString(1));
                amount.add((cursor.getString(2)));
                //         due_amount.add(Integer.parseInt(cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        cursor = db.query(login_database_handler.TABLE_CHIT_FUNDS, new String[]{login_database_handler.key_chit_name, login_database_handler.key_chit_start_date, login_database_handler.key_chit_pooled_amount,login_database_handler.key_no_chits_done,login_database_handler.key_chit_no_of_people_involved,login_database_handler.key_chit_no_of_people_due,login_database_handler.key_chit_due_amount},
                login_database_handler.key_chit_name + "=?",
                new String[]{txt}, null, null, null, null);

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chit_funds_managing_chit1, container, false);
        //Changing data according to the card
        chit_name = (TextView)v.findViewById(R.id.chit_fund_managing_name);
        start_date = (TextView)v.findViewById(R.id.chit_funds_managing_start_date);
        _amount = (TextView)v.findViewById(R.id.chit_funds_managing_pooled);
        no_of_chits = (TextView)v.findViewById(R.id.chit_funds_managing_no_of_chits_done);
        no_of_ppl = (TextView)v.findViewById(R.id.chit_funds_managing_ppl);
  //      no_of_due_ppl = (TextView)v.findViewById(R.id.chit_fund_managing_name);
        due_amount = (TextView)v.findViewById(R.id.chit_funds_managing_amount);
        total_no_of_ppl = (TextView)v.findViewById(R.id.chit_managing_chit1_no_of_members);
        if(cursor.moveToFirst()) {
            chit_name.setText(cursor.getString(0));
            start_date.setText(cursor.getString(1));
            _amount.setText("Amount(Pooled):   "+cursor.getString(2));
            no_of_chits.setText(cursor.getString(3) + " Chits done");
            no_of_ppl.setText(cursor.getString(5) + "/" +cursor.getString(4));
            due_amount.setText("Rs " + cursor.getString(6));
            total_no_of_ppl.setText("No of members : "+ cursor.getString(4));
        }
        LineChart lineChart = (LineChart)v.findViewById(R.id.chart8);
        // creating list of entry
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));
        LineDataSet dataset = new LineDataSet(entries, "# of Calls");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        LineData data = new LineData(labels, dataset);
        lineChart.setData(data); // set the data and list of lables into chart
        lineChart.setDescription("Description");  // set the description
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
   //     LineChart.animateY(5000);
        r = (RecyclerView)v.findViewById(R.id.chit1_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        //     temp = new Employee_list();
        temp = new ArrayList<chit_class>();
        for(int i=0;i<name.size();i++)
        {
            temp.add(new chit_class(name.get(i),"Rs "+amount.get(i)));
        }




        adapter = new Chit1_adapter(getContext(),temp);
        r.setAdapter(adapter);


















        return v;
    }

}
