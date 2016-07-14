package com.example.gurupradeep.jewelery_app.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.Adapters.Requested_karigar_quotes_adapter;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.Requested_Karigar_quotes;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class Requested_order_page1 extends Fragment {


    public Requested_order_page1() {
        // Required empty public constructor
    }
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
    ArrayList<Requested_Karigar_quotes> temp;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_requested_order_page1, container, false);
        r = (RecyclerView)v.findViewById(R.id.requested_order_quotes_rc);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);

        temp = new ArrayList<>();
        temp.add(new Requested_Karigar_quotes("Preetam","18%","17th August","Nothing"));
        temp.add(new Requested_Karigar_quotes("Shankar","18%","17th August","Nothing"));
        temp.add(new Requested_Karigar_quotes("Sandeep","18%","17th August","Nothing"));
        adapter = new Requested_karigar_quotes_adapter(getContext(), temp);
        r.setAdapter(adapter);
        mFragmentManager = getActivity().getSupportFragmentManager();
        r.addOnItemTouchListener(new Requested_karigar_quotes_adapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new Requested_karigar_quotes_adapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Placeholder_requested_order, new Requested_Order_page2());
                mFragmentTransaction.commit();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return v;
    }

}
