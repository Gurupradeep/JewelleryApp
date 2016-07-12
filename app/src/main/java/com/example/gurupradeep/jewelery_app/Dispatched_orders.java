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
import android.widget.Adapter;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dispatched_orders extends Fragment {


    public Dispatched_orders() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    List<String> name;
    List<String> items;
    List<Integer> amount;
    List<Integer> amount_paid;
    List<String> delivery;
    List<String> percentage;
    //    Employee_list temp;
    ArrayList<Dispatched_Orders_class> temp;
    Login_database_handler login_database_handler;
    String query;
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_dispatched_orders, container, false);
        r = (RecyclerView)v.findViewById(R.id.dispatched_orders_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_DISPATCHED_ORDER;
        Cursor cursor = db.rawQuery(query, null);
        name = new ArrayList<>();
        items = new ArrayList<>();
        delivery = new ArrayList<>();
        amount = new ArrayList<>();
        amount_paid = new ArrayList<>();
        percentage = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                name.add(cursor.getString(1));
                amount_paid.add(Integer.parseInt(cursor.getString(4)));
                amount.add(Integer.parseInt(cursor.getString(3)));
                items.add(cursor.getString(2));
                delivery.add(cursor.getString(5));
                percentage.add(cursor.getString(6));
            } while (cursor.moveToNext());
        }
        //     temp = new Employee_list();
        temp = new ArrayList<Dispatched_Orders_class>();
        for(int i=0;i<name.size();i++)
        {
            temp.add(new Dispatched_Orders_class(name.get(i),items.get(i),amount_paid.get(i)+"/"+amount.get(i),delivery.get(i),percentage.get(i)));
        }


        adapter = new Dispatched_Order_adapter(getContext(),temp);
        r.setAdapter(adapter);






        return v;
    }

}
