package com.example.gurupradeep.jewelery_app.Fragments;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.Databases.Monthly_Profit;
import com.example.gurupradeep.jewelery_app.Databases.Monthly_Revenue;
import com.example.gurupradeep.jewelery_app.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Monthly_details1 extends Fragment {


    public Monthly_details1() {
        // Required empty public constructor
    }
   public PieChart pieChart;
    ArrayList<Entry> entries;
    PieDataSet dataset;
    ArrayList<String> labels;
    PieData data;
    PieChart pieChart1;
    ArrayList<Entry> entries1;
    PieDataSet dataset1;
    ArrayList<String> labels1;
    PieData data1;
    PieChart pieChart2;
    PieChart pieChart3;
    ArrayList<Entry>entries3;
    ArrayList<String>labels3;
    ArrayList<Entry >entries2;
    ArrayList<String >labels2;
    PieDataSet dataset2;
    PieDataSet  dataset3;
    PieData data3;
    PieData data2;
    Login_database_handler login_database_handler;
    SQLiteDatabase db;
    Cursor cursor;
    String query;
    List<String> month_name;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    TextView revenue;
    TextView profit;
    java.util.Date date;
    Calendar cal;
    int month;
    List<Integer>month_numbers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_montly_details1, container, false);
        final PieChart pieChart = (PieChart)v.findViewById(R.id.revenue_chart);
        month_name = new ArrayList<>();
        entries2 = new ArrayList<>();
        labels2 = new ArrayList<>();
        entries3 = new ArrayList<>();
        labels3 = new ArrayList<>();
        month_name.add("Jan");
        month_name.add("Feb");
        month_name.add("Mar");
        month_name.add("Apr");
        month_name.add("May");
        month_name.add("Jun");
        month_name.add("Jul");
        month_name.add("Aug");
        month_name.add("Sep");
        month_name.add("Oct");
        month_name.add("Nov");
        month_name.add("Dec");

       //Getting Reference to all fields
        pieChart2 = (PieChart) v.findViewById(R.id.revenue_chart);
        pieChart3 = (PieChart) v.findViewById(R.id.profit_chart);
        b1 = (Button)v.findViewById(R.id.month1);
        b2 = (Button)v.findViewById(R.id.month2);
        b3 = (Button)v.findViewById(R.id.month3);
        b4 = (Button)v.findViewById(R.id.month4);
        b5 = (Button)v.findViewById(R.id.month5);
        revenue = (TextView)v.findViewById(R.id.Revenue_of_month);
        profit = (TextView)v.findViewById(R.id.monthly_profit);

        //Getting Current month and changing the month values accordingly
        date = new Date();
        cal = Calendar.getInstance();
        cal.setTime(date);
        month = cal.get(Calendar.MONTH);
        month_numbers = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            if(month>=0) {
                month_numbers.add(month);
                month--;
            }
            else
            {
                int temp;
                temp = 12 - (-(month));
                month_numbers.add(temp);
                month --;
            }

        }
        b1.setText(month_name.get(month_numbers.get(0)));
        b2.setText(month_name.get(month_numbers.get(1)));
        b3.setText(month_name.get(month_numbers.get(2)));
        b4.setText(month_name.get(month_numbers.get(3)));
        b5.setText(month_name.get(month_numbers.get(4)));

        //Adding dummy Values
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Jan", "Necklaces", "10000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Jan", "EMI", "10000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Jan", "Rings", "10000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Jan", "Bangles", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Jan", "Bangles", "20000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Jan", "EMI", "20000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Jan", "Chains", "20000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Jan", "Rings", "20000"));
        //for Feb
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Feb", "Necklaces", "10000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Feb", "EMI", "10000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Feb", "Rings", "10000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Feb", "Bangles", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Feb", "Bangles", "20000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Feb", "EMI", "20000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Feb", "Chains", "20000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Feb", "Rings", "20000"));
        //For March
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Mar", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Mar", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Apr", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Apr", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("May", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("May", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Jun", "Necklaces", "1519"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Jun", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Jul", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Jul", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Aug", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Aug", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Sep", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Sep", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Oct", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Oct", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Nov", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Nov", "Bangles", "20000"));
        login_database_handler.add_monthly_revenue(new Monthly_Revenue("Dec", "Necklaces", "10000"));
        login_database_handler.add_monthly_profit(new Monthly_Profit("Dec", "Bangles", "20000"));

        // Getting the Required Data from Database
        login_database_handler = new Login_database_handler(getContext(),null,null,7);
        db = login_database_handler.getWritableDatabase();
        String txt = month_name.get(month_numbers.get(0));
        cursor = db.query(login_database_handler.TABLE_MONTHLY_REVENUE, new String[]{login_database_handler.key_monthly_revenue_category,login_database_handler.key_revenue_by_category}, login_database_handler.key_revenue_month_name + "=?",
                new String[]{txt}, null, null, null, null);
        entries = new ArrayList<>();
        labels = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                 entries.add(new Entry(Integer.parseInt(cursor.getString(1)),0));
                 labels.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        dataset = new PieDataSet(entries, "# of Calls");
        data = new PieData(labels, dataset); // initialize Piedata
         pieChart.setData(data); //set data into chart
         dataset.setColors(ColorTemplate.COLORFUL_COLORS);
         pieChart.setDescription(" ");

        //For Profit Chart

        cursor = db.query(login_database_handler.TABLE_MONTHLY_PROFIT, new String[]{login_database_handler.key_monthly_profit_category,login_database_handler.key_profit_by_category}, login_database_handler.key_profit_month_name + "=?",
                new String[]{txt}, null, null, null, null);
        final PieChart pieChart1 = (PieChart)v.findViewById(R.id.profit_chart);
        entries1 = new ArrayList<>();
        labels1 = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                entries1.add(new Entry(Integer.parseInt(cursor.getString(1)),0));
                labels1.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        dataset1 = new PieDataSet(entries1, "# of Calls");
        data1= new PieData(labels1, dataset1); // initialize Piedata
        pieChart1.setData(data1); //set data into chart
        dataset1.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart1.setDescription(" ");
        //Creating Template function

        //Setting event listeners to all buttons
        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                pieChart.clear();
                entries3.clear();
                labels2.clear();
                entries2.clear();
                labels3.clear();
                String  txt = month_name.get(month_numbers.get(1));
                cursor = db.query(login_database_handler.TABLE_MONTHLY_REVENUE, new String[]{login_database_handler.key_monthly_revenue_category,login_database_handler.key_revenue_by_category}, login_database_handler.key_revenue_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                int i = 0;
                if (cursor.moveToFirst()) {
                    do {

                        entries2.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels2.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset2 = new PieDataSet(entries2, "# of Calls");
                data2 = new PieData(labels2, dataset2); // initialize Piedata
                pieChart2.setData(data2); //set data into chart
                dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart2.setDescription(" ");

                //For Profit Chart
                pieChart1.clear();
                cursor = db.query(login_database_handler.TABLE_MONTHLY_PROFIT, new String[]{login_database_handler.key_monthly_profit_category,login_database_handler.key_profit_by_category}, login_database_handler.key_profit_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                i = 0;
                if (cursor.moveToFirst()) {
                    do {
                        entries3.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels3.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset3 = new PieDataSet(entries3, "# of Calls");
                data3= new PieData(labels3, dataset3); // initialize Piedata
                pieChart3.setData(data3); //set data into chart
                dataset3.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart3.setDescription(" ");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pieChart.clear();
                entries3.clear();
                labels2.clear();
                entries2.clear();
                labels3.clear();
                String txt = month_name.get(month_numbers.get(2));
                cursor = db.query(login_database_handler.TABLE_MONTHLY_REVENUE, new String[]{login_database_handler.key_monthly_revenue_category, login_database_handler.key_revenue_by_category}, login_database_handler.key_revenue_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                int i = 0;
                if (cursor.moveToFirst()) {
                    do {

                        entries2.add(new Entry(Integer.parseInt(cursor.getString(1)), i));
                        labels2.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset2 = new PieDataSet(entries2, "# of Calls");
                data2 = new PieData(labels2, dataset2); // initialize Piedata
                pieChart2.setData(data2); //set data into chart
                dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart2.setDescription(" ");

                //For Profit Chart
                pieChart1.clear();
                cursor = db.query(login_database_handler.TABLE_MONTHLY_PROFIT, new String[]{login_database_handler.key_monthly_profit_category, login_database_handler.key_profit_by_category}, login_database_handler.key_profit_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                i = 0;
                if (cursor.moveToFirst()) {
                    do {
                        entries3.add(new Entry(Integer.parseInt(cursor.getString(1)), i));
                        labels3.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset3 = new PieDataSet(entries3, "# of Calls");
                data3 = new PieData(labels3, dataset3); // initialize Piedata
                pieChart3.setData(data3); //set data into chart
                dataset3.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart3.setDescription(" ");

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pieChart.clear();
                entries3.clear();
                labels2.clear();
                entries2.clear();
                labels3.clear();
                String  txt = month_name.get(month_numbers.get(3));
                cursor = db.query(login_database_handler.TABLE_MONTHLY_REVENUE, new String[]{login_database_handler.key_monthly_revenue_category,login_database_handler.key_revenue_by_category}, login_database_handler.key_revenue_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                int i = 0;
                if (cursor.moveToFirst()) {
                    do {

                        entries2.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels2.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset2 = new PieDataSet(entries2, "# of Calls");
                data2 = new PieData(labels2, dataset2); // initialize Piedata
                pieChart2.setData(data2); //set data into chart
                dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart2.setDescription(" ");

                //For Profit Chart
                pieChart1.clear();
                cursor = db.query(login_database_handler.TABLE_MONTHLY_PROFIT, new String[]{login_database_handler.key_monthly_profit_category,login_database_handler.key_profit_by_category}, login_database_handler.key_profit_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                i = 0;
                if (cursor.moveToFirst()) {
                    do {
                        entries3.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels3.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset3 = new PieDataSet(entries3, "# of Calls");
                data3= new PieData(labels3, dataset3); // initialize Piedata
                pieChart3.setData(data3); //set data into chart
                dataset3.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart3.setDescription(" ");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pieChart.clear();
                entries3.clear();
                labels2.clear();
                entries2.clear();
                labels3.clear();
                String  txt = month_name.get(month_numbers.get(4));
                cursor = db.query(login_database_handler.TABLE_MONTHLY_REVENUE, new String[]{login_database_handler.key_monthly_revenue_category,login_database_handler.key_revenue_by_category}, login_database_handler.key_revenue_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                int i = 0;
                if (cursor.moveToFirst()) {
                    do {

                        entries2.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels2.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset2 = new PieDataSet(entries2, "# of Calls");
                data2 = new PieData(labels2, dataset2); // initialize Piedata
                pieChart2.setData(data2); //set data into chart
                dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart2.setDescription(" ");

                //For Profit Chart
                pieChart1.clear();
                cursor = db.query(login_database_handler.TABLE_MONTHLY_PROFIT, new String[]{login_database_handler.key_monthly_profit_category,login_database_handler.key_profit_by_category}, login_database_handler.key_profit_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                i = 0;
                if (cursor.moveToFirst()) {
                    do {
                        entries3.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels3.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset3 = new PieDataSet(entries3, "# of Calls");
                data3= new PieData(labels3, dataset3); // initialize Piedata
                pieChart3.setData(data3); //set data into chart
                dataset3.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart3.setDescription(" ");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pieChart.clear();
                entries3.clear();
                labels2.clear();
                entries2.clear();
                labels3.clear();
                String  txt = month_name.get(month_numbers.get(0));
                cursor = db.query(login_database_handler.TABLE_MONTHLY_REVENUE, new String[]{login_database_handler.key_monthly_revenue_category,login_database_handler.key_revenue_by_category}, login_database_handler.key_revenue_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                int i = 0;
                if (cursor.moveToFirst()) {
                    do {

                        entries2.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels2.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset2 = new PieDataSet(entries2, "# of Calls");
                data2 = new PieData(labels2, dataset2); // initialize Piedata
                pieChart2.setData(data2); //set data into chart
                dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart2.setDescription(" ");

                //For Profit Chart
                pieChart1.clear();
                cursor = db.query(login_database_handler.TABLE_MONTHLY_PROFIT, new String[]{login_database_handler.key_monthly_profit_category,login_database_handler.key_profit_by_category}, login_database_handler.key_profit_month_name + "=?",
                        new String[]{txt}, null, null, null, null);
                i = 0;
                if (cursor.moveToFirst()) {
                    do {
                        entries3.add(new Entry(Integer.parseInt(cursor.getString(1)),i));
                        labels3.add(cursor.getString(0));
                        i++;
                    } while (cursor.moveToNext());
                }
                dataset3 = new PieDataSet(entries3, "# of Calls");
                data3= new PieData(labels3, dataset3); // initialize Piedata
                pieChart3.setData(data3); //set data into chart
                dataset3.setColors(ColorTemplate.COLORFUL_COLORS);
                pieChart3.setDescription(" ");

            }
        });
        return v;
    }

}