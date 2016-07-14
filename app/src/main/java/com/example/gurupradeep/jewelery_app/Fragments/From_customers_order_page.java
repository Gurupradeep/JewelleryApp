package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gurupradeep.jewelery_app.Fragments.Best_Karigar;
import com.example.gurupradeep.jewelery_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class From_customers_order_page extends Fragment {


    public From_customers_order_page() {
        // Required empty public constructor
    }
    Button button1;
    Button button2;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_from_customers_order_page, container, false);
        button1 = (Button)v.findViewById(R.id.from_customer_order_send_button);
        mFragmentManager = getActivity().getSupportFragmentManager();
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mtempFragmentTransaction = mFragmentManager.beginTransaction();
                mtempFragmentTransaction.replace(R.id.Placeholder_from_customer_order, new Best_Karigar());
                mtempFragmentTransaction.commit();

            }
        });
        return v;
    }

}
