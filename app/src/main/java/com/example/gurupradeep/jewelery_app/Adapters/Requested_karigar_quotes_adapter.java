package com.example.gurupradeep.jewelery_app.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.Requested_Karigar_quotes;

import java.util.List;

/**
 * Created by Guru Pradeep on 13-07-2016.
 */
public class Requested_karigar_quotes_adapter extends RecyclerView.Adapter<Requested_karigar_quotes_adapter.PersonViewHolder> {
    List<Requested_Karigar_quotes> people;
    private static Context mcontext;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView commission;
        TextView date;
        TextView info;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.requested_quotes_cv);
            name = (TextView) itemView.findViewById(R.id.requested_karigar_name);
            commission = (TextView) itemView.findViewById(R.id.requested_karigar_commission);
            date =  (TextView) itemView.findViewById(R.id.Requested_Karigar_delivery_date);
            info = (TextView) itemView.findViewById(R.id.Requested_Karigar_Additional_info);

        }
    }

    public Requested_karigar_quotes_adapter(Context context, List<Requested_Karigar_quotes> people) {
        mcontext = context;
        this.people = people;
    }

    public int getItemCount() {
        return people.size();
    }

    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.requested_order_quotes_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.name.setText(people.get(i).Name);
        personViewHolder.commission.setText(people.get(i).Commission_rate);
        personViewHolder.date.setText(people.get(i).Delivery_date);
        personViewHolder.info.setText(people.get(i).Additional_info);
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
        private Requested_karigar_quotes_adapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Requested_karigar_quotes_adapter.ClickListener clickListener) {
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