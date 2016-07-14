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

import com.example.gurupradeep.jewelery_app.Fragments.Dispatched_orders;


/**
 * A simple {@link Fragment} subclass.
 */
public class Processing_Orders_tab extends Fragment {


    public Processing_Orders_tab() {
        // Required empty public constructor
    }
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_processing__orders_tab, container, false);

        tabLayout = (TabLayout) v.findViewById(R.id.processing_orders_tab_layout);
        viewPager = (ViewPager) v.findViewById(R.id.processing_orders_viewpager);

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
                    return new Dispatched_orders();
                case 1:
                    return new To_be_delivered_orders();

            }
            return null;
        }

        public int getCount() {

            return int_items;

        }

        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Dispathced";
                case 1:
                    return "To BE DELIVERED";

            }
            return null;
        }
    }

}
