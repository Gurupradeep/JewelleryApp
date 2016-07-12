package com.example.gurupradeep.jewelery_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.Databases.Loyality;


public class Loyality_Tab extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;
    Login_database_handler login_database_handler;
    String query;
    SQLiteDatabase db;
    public Loyality_Tab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_loyality__tab, container, false);
        tabLayout = (TabLayout) v.findViewById(R.id.loyality_tabs);
        viewPager = (ViewPager) v.findViewById(R.id.loyality_viewpager);

        //Adding data into Loyality_Table
         login_database_handler = new Login_database_handler(getContext(),null,null,5);
        login_database_handler.add_scheme(new Loyality("Scheme1","40","10,000","45"));
       login_database_handler.add_scheme(new Loyality("Scheme1","40","10,000","45"));
   //     login_database_handler.add_scheme(new Loyality("Scheme1","40","10,000","45"));
   //     login_database_handler.add_scheme(new Loyality("Scheme1","40","10,000","45"));
    //    login_database_handler.add_scheme(new Loyality("Scheme1","40","10,000","45"));
       db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_LOYALITY;
        Cursor cursor = db.rawQuery(query,null);
        query = Integer.toString(cursor.getCount());
        Toast.makeText(getActivity(), query, Toast.LENGTH_SHORT).show();

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });


        return v;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Loyality_customers();
                case 1:
                    return new Loyality_Ornaments();
                case 2:
                    return new Loyality_profit();
            }
            return null;
        }

        public int getCount() {

            return int_items;

        }

        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Customers";
                case 1:
                    return "Ornaments";
                case 2:
                    return "Profit";
            }
            return null;
        }
    }
}
