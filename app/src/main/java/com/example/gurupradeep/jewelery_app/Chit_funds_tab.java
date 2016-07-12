package com.example.gurupradeep.jewelery_app;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.Databases.chit_fund;
import com.example.gurupradeep.jewelery_app.Databases.chit_fund_due;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chit_funds_tab extends Fragment {


    public Chit_funds_tab() {
        // Required empty public constructor
    }
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;
    Login_database_handler login_database_handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_chit_funds_tab, container, false);
        tabLayout = (TabLayout) v.findViewById(R.id.chitfund_tabs);
        viewPager = (ViewPager) v.findViewById(R.id.chitfund_viewpager);
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        login_database_handler.add_due_chit_fund(new chit_fund_due("Temporary_chit1","Guru","10,100"));
        login_database_handler.add_due_chit_fund(new chit_fund_due("Temporary_chit1","Pradeep","10,100"));
        login_database_handler.add_due_chit_fund(new chit_fund_due("Temporary_chit1","Guru","10,100"));
        login_database_handler.add_due_chit_fund(new chit_fund_due("Temporary_chit1","Guru","10,100"));
        login_database_handler.add_due_chit_fund(new chit_fund_due("Temporary_chit2","Guru","10,100"));
        login_database_handler.add_due_chit_fund(new chit_fund_due("Temporary_chit2","pradeep","10,100"));
        // ADDING FEW CHITS
        login_database_handler.add_chit(new chit_fund("Temporary_chit1","17th July 2016","200000","12","15","9","100000"));
        login_database_handler.add_chit(new chit_fund("Temporary_chit2","18th July 2016","200000","12","15","9","100000"));
        login_database_handler.add_chit(new chit_fund("Temporary_chit3","19th July 2016","200000","12","15","9","100000"));


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
                    return new Chit_funds_managing();
                case 1:
                    return new Loyality_Ornaments();
            }
            return null;
        }

        public int getCount() {

            return int_items;

        }

        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Managing";
                case 1:
                    return "Part Of";

            }
            return null;
        }
    }
}
