package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dispatched_order_place_layout extends Fragment {


    public Dispatched_order_place_layout() {
        // Required empty public constructor
    }
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dispatched_order_place_layout, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder_from_dispatched_order, new Dispatched_orders_page1());
        mFragmentTransaction.commit();
        return v;
    }

}
