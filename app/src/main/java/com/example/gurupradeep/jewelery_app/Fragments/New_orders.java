package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gurupradeep.jewelery_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class New_orders extends Fragment {


    public New_orders() {
        // Required empty public constructor
    }
    Button button1;
    Button button2;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;
    int ans =1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_new_orders, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder1, new From_customer());
        mFragmentTransaction.commit();
        button1 = (Button)v.findViewById(R.id.request_order_button);
        mFragmentManager = getActivity().getSupportFragmentManager();

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ans == 1) {
                    mtempFragmentTransaction = mFragmentManager.beginTransaction();
                    mtempFragmentTransaction.replace(R.id.from_customer_layout, new Order_requested());
                    mtempFragmentTransaction.commit();
                    ans =0;
                }
            }
        });
        button2 = (Button)v.findViewById(R.id.From_customer_button);
        mFragmentManager = getActivity().getSupportFragmentManager();
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ans==0) {
                    mtempFragmentTransaction = mFragmentManager.beginTransaction();
                    mtempFragmentTransaction.replace(R.id.Order_requested_layout, new From_customer());
                    mtempFragmentTransaction.commit();
                    ans =1;
                }
            }
        });




        return v;
    }

}
