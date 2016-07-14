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
import com.example.gurupradeep.jewelery_app.Simple_Constructors.chit_fund_part_of_constructor;

import java.util.List;

/**
 * Created by Guru Pradeep on 14-07-2016.
 */
public class Chit_funds_partof_adapter extends RecyclerView.Adapter<Chit_funds_partof_adapter.PersonViewHolder> {
    List<chit_fund_part_of_constructor> Chits;
    private static Context mcontext;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Chit_members;
        TextView Due_amount;
        TextView name;
        TextView start;
        TextView amount_pooled;
        TextView no_of_chits;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.chit_funds_partof_cv);
            Chit_members = (TextView) itemView.findViewById(R.id.chit_funds_part_of_ppl);
            Due_amount = (TextView) itemView.findViewById(R.id.chit_funds_part_of_due);
            name= (TextView) itemView.findViewById(R.id.chit_fund_part_of_name);
            start = (TextView) itemView.findViewById(R.id.chit_funds_part_of_start_date);
            amount_pooled = (TextView) itemView.findViewById(R.id.chit_funds_part_of_pooled);
            no_of_chits= (TextView) itemView.findViewById(R.id.chit_funds_partof_no_of_chits_done);




        }
    }

    public Chit_funds_partof_adapter(Context context, List<chit_fund_part_of_constructor> Chits) {
        mcontext = context;
        this.Chits = Chits;
    }

    public int getItemCount() {
        return Chits.size();
    }

    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chit_fund_partof_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.Chit_members.setText(Chits.get(i).no_of_ppl);
        personViewHolder.Due_amount.setText(Chits.get(i).due_amount);
        personViewHolder.name.setText(Chits.get(i).name);
        personViewHolder.start.setText(Chits.get(i).date);
        personViewHolder.amount_pooled.setText(Chits.get(i).pooled_amount);
        personViewHolder.no_of_chits.setText(Chits.get(i).no_of_chits_done);

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
        private Chit_funds_partof_adapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Chit_funds_partof_adapter.ClickListener clickListener) {
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
