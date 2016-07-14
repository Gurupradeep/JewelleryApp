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

import com.example.gurupradeep.jewelery_app.Adapters.Chit_funds_managing_adapter;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.Chit_funds_managing_class;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chit_funds_managing extends Fragment {


    public Chit_funds_managing() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    public ArrayList<Chit_funds_managing_class> temp;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Bundle args;
    Fragment fr;
    Login_database_handler login_database_handler;
    Cursor cursor;
    SQLiteDatabase db;
    String query;
    List<String>name;
    List<String>date;
    List<Integer>amount;
    List<Integer>no_of_chits_done;
    List<Integer>no_of_ppl_due;
    List<Integer>no_of_ppl;
    List<Integer>due_amount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chit_funds_managing, container, false);

        r = (RecyclerView)v.findViewById(R.id.chit_funds_managing_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        //     temp = new Employee_list();
        //RETREIVING DATA FROM DATABASE
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM " + login_database_handler.TABLE_CHIT_FUNDS;
        cursor = db.rawQuery(query,null);
        name = new ArrayList<>();
        date = new ArrayList<>();
        amount = new ArrayList<>();
        no_of_chits_done = new ArrayList<>();
        no_of_ppl = new ArrayList<>();
        no_of_ppl_due = new ArrayList<>();
        due_amount = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                name.add(cursor.getString(1));
                date.add((cursor.getString(2)));
                amount.add(Integer.parseInt(cursor.getString(3)));
                no_of_chits_done.add(Integer.parseInt(cursor.getString(4)));
                no_of_ppl.add(Integer.parseInt(cursor.getString(5)));
                no_of_ppl_due.add(Integer.parseInt(cursor.getString(6)));
       //         due_amount.add(Integer.parseInt(cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        temp = new ArrayList<Chit_funds_managing_class>();
        for(int i=0;i<name.size();i++)
        {
            temp.add(new Chit_funds_managing_class(Integer.toString(no_of_ppl_due.get(i))+"/"+Integer.toString(no_of_ppl.get(i)),"Rs "+"10000",name.get(i),date.get(i),"Rs "+amount.get(i)+" (Pooled)",no_of_chits_done.get(i)+" chits done"));
        }
   //     temp.add(new Chit_funds_managing_class("9/10","Rs 2,50,000/-"," Temporary chit","17th May 2016","Rs 2,50,000/-(Pooled)","12 Chits done"));
    //    temp.add(new Chit_funds_managing_class("9/10","Rs 2,50,000/-"," Temporary chit","17th May 2016","Rs 2,50,000/-(Pooled)","12 Chits done"));
    //    temp.add(new Chit_funds_managing_class("9/10","Rs 2,50,000/-"," Temporary chit","17th May 2016","Rs 2,50,000/-(Pooled)","12 Chits done"));
    //    temp.add(new Chit_funds_managing_class("9/10","Rs 2,50,000/-"," Temporary chit","17th May 2016","Rs 2,50,000/-(Pooled)","12 Chits done"));
    //    temp.add(new Chit_funds_managing_class("9/10","Rs 2,50,000/-"," Temporary chit","17th May 2016","Rs 2,50,000/-(Pooled)","12 Chits done"));
    //    temp.add(new Chit_funds_managing_class("9/10","Rs 2,50,000/-"," Temporary chit","17th May 2016","Rs 2,50,000/-(Pooled)","12 Chits done"));

        adapter = new Chit_funds_managing_adapter(getContext(),temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new Chit_funds_managing_adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new Chit_funds_managing_adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                fr =  new Chit_funds_managing_chit1();
                args = new Bundle();
            //    Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                args.putString("CID",name.get(position));
                fr.setArguments(args);
                mFragmentTransaction.replace(R.id.chit_funds_managing_layout,fr);
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
