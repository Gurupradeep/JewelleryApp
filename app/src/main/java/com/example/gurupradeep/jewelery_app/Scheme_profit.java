package com.example.gurupradeep.jewelery_app;


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

import com.example.gurupradeep.jewelery_app.Adapters.Loyality_profit_adapter;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scheme_profit extends Fragment {


    public Scheme_profit() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    ArrayList<loyality_scheme> temp;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    SQLiteDatabase db;
    Login_database_handler login_database_handler;
    List<String> scheme_name;
    List<String> profit;
    String query;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_scheme_profit, container, false);
        r = (RecyclerView)v.findViewById(R.id.Schemes_profit_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);



        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_LOYALITY;
        Cursor cursor = db.rawQuery(query,null);
        scheme_name = new ArrayList<>();
        profit = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                scheme_name.add(cursor.getString(1));
                profit.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        temp = new ArrayList<loyality_scheme>();
        for(int i=0;i<scheme_name.size();i++)
        {
            temp.add(new loyality_scheme(scheme_name.get(i),profit.get(i)));
        }

        //     temp = new Employee_list();
        adapter = new Loyality_profit_adapter(getContext(),temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new Loyality_profit_adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new Loyality_profit_adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.loyality_profit_layout, new Scheme1_details());
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
