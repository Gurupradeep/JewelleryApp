package com.example.gurupradeep.jewelery_app.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Adapters.Loyality_customers_adapter;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.loyality_scheme;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Schemes_Customer extends Fragment {


    public Schemes_Customer() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    //    Employee_list temp;
    ArrayList<loyality_scheme> temp;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    SQLiteDatabase db;
    Login_database_handler login_database_handler;
    List<String> scheme_name;
    List<String> Customer;
    String query;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_schemes__customer, container, false);
        r = (RecyclerView)v.findViewById(R.id.Schemes_customer_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        //     temp = new Employee_list();
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_LOYALITY;
        Cursor cursor = db.rawQuery(query,null);
        scheme_name = new ArrayList<>();
        Customer = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                scheme_name.add(cursor.getString(1));
                Customer.add(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        temp = new ArrayList<loyality_scheme>();
        for(int i=0;i<scheme_name.size();i++)
        {
            temp.add(new loyality_scheme(scheme_name.get(i),Customer.get(i)));
        }

        adapter = new Loyality_customers_adapter(getContext(),temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new Loyality_customers_adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new Loyality_customers_adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.loyality_customers_layout, new Scheme1_details());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return v;
    }

}
