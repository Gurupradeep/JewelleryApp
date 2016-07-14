package com.example.gurupradeep.jewelery_app.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
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
public class Emplyoee2 extends Fragment {


    public Emplyoee2() {
        // Required empty public constructor
    }

    PieChart pieChart;
    ArrayList<Entry> entries;
    PieDataSet dataset;
    ArrayList<String> labels;
    PieData data;
    String txt;
    Login_database_handler login_database_handler;
    SQLiteDatabase db;
    String query;
    Cursor cursor;
    TextView name;
    TextView address;
    TextView phone_no;
    List<Integer> skill;
    List<Integer> type;
    List<Integer> attendance;
    List<Integer> months;
    java.util.Date date;
    Calendar cal;
    int month;
    List<String>month_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_emplyoee2, container, false);
        pieChart = (PieChart)v.findViewById(R.id.chart);
        date = new Date();
        cal = Calendar.getInstance();
        cal.setTime(date);
         month = cal.get(Calendar.MONTH);
        month = month +1;

        //Initailising the month names

        month_name = new ArrayList<>();
        month_name.add("January");
        month_name.add("February");
        month_name.add("March");
        month_name.add("April");
        month_name.add("May");
        month_name.add("June");
        month_name.add("July");
        month_name.add("August");
        month_name.add("September");
        month_name.add("October");
        month_name.add("November");
        month_name.add("December");

        //getting data from the other fragment

        txt = getArguments().getString("CID");

        //Identifying the unique indentity in database

        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        cursor = db.query(login_database_handler.TABLE_EMPLOYEE, new String[]{login_database_handler.Key_employee_name, login_database_handler.key_employee_phone_no, login_database_handler.key_employee_address}, login_database_handler.key_employee_phone_no + "=?",
                new String[]{txt}, null, null, null, null);
        //Assigning values based on the Employee
        name = (TextView)v.findViewById(R.id.employee_name);
        phone_no = (TextView)v.findViewById(R.id.employee_phone_no);
        address =(TextView)v.findViewById(R.id.employee_address);

        if(cursor.moveToFirst()) {
            name.setText(cursor.getString(0));
            phone_no.setText(cursor.getString(1));
            address.setText(cursor.getString(2));
        }
        cursor = db.query(login_database_handler.TABLE_EMPLOYEE_SKILLS, new String[]{login_database_handler.key_bangles, login_database_handler.key_chains, login_database_handler.key_braclets,login_database_handler.key_rings,login_database_handler.key_necklaces}, login_database_handler.key_employee_skill_no + "=?",
                new String[]{txt}, null, null, null, null);
        skill = new ArrayList<>();
        if(cursor.moveToFirst()){
            skill.add(Integer.parseInt(cursor.getString(0)));
            skill.add(Integer.parseInt(cursor.getString(1)));
            skill.add(Integer.parseInt(cursor.getString(2)));
            skill.add(Integer.parseInt(cursor.getString(3)));
            skill.add(Integer.parseInt(cursor.getString(4)));
        }
        cursor = db.query(login_database_handler.TABLE_EMPLOYEE_TYPE, new String[]{login_database_handler.key_bargaining, login_database_handler.key_rich, login_database_handler.key_trustworthy}, login_database_handler.key_employee_type_no + "=?",
                new String[]{txt}, null, null, null, null);
        type = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            type.add(Integer.parseInt(cursor.getString(0)));
            type.add(Integer.parseInt(cursor.getString(1)));
            type.add(Integer.parseInt(cursor.getString(2)));
        }
        cursor = db.query(login_database_handler.TABLE_EMPLOYEE_ATTENDANCE, new String[]{login_database_handler.key_jan, login_database_handler.key_feb, login_database_handler.key_mar,login_database_handler.key_apr,login_database_handler.key_may,login_database_handler.key_jun,login_database_handler.key_jul,login_database_handler.key_aug,login_database_handler.key_sep,login_database_handler.key_oct,login_database_handler.key_nov,login_database_handler.key_dec}, login_database_handler.key_employee_attendance_no + "=?",
                new String[]{txt}, null, null, null, null);
        attendance = new ArrayList<>();
        months = new ArrayList<>();

        for(int i=0;i<6;i++)
        {
            months.add((month-1+i)%12);
        }

        if(cursor.moveToFirst())
        {
            attendance.add(Integer.parseInt(cursor.getString(0)));
            attendance.add(Integer.parseInt(cursor.getString(1)));
            attendance.add(Integer.parseInt(cursor.getString(2)));
            attendance.add(Integer.parseInt(cursor.getString(3)));
            attendance.add(Integer.parseInt(cursor.getString(4)));
            attendance.add(Integer.parseInt(cursor.getString(5)));
            attendance.add(Integer.parseInt(cursor.getString(6)));
            attendance.add(Integer.parseInt(cursor.getString(7)));
            attendance.add(Integer.parseInt(cursor.getString(8)));
            attendance.add(Integer.parseInt(cursor.getString(9)));
            attendance.add(Integer.parseInt(cursor.getString(10)));
            attendance.add(Integer.parseInt(cursor.getString(11)));
        }
// creating data values
        Toast.makeText(getActivity(),(cursor.getString(5)), Toast.LENGTH_SHORT).show();
        entries = new ArrayList<>();
        for(int i=0;i<months.size();i++)
        {
            entries.add(new Entry(Integer.parseInt(cursor.getString(months.get(i))),i));
        }
        dataset = new PieDataSet(entries, "");
        labels = new ArrayList<String>();
        for(int i=0;i<months.size();i++)
        {
            labels.add(month_name.get(months.get(i)));
        }
        data = new PieData(labels, dataset); // initialize Piedata
        pieChart.setData(data); //set data into chart
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setDescription(" ");
        //Skills Chart
        HorizontalBarChart barChart = (HorizontalBarChart)v.findViewById(R.id.chart2);
        ArrayList<BarEntry> entries1 = new ArrayList<>();
        for(int i = 0;i < skill.size();i++)
        {
            entries1.add(new BarEntry(skill.get(i),i));
        }
        BarDataSet dataset = new BarDataSet(entries1, "# of Calls");
        ArrayList<String> labels1= new ArrayList<String>();
        labels1.add("Bangles");
        labels1.add("Chains");
        labels1.add("Braclets");
        labels1.add("Rings");
        labels1.add("Necklaces");
        //labels1.add("June");
        BarData data = new BarData(labels1, dataset);
        barChart.setData(data);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setDescription(" ");
       //Customer Type Chart
        HorizontalBarChart barChart1 = (HorizontalBarChart)v.findViewById(R.id.chart3);
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        for(int i = 0; i < type.size(); i++)
        {
            entries2.add(new BarEntry(type.get(i),i));
        }
        BarDataSet dataset1 = new BarDataSet(entries2, "# of Calls");
        ArrayList<String> labels2= new ArrayList<String>();
        labels2.add("Bargaining");
        labels2.add("Rich");
        labels2.add("Trust Worthy");
        BarData data1 = new BarData(labels2, dataset1);
        barChart1.setData(data1);
        dataset1.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart1.setDescription(" ");
        return v;
    }

}
