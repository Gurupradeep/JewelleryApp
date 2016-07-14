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
import com.example.gurupradeep.jewelery_app.loyality_scheme;

import java.util.List;

/**
 * Created by Guru Pradeep on 09-06-2016.
 */
public class Loyality_Ornaments_adapter extends RecyclerView.Adapter<Loyality_Ornaments_adapter.PersonViewHolder> {
    List<loyality_scheme> Schemes;
    private static Context mcontext;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Scheme_name;
        TextView number;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.Schemes_Ornaments_cv);
            Scheme_name = (TextView) itemView.findViewById(R.id.ornament_scheme_name);
            number = (TextView) itemView.findViewById(R.id.scheme_no_of_ornaments);


        }
    }

    public Loyality_Ornaments_adapter(Context context, List<loyality_scheme> Schemes) {
        mcontext = context;
        this.Schemes = Schemes;
    }

    public int getItemCount() {
        return Schemes.size();
    }

    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.scheme_ornaments_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.Scheme_name.setText(Schemes.get(i).scheme_name);
        personViewHolder.number.setText(Schemes.get(i).number);
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
        private Loyality_Ornaments_adapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Loyality_Ornaments_adapter.ClickListener clickListener) {
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
