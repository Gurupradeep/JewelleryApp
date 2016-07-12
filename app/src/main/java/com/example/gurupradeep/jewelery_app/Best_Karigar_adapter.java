package com.example.gurupradeep.jewelery_app;

/**
 * Created by Guru Pradeep on 12-06-2016.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gurupradeep.jewelery_app.Karigar;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.loyality_scheme;

import java.util.List;

/**
 * Created by Guru Pradeep on 11-06-2016.
 */
public class Best_Karigar_adapter extends RecyclerView.Adapter<Best_Karigar_adapter.PersonViewHolder> {
    List<Karigar> people;
    private static Context mcontext;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView rating;
        TextView area;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.karigar_cv);
            name = (TextView) itemView.findViewById(R.id.karigar_name);
            rating = (TextView) itemView.findViewById(R.id.karigar_rating);
            area =  (TextView) itemView.findViewById(R.id.karigar_specialized_area);

        }
    }

    public Best_Karigar_adapter(Context context, List<Karigar> people) {
        mcontext = context;
        this.people = people;
    }

    public int getItemCount() {
        return people.size();
    }

    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.karigar_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.name.setText(people.get(i).name);
        personViewHolder.rating.setText(people.get(i).rating);
        personViewHolder.area.setText(people.get(i).Specialized_area);

    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private Best_Karigar_adapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Best_Karigar_adapter.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {

                    //   Intent intent = new Intent(mContext, ShopPageActivity.class);

                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

    }
}