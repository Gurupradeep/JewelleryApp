package com.example.gurupradeep.jewelery_app;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


/**
 * A simple {@link Fragment} subclass.
 */
public class Scheme1_details extends Fragment {


    public Scheme1_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_scheme1_details, container, false);
        GraphView graph = (GraphView)v.findViewById(R.id.scheme_graph1);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
     //   graph.setTitle("Bar graph");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("CUSTOMERS");
        graph.getGridLabelRenderer().setVerticalAxisTitle("ORNAMENTS");
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);

       // series.setSpacing(50);
      //  series.setDrawValuesOnTop(true);
      //  series.setValuesOnTopColor(Color.RED);
        graph.setClickable(true);







        return v;
    }

}
