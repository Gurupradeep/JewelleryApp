package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Adapters.Chit_funds_partof_adapter;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.chit_fund_part_of_constructor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chit_funds_partof extends Fragment {


    public Chit_funds_partof() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    ArrayList<chit_fund_part_of_constructor> temp;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Bundle args;
    Fragment fr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chit_funds_partof, container, false);
        r = (RecyclerView)v.findViewById(R.id.chit_funds_partof_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        temp = new ArrayList<>();
        temp.add(new chit_fund_part_of_constructor("10 ppl","25,000","Pretam","17th July","25,000","10 chits done"));
        adapter = new Chit_funds_partof_adapter(getContext(),temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new Chit_funds_partof_adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new Chit_funds_partof_adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                /*mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                fr =  new Chit_funds_managing_chit1();
                args = new Bundle();
                //    Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                args.putString("CID",name.get(position));
                fr.setArguments(args);
                mFragmentTransaction.replace(R.id.chit_funds_managing_layout,fr);
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();*/
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));




        return v;
    }



}
