package com.example.gurupradeep.jewelery_app;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Loyality_profit extends Fragment {

    SQLiteDatabase db;
    Login_database_handler login_database_handler;
    List<String> scheme_name;
    List<Integer> profit;
    public Loyality_profit() {
        // Required empty public constructor
    }

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;
    String query;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_loyality_profit, container, false);
        BarChart barChart = (BarChart)v.findViewById(R.id.chart7);
        // Getting the Require data from database
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_LOYALITY;
        Cursor cursor = db.rawQuery(query,null);
        scheme_name = new ArrayList<>();
        profit = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                    scheme_name.add(cursor.getString(1));
                    profit.add(Integer.parseInt(cursor.getString(3)));
            } while (cursor.moveToNext());
        }

        ArrayList<BarEntry> entries = new ArrayList<>();
        for(int i=0;i<profit.size();i++) {
          //  entries.add(new BarEntry(4f, 0));
            entries.add(new BarEntry(profit.get(i),i));
        }
        BarDataSet dataset = new BarDataSet(entries, "No of schemes");
        ArrayList<String> labels = new ArrayList<String>();
        for(int i=0;i<scheme_name.size();i++)
        {
            labels.add(scheme_name.get(i));
        }
        BarData data = new BarData(labels, dataset);
        barChart.setData(data); // set the data and list of lables into chart
        barChart.setDescription(" ");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(1000);
        android.support.v4.app.FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder7, new Scheme_profit());
        mFragmentTransaction.commit();
        return v;
    }

}
