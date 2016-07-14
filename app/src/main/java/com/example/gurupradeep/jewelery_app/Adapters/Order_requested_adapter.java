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
import com.example.gurupradeep.jewelery_app.Simple_Constructors.Requested_order;

import java.util.List;

/**
 * Created by Guru Pradeep on 05-06-2016.
 */
public class Order_requested_adapter extends RecyclerView.Adapter<Order_requested_adapter.PersonViewHolder> {
    List<Requested_order> Customer;
    private static Context mcontext;
    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Customername;
        TextView Customer_items;
        TextView Customer_advance;
        TextView Customer_delivery_date;
        TextView quotes;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.order_requested_cv);
            Customername= (TextView)itemView.findViewById(R.id.order_requested_name);
            Customer_items= (TextView)itemView.findViewById(R.id.order_requested_items);
            Customer_advance= (TextView)itemView.findViewById(R.id.order_requested_advance);
            Customer_delivery_date= (TextView)itemView.findViewById(R.id.order_requested_delivery);
            quotes = (TextView)itemView.findViewById(R.id.order_requested_quotes);

        }
    }
    public Order_requested_adapter(Context context, List<Requested_order>Customer)
    {
        mcontext = context;
        this.Customer = Customer;
    }
    public int getItemCount() {
        return  Customer.size();
    }
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_requested_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.Customername.setText(Customer.get(i).name);
        personViewHolder.Customer_items.setText(Customer.get(i).items);
        personViewHolder.Customer_advance.setText(Customer.get(i).Advance_paid);
        personViewHolder.Customer_delivery_date.setText(Customer.get(i).delivery);
        personViewHolder.quotes.setText(Customer.get(i).quotes);
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
        private Order_requested_adapter.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Order_requested_adapter.ClickListener clickListener) {
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
