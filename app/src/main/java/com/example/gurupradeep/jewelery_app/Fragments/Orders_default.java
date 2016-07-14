package com.example.gurupradeep.jewelery_app.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.Fragments.Best_Karigar;
import com.example.gurupradeep.jewelery_app.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Orders_default extends Fragment {


    public Orders_default() {
        // Required empty public constructor
    }
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;
    Login_database_handler login_database_handler;
    String query;
    SQLiteDatabase db;
    Integer from_customer;
    Integer requested;
    Integer dispatched;
    Integer to_be_delivered;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_orders_default, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder10, new Best_Karigar());
        mFragmentTransaction.commit();
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_ORDER;
        cursor = db.rawQuery(query,null);
        from_customer = cursor.getCount();
        query = "SELECT * FROM "+ login_database_handler.TABLE_REQUESTED_ORDER;
        cursor = db.rawQuery(query,null);
        requested = cursor.getCount();
        query = "SELECT * FROM "+ login_database_handler.TABLE_DISPATCHED_ORDER;
        cursor = db.rawQuery(query,null);
        dispatched = cursor.getCount();
        query = "SELECT * FROM "+ login_database_handler.TABLE_ORDER;
         cursor = db.rawQuery(query,null);
        to_be_delivered = cursor.getCount();

        BarChart barChart = (BarChart)v.findViewById(R.id.order_default_chart);
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(from_customer, 0));
        entries.add(new BarEntry(requested, 1));
        entries.add(new BarEntry(dispatched, 2));
        entries.add(new BarEntry(to_be_delivered, 3));
        BarDataSet dataset = new BarDataSet(entries, "stages of order");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("From customer");
        labels.add("Requested");
        labels.add("Dispatched");
        labels.add("To be delivered");
        BarData data = new BarData(labels, dataset);
        barChart.setData(data); // set the data and list of lables into chart
        barChart.setDescription(" ");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(1000);





        return v;
    }

}
