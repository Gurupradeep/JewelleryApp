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

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Best_Karigar extends Fragment {


    public Best_Karigar() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    //    Employee_list temp;
    ArrayList<Karigar> temp;
    ArrayList<String> name;
    ArrayList<String> rating;
    ArrayList<String > area;
    Login_database_handler login_database_handler;
    SQLiteDatabase db;
    String query;
    Cursor cursor;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Fragment fr;
    Bundle args;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_best__karigar, container, false);
        r = (RecyclerView)v.findViewById(R.id.karigar_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        //Getting data from the database
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_KARIGAR;
        cursor = db.rawQuery(query,null);
        name = new ArrayList<>();
        rating = new ArrayList<>();
        area = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                name.add(cursor.getString(1));
                rating.add(cursor.getString(5));
                area.add(cursor.getString(4));
            } while (cursor.moveToNext());
        }

        temp = new ArrayList<Karigar>();
        for(int i=0;i<name.size();i++)
        {
            temp.add(new Karigar(name.get(i),rating.get(i)+"/"+"10",area.get(i)));
        }
        adapter = new Best_Karigar_adapter(getContext(), temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new Best_Karigar_adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new Best_Karigar_adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                fr = new From_customer_order_page2();
                //   args = new Bundle();
                //    Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                //  args.putString("CID", phone_no.get(position));

                //      fr.setArguments(args);
                mFragmentTransaction.replace(R.id.Placeholder_from_customer_order, fr);
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
