package com.example.gurupradeep.jewelery_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Report_Weekly extends Fragment {


    public Report_Weekly() {
        // Required empty public constructor
    }
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_report__weekly, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder_weekly1, new Weekly_details());
        mFragmentTransaction.commit();
        FragmentTransaction mtempFragmentTransaction = getFragmentManager().beginTransaction();
        mtempFragmentTransaction.replace(R.id.Placeholder_weekly2, new Weekly_report());
        mtempFragmentTransaction.commit();
        return v;
    }

}
