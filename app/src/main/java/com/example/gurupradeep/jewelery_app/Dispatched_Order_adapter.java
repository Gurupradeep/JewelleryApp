package com.example.gurupradeep.jewelery_app;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Guru Pradeep on 07-06-2016.
 */
public class Dispatched_Order_adapter extends RecyclerView.Adapter<Dispatched_Order_adapter.PersonViewHolder> {
    List<Dispatched_Orders_class>Customer ;
    private static Context mcontext;
    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Customername;
        TextView Customer_items;
        TextView Customer_advance;
        TextView Customer_delivery_date;
        TextView percentage_completed;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.dispatched_order_cv);
            Customername= (TextView)itemView.findViewById(R.id.dispatched_order_name);
            Customer_items= (TextView)itemView.findViewById(R.id.dispatched_order_items);
            Customer_advance= (TextView)itemView.findViewById(R.id.dispatched_order_advance);
            Customer_delivery_date= (TextView)itemView.findViewById(R.id.dispatched_order_delivery);
            percentage_completed = (TextView)itemView.findViewById(R.id.dispatched_order_percentage);

        }
    }
    public Dispatched_Order_adapter(Context context, List<Dispatched_Orders_class>Customer)
    {
        mcontext = context;
        this.Customer = Customer;
    }
    public int getItemCount() {
        return  Customer.size();
    }
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.disatched_order_card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.Customername.setText(Customer.get(i).name);
        personViewHolder.Customer_items.setText(Customer.get(i).items);
        personViewHolder.Customer_advance.setText(Customer.get(i).advance);
        personViewHolder.Customer_delivery_date.setText(Customer.get(i).delivery);
        personViewHolder.percentage_completed.setText(Customer.get(i).percentage);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);
    }

}
