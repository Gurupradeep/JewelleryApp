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
public class From_customer_place_layout extends Fragment {


    public From_customer_place_layout() {
        // Required empty public constructor
    }
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_from_customer_place_layout, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder_from_customer_order, new From_customers_order_page());
        mFragmentTransaction.commit();
        return v;
    }

}
