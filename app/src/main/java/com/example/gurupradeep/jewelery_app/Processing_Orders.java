package com.example.gurupradeep.jewelery_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Processing_Orders extends Fragment {


    public Processing_Orders() {
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
        View v=inflater.inflate(R.layout.fragment_processing__orders, container, false);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder2, new Dispatched_orders());
        mFragmentTransaction.commit();
        button2 = (Button)v.findViewById(R.id.to_be_delievered_button);
        mFragmentManager = getActivity().getSupportFragmentManager();
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mtempFragmentTransaction = mFragmentManager.beginTransaction();
                mtempFragmentTransaction.replace(R.id.dispatched_orders_layout, new To_be_delivered_orders());
                mtempFragmentTransaction.addToBackStack(null);
                mtempFragmentTransaction.commit();

            }
        });
        return v;
    }

}
