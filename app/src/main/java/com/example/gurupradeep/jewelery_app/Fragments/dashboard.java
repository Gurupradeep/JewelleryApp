package com.example.gurupradeep.jewelery_app.Fragments;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gurupradeep.jewelery_app.Tabs.Loyality_Tab;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Tabs.Report;
import com.example.gurupradeep.jewelery_app.Tabs.Chit_funds_tab;

/**
 * A simple {@link Fragment} subclass.
 */
public class dashboard extends Fragment {
    public dashboard() {
        // Required empty public constructor
    }
    Button order_button ;
    Button report_button;
    Button gumasta_button;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Button loyality_button;
    Button support;
    Button chitfunds_button;
    private static final float BITMAP_SCALE = 0.2f;
    private static final float BLUR_RADIUS = 9.5f;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_dashboard, container, false);
        order_button = (Button)v.findViewById(R.id.orders);
        mFragmentManager = getActivity().getSupportFragmentManager();
        order_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Dashboard_layout,new Orders());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

            }
        });
        report_button = (Button)v.findViewById(R.id.reports);
        mFragmentManager = getActivity().getSupportFragmentManager();
        report_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Dashboard_layout, new Report());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

            }
        });

//        report_button.setBackground(new BitmapDrawable(getResources(),
//                blur(getContext(), BitmapFactory.decodeResource(getResources(), R.drawable.rowingrategraph))));

        gumasta_button = (Button)v.findViewById(R.id.gumasta);
        mFragmentManager = getActivity().getSupportFragmentManager();
        gumasta_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Dashboard_layout, new Gumasta_final());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

            }
        });
        support = (Button)v.findViewById(R.id.support);
        mFragmentManager = getActivity().getSupportFragmentManager();
        support.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Dashboard_layout, new ChatBubbleActivity());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

            }
        });
        loyality_button = (Button)v.findViewById(R.id.loyality);
        mFragmentManager = getActivity().getSupportFragmentManager();
        loyality_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Dashboard_layout, new Loyality_Tab());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

            }
        });
        chitfunds_button= (Button)v.findViewById(R.id.chit_funds);
        mFragmentManager = getActivity().getSupportFragmentManager();
        chitfunds_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.Dashboard_layout, new Chit_funds_tab());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();

            }
        });
        return v;
    }

    public static Bitmap blur(Context context, Bitmap image) {
        int width = Math.round(image.getWidth() * BITMAP_SCALE);
        int height = Math.round(image.getHeight() * BITMAP_SCALE);

        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, height, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }
}
