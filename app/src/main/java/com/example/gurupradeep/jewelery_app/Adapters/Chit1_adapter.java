package com.example.gurupradeep.jewelery_app.Adapters;

/**
 * Created by Guru Pradeep on 11-06-2016.
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

import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.chit_class;

import java.util.List;

/**
 * Created by Guru Pradeep on 11-06-2016.
 */
public class Chit1_adapter extends RecyclerView.Adapter<Chit1_adapter.PersonViewHolder> {
    List<chit_class> Chits;
    private static Context mcontext;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;

        TextView Due_amount;
        TextView name;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.chit1_cv);
            name= (TextView) itemView.findViewById(R.id.chit1_person_name);
            Due_amount= (TextView) itemView.findViewById(R.id.chit1_due);


        }
    }

    public Chit1_adapter(Context context, List<chit_class> Chits) {
        mcontext = context;
        this.Chits = Chits;
    }

    public int getItemCount() {
        return Chits.size();
    }

    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chit1_due_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.Due_amount.setText(Chits.get(i).due_amount);
        personViewHolder.name.setText(Chits.get(i).name);

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
        private Chit1_adapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Chit1_adapter.ClickListener clickListener) {
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
