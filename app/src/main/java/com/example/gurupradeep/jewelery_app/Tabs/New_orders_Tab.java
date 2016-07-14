package com.example.gurupradeep.jewelery_app.Tabs;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Fragments.From_customer;
import com.example.gurupradeep.jewelery_app.Fragments.Order_requested;
import com.example.gurupradeep.jewelery_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class New_orders_Tab extends Fragment {


    public New_orders_Tab() {
        // Required empty public constructor
    }
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_new_orders__tab, container, false);
        tabLayout = (TabLayout) v.findViewById(R.id.new_orders_tab_layout);
        viewPager = (ViewPager) v.findViewById(R.id.new_orders_viewpager);

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
                    return new From_customer();
                case 1:
                    return new Order_requested();

            }
            return null;
        }

        public int getCount() {

            return int_items;

        }

        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "FROM CUSTOMER";
                case 1:
                    return "REQUESTED";

            }
            return null;
        }
    }
}



