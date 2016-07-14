package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Fragments.Monthly_details1;
import com.example.gurupradeep.jewelery_app.Fragments.Monthly_report;
import com.example.gurupradeep.jewelery_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Report_monthly extends Fragment {


    public Report_monthly() {
        // Required empty public constructor
    }
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_report_monthly, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder4, new Monthly_details1());
        mFragmentTransaction.commit();
        FragmentTransaction mtempFragmentTransaction = getFragmentManager().beginTransaction();
        mtempFragmentTransaction.replace(R.id.Placeholder3, new Monthly_report());
        mtempFragmentTransaction.commit();
        return v;
    }

}
