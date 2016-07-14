package com.example.gurupradeep.jewelery_app.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Adapters.EmployeeAdapter;
import com.example.gurupradeep.jewelery_app.Databases.Employee_Type;
import com.example.gurupradeep.jewelery_app.Databases.Employee_attendance;
import com.example.gurupradeep.jewelery_app.Databases.Employee_db;
import com.example.gurupradeep.jewelery_app.Databases.Employee_skill;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;
import com.example.gurupradeep.jewelery_app.Fragments.Emplyoee2;
import com.example.gurupradeep.jewelery_app.R;
import com.example.gurupradeep.jewelery_app.Simple_Constructors.Employee;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Recycler_employee extends Fragment {


    public Recycler_employee() {
        // Required empty public constructor
    }
   // RecyclerView r;
    //LinearLayoutManager llm;
   // Adapter adapter;
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager llm;
//    Employee_list temp;
      ArrayList<Employee>temp;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    SQLiteDatabase db;
    Login_database_handler login_database_handler;
    List<String> name;
    List<String> salary;
    List<String> Experience;
    List<String> phone_no;
    String query;
    Fragment fr;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_recycler_employee, container, false);
        r = (RecyclerView)v.findViewById(R.id.recycler_view);
        r.setHasFixedSize(true);
        llm = new LinearLayoutManager(getContext());
        r.setLayoutManager(llm);
        //Adding Few Temporary names to Database
        login_database_handler = new Login_database_handler(getContext(),null,null,8);
        login_database_handler.add_employee(new Employee_db("Guru Pradeep", "Miyapur, Hyderabad", "9951131799", "14 months", "10,000", "28-AUG-2015"));
        login_database_handler.add_employee(new Employee_db("Guru Pradeep", "Miyapur, Hyderabad", "8123289195", "14 months", "10,000", "28-AUG-2015"));

        //Adding Few Details about Employee
        login_database_handler.add_employee_skill(new Employee_skill("9951131799", "10", "12", "5", "3", "5"));
        login_database_handler.add_employee_type(new Employee_Type("9951131799", "5", "6", "7"));
        login_database_handler.add_employee_attendance(new Employee_attendance("9951131799","13","15","16","19","23","26","21","26","23","21","22","23"));
        //Getting data from the database]
        db = login_database_handler.getWritableDatabase();
        query = "SELECT * FROM "+ login_database_handler.TABLE_EMPLOYEE;
        Cursor cursor = db.rawQuery(query,null);
        query = Integer.toString(cursor.getCount());
        Toast.makeText(getActivity(), query, Toast.LENGTH_SHORT).show();
        name = new ArrayList<>();
        salary = new ArrayList<>();
        Experience = new ArrayList<>();
        phone_no = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                name.add(cursor.getString(1));
                salary.add(cursor.getString(2));
                phone_no.add(cursor.getString(3));
                Experience.add(cursor.getString(5));
            } while (cursor.moveToNext());
        }
   //     temp = new Employee_list();
        temp = new ArrayList<Employee>();
        for(int i=0;i<name.size();i++)
        {
            temp.add(new Employee(name.get(i),salary.get(i),Experience.get(i)));
        }
        adapter = new EmployeeAdapter(getContext(), temp);
        r.setAdapter(adapter);
        r.addOnItemTouchListener(new EmployeeAdapter.RecyclerTouchListener(getActivity().getApplicationContext(), r, new EmployeeAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mFragmentManager = getFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                fr =  new Emplyoee2();
                args = new Bundle();
                //    Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                args.putString("CID", phone_no.get(position));
                fr.setArguments(args);
                mFragmentTransaction.replace(R.id.Placeholder13, fr);
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return v;

    }


}
