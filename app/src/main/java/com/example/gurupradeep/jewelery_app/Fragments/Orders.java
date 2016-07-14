package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gurupradeep.jewelery_app.Databases.*;
import com.example.gurupradeep.jewelery_app.Databases.Karigar;
import com.example.gurupradeep.jewelery_app.Tabs.Processing_Orders_tab;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Tabs.New_orders_Tab;


/**
 * A simple {@link Fragment} subclass.
 */
public class Orders extends Fragment {


    Button button1;
    Button button2;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FragmentTransaction mtempFragmentTransaction;
    Login_database_handler login_database_handler;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        int ans = 1;
        View x = inflater.inflate(R.layout.fragment_orders, null);
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.Placeholder, new Orders_default());
        mFragmentTransaction.commit();
        //Adding few Orders
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        login_database_handler.add_new_order(new New_Order("Guru Pradeep", "Bangles", "27th july", "17000", "14000"));
        login_database_handler.add_new_order(new New_Order("Guru Pradeep","Bangles","27th july","17000","14000"));
        login_database_handler.add_new_order(new New_Order("Guru Pradeep","Bangles","27th july","17000","14000"));
        login_database_handler.add_requested_order(new Requested_Order("Pradeep", "Rings", "28th July", "10", "8", "21000", "10000"));
        login_database_handler.add_requested_order(new Requested_Order("Pradeep", "Rings", "28th July", "10", "8", "21000", "10000"));
        login_database_handler.add_requested_order(new Requested_Order("Pradeep","Rings","28th July","10","8","21000","10000"));
        login_database_handler.add_requested_order(new Requested_Order("Pradeep","Rings","28th July","10","8","21000","10000"));
        login_database_handler.add_dispatched_order(new Dispatched_Order_db("preetam", "Rings", "28th July", "90%", "17000", "14000"));
        login_database_handler.add_dispatched_order(new Dispatched_Order_db("preetam", "Rings", "28th July", "90%", "17000", "14000"));
        login_database_handler.add_dispatched_order(new Dispatched_Order_db("preetam","Rings","28th July","90%","17000","14000"));
        login_database_handler.add_to_be_delivered_order(new To_be_delivered_db("Preetam", "Bangles", "80%", "10000", "8000"));
        login_database_handler.add_to_be_delivered_order(new To_be_delivered_db("Preetam", "Bangles", "80%", "10000", "8000"));
        login_database_handler.add_to_be_delivered_order(new To_be_delivered_db("Preetam","Bangles","80%","10000","8000"));
        login_database_handler.add_karigar(new Karigar("Guru", "9", "Rings", "9951131799", "Miyapur,Hyderabad"));
        login_database_handler.add_karigar(new Karigar("Guru","9","Rings","9951131797","Miyapur,Hyderabad"));
        login_database_handler.add_karigar(new Karigar("Guru","9","Rings","9951131798","Miyapur,Hyderabad"));


        button1 = (Button)x.findViewById(R.id.fc_button);
        mFragmentManager = getActivity().getSupportFragmentManager();
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mtempFragmentTransaction = mFragmentManager.beginTransaction();
                mtempFragmentTransaction.replace(R.id.Placeholder, new New_orders_Tab());
                mtempFragmentTransaction.commit();

            }
        });

        button2 = (Button)x.findViewById(R.id.processing_button);
        mFragmentManager = getActivity().getSupportFragmentManager();
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mtempFragmentTransaction = mFragmentManager.beginTransaction();
                mtempFragmentTransaction.replace(R.id.Placeholder, new Processing_Orders_tab());
                mtempFragmentTransaction.commit();

            }
        });

        return x;

        /**
         * This method returns the title of the tab according to the position.
         */

    }

}

