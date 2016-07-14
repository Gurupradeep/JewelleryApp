package com.example.gurupradeep.jewelery_app.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
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
public class Monthly_report extends Fragment {


    public Monthly_report() {
        // Required empty public constructor
    }
    Login_database_handler login_database_handler;
    SQLiteDatabase db;
    Cursor cursor;
    String query;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_monthly_report, container, false);
        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);
        BarChart barChart =(BarChart)v.findViewById(R.id.Monthly_barchart);

        //  BarDataSet dataset = new BarDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Jan");
        labels.add("Feb");
        labels.add("Mar");
        labels.add("Apr");
        labels.add("May");
 //       labels.add("Jun");

        // for create Grouped Bar chart
        ArrayList<BarEntry> revenue= new ArrayList<>();
        revenue.add(new BarEntry(4f, 0));
        revenue.add(new BarEntry(8f, 1));
        revenue.add(new BarEntry(6f, 2));
        revenue.add(new BarEntry(12f, 3));
        revenue.add(new BarEntry(18f, 4));
//        group1.add(new BarEntry(9f, 5));

        ArrayList<BarEntry> expense = new ArrayList<>();
        expense.add(new BarEntry(6f, 0));
        expense.add(new BarEntry(7f, 1));
        expense.add(new BarEntry(8f, 2));
        expense.add(new BarEntry(12f, 3));
        expense.add(new BarEntry(15f, 4));
   //     group2.add(new BarEntry(10f, 5));

        BarDataSet barDataSet1 = new BarDataSet(revenue, "Revenue");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
      //  barDataSet1.setColors(new int[]{context.getResources().getColor(R.color.green),
      //          context.getResources().getColor(R.color.orange),
      //          context.getResources().getColor(R.color.red)});
            barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(expense, "Expense");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);

        BarData data = new BarData(labels, dataset);
        barChart.setDescription(" ");
        // dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        barChart.setData(data);
        barChart.animateY(1000);







        return v;
    }

}
