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

import com.example.gurupradeep.jewelery_app.Databases.Login;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class From_customer extends Fragment {


    public From_customer() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    //    Employee_list temp;
    ArrayList<F_customer> temp;
    List<String> name;
    List<String> items;
    List<Integer> amount;
    List<Integer> amount_paid;
    List<String> delivery;
    Login_database_handler login_database_handler;
    String query;
    SQLiteDatabase db;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Fragment fr;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_from_customer, container, false);

        r = (RecyclerView)v.findViewById(R.id.from_customer_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        //     temp = new Employee_list();
        //Getting the data from the database
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_ORDER;
        Cursor cursor = db.rawQuery(query,null);
        name = new ArrayList<>();
        items = new ArrayList<>();
        delivery = new ArrayList<>();
        amount = new ArrayList<>();
        amount_paid = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                name.add(cursor.getString(1));
                amount_paid.add(Integer.parseInt(cursor.getString(4)));
                amount.add(Integer.parseInt(cursor.getString(3)));

                items.add(cursor.getString(2));
                delivery.add(cursor.getString(5));
            } while (cursor.moveToNext());
        }

        temp = new ArrayList<F_customer>();
        for(int i=0;i<name.size();i++)
        {
            temp.add(new F_customer(name.get(i), items.get(i), amount_paid.get(i) + "/" + amount.get(i), delivery.get(i)));
        }
        adapter = new From_Customer_Adapter(getContext(), temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new From_Customer_Adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new From_Customer_Adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                fr = new From_customer_place_layout();
             //   args = new Bundle();
                //    Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_SHORT).show();
              //  args.putString("CID", phone_no.get(position));
          //      fr.setArguments(args);
                mFragmentTransaction.replace(R.id.from_customer_layout, fr);
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
