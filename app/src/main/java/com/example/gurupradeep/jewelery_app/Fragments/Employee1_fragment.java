package com.example.gurupradeep.jewelery_app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gurupradeep.jewelery_app.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Employee1_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Employee1_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Employee1_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    PieChart pieChart;
    ArrayList<Entry> entries;
    PieDataSet dataset;
    ArrayList<String> labels;
    PieData data;

    private OnFragmentInteractionListener mListener;

    public Employee1_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Employee1_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Employee1_fragment newInstance(String param1, String param2) {
        Employee1_fragment fragment = new Employee1_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_employee1_fragment, container, false);
        pieChart = (PieChart)v.findViewById(R.id.chart);
// creating data values
        entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(12f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));
        dataset = new PieDataSet(entries, "# of Calls");
        labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        data = new PieData(labels, dataset); // initialize Piedata
        pieChart.setData(data); //set data into chart
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        //Skills Chart
        HorizontalBarChart barChart = (HorizontalBarChart)v.findViewById(R.id.chart2);
        ArrayList<BarEntry> entries1 = new ArrayList<>();
        entries1.add(new BarEntry(4f, 0));
        entries1.add(new BarEntry(8f, 1));
        entries1.add(new BarEntry(6f, 2));
        entries1.add(new BarEntry(12f, 3));
        entries1.add(new BarEntry(18f, 4));
        entries1.add(new BarEntry(9f, 5));
        BarDataSet dataset = new BarDataSet(entries1, "# of Calls");
        ArrayList<String> labels1= new ArrayList<String>();
        labels1.add("January");
        labels1.add("February");
        labels1.add("March");
        labels1.add("April");
        labels1.add("May");
        labels1.add("June");
        BarData data = new BarData(labels, dataset);
        barChart.setData(data);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
