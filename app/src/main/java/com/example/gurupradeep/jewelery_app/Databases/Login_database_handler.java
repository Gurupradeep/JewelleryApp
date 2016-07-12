package com.example.gurupradeep.jewelery_app.Databases;

import android.content.ContentValues;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.SweepGradient;

import com.example.gurupradeep.jewelery_app.*;

/**
 * Created by Guru Pradeep on 14-06-2016.
 */
public class Login_database_handler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =8;
    public static final String DATABASE_NAME = "Owner";
    public static final String TABLE_LOGIN = "login";
    public static final String TABLE_LOYALITY = "loyality";
    public static final String TABLE_EMPLOYEE = "employee";
    public static final String TABLE_ORDER = "orders";
    public static final String TABLE_REQUESTED_ORDER = "requested_order";
    public static final String TABLE_DISPATCHED_ORDER = "dispatched_order";
    public static final String TABLE_TO_BE_DELIVERED = "to_be_delivered_order";
    public static final String TABLE_CHIT_FUNDS = "chit_funds";
    public static final String TABLE_CHIT_FUND_DUE = "chit_fund_due";
    public static final String TABLE_EMPLOYEE_SKILLS = "employee_skills";
    public static final String TABLE_EMPLOYEE_TYPE = "employee_type";
    public static final String TABLE_EMPLOYEE_ATTENDANCE = "employee_attendance";
    public static final String TABLE_KARIGAR = "karigar";
    public static final String TABLE_KARIGAR_SPECIALISATION = "kaigar_specialisation";
    public static final String TABLE_MONTHLY_REVENUE = "monthly_revenue";
    public static final String TABLE_MONTHLY_PROFIT = "monthly_profit";
    public static final String TABLE_WEEKLY_REVENUE = "weekly_revenue";
    public static final String TABLE_WEEKLY_PROFIT = "weekly_profit";
    public static final String TABLE_DAILY_REVENUE = "daily_revenue";
    public static final String TABLE_DAILY_PROFIT = "daily_profit";

    //Columns of login
    public static final String key_id = "id";
    public static final String key_username = "username";
    public static final String key_password = "password";
    //Columns of Loyality
    public static final String key_id_loyality = "loyality_id";
    public static final String key_scheme_name = "scheme_name";
    public static final String key_customers = "scheme_customers";
    public static final String key_profit = " scheme_profit";
    public static final String key_ornaments = "Scheme_Ornaments";
    //Columns of Employee
    public static final String key_id_employee = "employee_id";
    public static final String Key_employee_name = "employee_name";
    public static final String key_employee_salary = "employee_salary";
    public static final String key_employee_phone_no = "employee_phone_no";
    public static final String key_employee_address = "employee_address";
    public static final String key_employeee_experience = "employee_experience";
    public static final String key_employee_joining_date = "employee_joining_date";
    //Columns of Orders
    public static final String key_id_order = "order_id";
    public static final String key_order_name = "person_name";
    public static final String key_order_items = "order_items";
    public static final String key_amount = "amount";
    public static final String key_amount_paid = "amount_paid";
    public static final String key_delivery_date = "delivery_date";
    //Columns of requested Order
    public static final String key_requested_order_id = "requested_order_id";
    public static final String key_requested_person = "requested_person";
    public static final String key_requested_items = "requested_items";
    public static final String key_requested_amount = "requested_amount";
    public static final String key_requested_amount_paid = "requested_amount_paid";
    public static final String key_requested_delivery = "requested_delivery";
    public static final String key_quotes_dispatched = "quotes_dispatched";
    public static final String key_quotes_recieved = "quotes_recieived";

    //Columns for dispatched_order
    public static final String key_dispatched_order_id = "dispatched_order_id";
    public static final String key_dispatched_person = "dispatched_person";
    public static final String key_dispatched_items = "dispatched_items";
    public static final String key_dispatched_amount = "dispatched_amount";
    public static final String key_dispatched_amount_paid = "dispatched_amount_paid";
    public static final String key_dispatched_delivery = "dispatched_delivery";
    public static final String key_dispatched_percentage = "dispatched_percentage";

    //Columns for to be delivered orders
    public static final String key_to_be_delivered_order_id = "to_be_delivered_order_id";
    public static final String key_to_be_delivered_person = "to_be_delivered_person";
    public static final String key_to_be_delivered_items = "to_be_delivered_items";
    public static final String key_to_be_delivered_amount = "to_be_delivered_amount";
    public static final String key_to_be_delivered_amount_paid = "to_be_delivered_amount_paid";
    public static final String key_to_be_delivered_percentage = "to_be_delivered_percentage";


    // Columns of chit fund
    public static final String key_chitid = "chit_id";
    public static final String key_chit_name = "chit_name";
    public static final String key_chit_start_date = "chit_start_date";
    public static final String key_chit_pooled_amount = "chit_pooled_amount";
    public static final String key_no_chits_done = "no_chits_done";
    public static final String key_chit_no_of_people_involved = "chit_no_of_people_involved";
    public static final String key_chit_no_of_people_due = "chit_no_of_people_due";
    public static final String key_chit_due_amount = "chit_due_amount";


    //columns of chit_due
    public static final String key_chit_due_id = "chit_due_id";
    public static final String key_due_chit_name = "due_chit_name";
    public static final String key_due_person = "due_person";
    public static final String key_due_amount = "chit_due_amount_per_person";

    //Columns of Employee_Skills
    public static final String key_employee_skill_id = "employee_skill_id";
    public static final String key_employee_skill_no = "employee_skill_no";
    public static final String key_rings = "rings";
    public static final String key_bangles = "bangles";
    public static final String key_braclets = "braclets";
    public static final String key_necklaces = "necklaces";
    public static final String key_chains = "chains";


    //Columns of Employee_type

    public static final String key_employee_type_id = "employee_type_id";
    public static final String key_employee_type_no = "employee_type_no";
    public static final String key_bargaining = "bargaining";
    public static final String key_trustworthy = "trustworthy";
    public static final String key_rich = "rich";


    //Columns of Employee Attendance

    public static final String key_employee_attendance_id = "employee_attendance_id";
    public static final String key_employee_attendance_no = "employee_attendance_no";
    public static final String key_jan = "jan";
    public static final String key_feb = "feb";
    public static final String key_mar = "mar";
    public static final String key_apr = "apr";
    public static final String key_may = "may";
    public static final String key_jun = "jun";
    public static final String key_jul = "jul";
    public static final String key_aug = "aug";
    public static final String key_sep = "sep";
    public static final String key_oct = "oct";
    public static final String key_nov = "nov";
    public static final String key_dec = "dec";

    //Columns of karigar_table

    public static final String key_karigar_id = "karigar_id";
    public static final String key_karigar_name = "karigar_name";
    public static final String key_karigar_rating = "karigar_rating";
    public static final String key_karigar_specialisation = "karigar_specialisation";
    public static final String key_karigar_phone_no = "karigar_phone_no";
    public static final String key_karigar_address = "karigar_address";

    //Columns of karigar_specialisation

    public static final String key_karigar_specilasation_id = "karigar_specialisation_id";
    public static final String key_karigar_spec_no = "karigar_spec_no";
    public static final String key_karigar_item = "karigar_item";
    public static final String key_item_commision = "item_commission";
    public static final String key_item_rating = "item_rating";

    //Columns of Monthly_revenue

    public static final String key_monthly_revenue_id = "monthly_revenue_id";
    public static final String key_monthly_revenue_category = "monthly_revenue_category";
    public static final String key_revenue_month_name = "revenue_month_name";
    public static final String key_revenue_by_category = "revenue_by_category";

    //Columns of Monthly_profit

    public static final String key_monthly_profit_id = "monthly_profit_id";
    public static final String key_monthly_profit_category = "monthly_profit_category";
    public static final String key_profit_month_name = "profit_month_name";
    public static final String key_profit_by_category = "profit_by_category";

    //Columns of Weekly Revenue

    public static final String key_weekly_revenue_id = "weekly_revenue_id";
    public static final String key_weekly_revenue_category = "weekly_revenue_category";
    public static final String key_revenue_week_name = "revenue_week_name";
    public static final String key_weekly_revenue_by_category = "weekly_revenue_by_category";


    //Columns of Weekly_Profit

    public static final String key_weekly_profit_id = "weekly_profit_id";
    public static final String key_weekly_profit_category = "weekly_profit_category";
    public static final String key_profit_week_name = "profit_week_name";
    public static final String key_weekly_profit_by_category = "weekly_profit_by_category";


    //Columns of Daily_Revenue

    public static final String key_daily_revenue_id = "daily_revenue_id";
    public static final String key_daily_revenue_category = "daily_revenue_category";
    public static final String key_revenue_day_name = "revenue_day_name";
    public static final String key_daily_revenue_by_category = "daily_revenue_by_category";


    //Columns of Daily_Profit

    public static final String key_daily_profit_id = "daily_profit_id";
    public static final String key_daily_profit_category = "daily_profit_category";
    public static final String key_profit_day_name = "profit_day_name";
    public static final String key_daily_profit_by_category = "daily_profit_by_category";



    public Login_database_handler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_LOGIN + "("
                + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_username + " TEXT,"
                + key_password + " TEXT" + ")";
        String query1 = "CREATE TABLE " + TABLE_LOYALITY + "("
                + key_id_loyality + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_scheme_name + " TEXT,"
                + key_profit + " TEXT," + key_customers + " TEXT," + key_ornaments + " TEXT" + ")";
        String query2 = "CREATE TABLE " + TABLE_EMPLOYEE + "("
                + key_id_employee + " INTEGER PRIMARY KEY AUTOINCREMENT," + Key_employee_name + " TEXT,"
                + key_employee_salary + " TEXT," + key_employee_phone_no + " TEXT," + key_employee_address + " TEXT," + key_employeee_experience +
                " TEXT);";
        String query3 = "CREATE TABLE " + TABLE_ORDER + "("
                + key_id_order + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_order_name + " TEXT,"
                + key_order_items + " TEXT," + key_amount + " TEXT," + key_amount_paid + " TEXT, " + key_delivery_date + " TEXT" + ")";
        String query4 = "CREATE TABLE " + TABLE_REQUESTED_ORDER + "("
                + key_requested_order_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_requested_person + " TEXT,"
                + key_requested_items + " TEXT," + key_requested_amount + " TEXT," + key_requested_amount_paid + " TEXT," + key_requested_delivery + " TEXT,"
                + key_quotes_dispatched + " TEXT," + key_quotes_recieved + " TEXT" + ");";
        String query5 = "CREATE TABLE " + TABLE_DISPATCHED_ORDER + "("
                + key_dispatched_order_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_dispatched_person + " TEXT,"
                + key_dispatched_items + " TEXT, " + key_dispatched_amount + " TEXT, " + key_dispatched_amount_paid + " TEXT, " + key_dispatched_delivery + " TEXT, "
                + key_dispatched_percentage + " TEXT" + ")";
        String query6 = "CREATE TABLE " + TABLE_TO_BE_DELIVERED + "("
                + key_to_be_delivered_order_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_to_be_delivered_person + " TEXT,"
                + key_to_be_delivered_items + " TEXT, " + key_to_be_delivered_amount + " TEXT, " + key_to_be_delivered_amount_paid + " TEXT, " +
                key_to_be_delivered_percentage + " TEXT" + ")";
        String query7 = "CREATE TABLE " + TABLE_CHIT_FUNDS + "("
                + key_chitid + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_chit_name + " TEXT,"
                + key_chit_start_date + " TEXT, " + key_chit_pooled_amount + " TEXT, " + key_no_chits_done + " TEXT, " +
                key_chit_no_of_people_involved + " TEXT, " + key_chit_no_of_people_due + " TEXT, " + key_chit_due_amount + " TEXT" + ")";
        String query8 = "CREATE TABLE " + TABLE_CHIT_FUND_DUE + "("
                + key_chit_due_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_due_chit_name + " TEXT,"
                + key_due_person + " TEXT, " + key_due_amount + " TEXT" + ")";

        String query9 = "CREATE TABLE " + TABLE_EMPLOYEE_TYPE + "("
                + key_employee_type_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_employee_type_no + " TEXT, "
                + key_bargaining + " TEXT, " + key_rich + " TEXT, " + key_trustworthy + " TEXT" + ")";
        String query10 = "CREATE TABLE " + TABLE_EMPLOYEE_SKILLS + "("
                + key_employee_skill_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_employee_skill_no + " TEXT, " + key_rings + " TEXT, "
                + key_braclets + " TEXT, " + key_bangles + " TEXT, " + key_necklaces + " TEXT, " + key_chains + " TEXT" + ")";
        String query11 = "CREATE TABLE " + TABLE_EMPLOYEE_ATTENDANCE + "("
                + key_employee_attendance_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_jan + " TEXT, "
                + key_feb + " TEXT, " + key_mar + " TEXT, " + key_apr + " TEXT, " + key_may + " TEXT, " + key_jun + " TEXT, " +
                key_jul + " TEXT, " + key_aug + " TEXT, " + key_sep + " TEXT, " + key_oct + " TEXT, " + key_nov + " TEXT, " + key_dec + " TEXT, " + key_employee_attendance_no + " TEXT" + ")";
        String query12 = "CREATE TABLE " + TABLE_KARIGAR + "("
                + key_karigar_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_karigar_name + " TEXT, "
                + key_karigar_address + " TEXT, " + key_karigar_phone_no + " TEXT, " + key_karigar_specialisation + " TEXT, " +
                key_karigar_rating + " TEXT" + ")";

        String query13 = "CREATE TABLE " + TABLE_KARIGAR_SPECIALISATION + "("
                + key_karigar_specilasation_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_karigar_spec_no + " TEXT, "
                + key_karigar_item + " TEXT, " + key_item_rating + " TEXT, " + key_item_commision + " TEXT" + ")";

        String query14 =   "CREATE TABLE " + TABLE_MONTHLY_REVENUE + "("
                + key_monthly_revenue_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_revenue_month_name + " TEXT, "
                + key_monthly_revenue_category + " TEXT, " + key_revenue_by_category + " TEXT" + ")";

        String query15 =   "CREATE TABLE " + TABLE_MONTHLY_PROFIT + "("
                + key_monthly_profit_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_profit_month_name + " TEXT, "
                + key_monthly_profit_category + " TEXT, " + key_profit_by_category + " TEXT" + ")";

        String query16 =   "CREATE TABLE " + TABLE_WEEKLY_REVENUE + "("
                + key_weekly_revenue_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_revenue_week_name + " TEXT, "
                + key_weekly_revenue_category + " TEXT, " + key_weekly_revenue_by_category + " TEXT" + ")";

        String query17 =   "CREATE TABLE " + TABLE_WEEKLY_PROFIT + "("
                + key_weekly_profit_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_profit_week_name + " TEXT, "
                + key_weekly_profit_category + " TEXT, " + key_weekly_profit_by_category + " TEXT" + ")";

        String query18 =   "CREATE TABLE " + TABLE_DAILY_REVENUE + "("
                + key_daily_revenue_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_revenue_day_name + " TEXT, "
                + key_daily_revenue_category + " TEXT, " + key_daily_revenue_by_category + " TEXT" + ")";

        String query19 =   "CREATE TABLE " + TABLE_DAILY_PROFIT + "("
                + key_daily_profit_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + key_profit_day_name + " TEXT, "
                + key_daily_profit_category + " TEXT, " + key_daily_profit_by_category + " TEXT" + ")";



        db.execSQL(query);
        db.execSQL(query1);
        db.execSQL(query2);
        db.execSQL(query3);
        db.execSQL(query4);
        db.execSQL(query5);
        db.execSQL(query6);
        db.execSQL(query7);
        db.execSQL(query8);
        db.execSQL(query9);
        db.execSQL(query10);
        db.execSQL(query11);
        db.execSQL(query12);
        db.execSQL(query13);
        db.execSQL(query14);
        db.execSQL(query15);
        db.execSQL(query16);
        db.execSQL(query17);
        db.execSQL(query18);
        db.execSQL(query19);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOYALITY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REQUESTED_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISPATCHED_ORDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TO_BE_DELIVERED);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHIT_FUND_DUE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHIT_FUNDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE_SKILLS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE_ATTENDANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KARIGAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KARIGAR_SPECIALISATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MONTHLY_REVENUE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MONTHLY_PROFIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEEKLY_REVENUE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEEKLY_PROFIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAILY_REVENUE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DAILY_PROFIT);

        onCreate(db);
    }

    public void add_user(Login user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_username, user.getUsername());
        values.put(key_password, user.getPassword());
        db.insert(TABLE_LOGIN, null, values);
        db.close();

    }

    public void add_scheme(Loyality scheme) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_scheme_name, scheme.getScheme_name());
        values.put(key_customers, scheme.getCustomers());
        values.put(key_profit, scheme.getProfit());
        values.put(key_ornaments, scheme.getOrnaments());
        db.insert(TABLE_LOYALITY, null, values);
        db.close();
    }

    public void delete_scheme(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOYALITY, key_scheme_name + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_employee(Employee_db Employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Key_employee_name, Employee.getName());
        values.put(key_employee_salary, Employee.getSalary());
        values.put(key_employee_address, Employee.getAddress());
        values.put(key_employee_phone_no, Employee.getPhone_no());
        values.put(key_employeee_experience, Employee.getExperience());
        //values.put(key_employee_joining_date,Employee.getJoining_date());
        db.insert(TABLE_EMPLOYEE, null, values);
        db.close();
    }

    public void delete_employee(String no) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE, key_employee_phone_no + " = ?",
                new String[]{no});
        db.close();
    }

    public void add_new_order(New_Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_order_name, order.getName());
        values.put(key_order_items, order.getItems());
        values.put(key_amount, order.getAmount());
        values.put(key_amount_paid, order.getAmount_paid());
        values.put(key_delivery_date, order.getDelivery_date());
        db.insert(TABLE_ORDER, null, values);
        db.close();
    }

    public void delete_new_order(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDER, key_order_name + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_requested_order(Requested_Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_requested_person, order.getName());
        values.put(key_requested_amount, order.getAmount());
        values.put(key_requested_amount_paid, order.getAmount_paid());
        values.put(key_requested_delivery, order.getDelivery());
        values.put(key_requested_items, order.getItems());
        values.put(key_quotes_dispatched, order.getQuotes_dispatched());
        values.put(key_quotes_recieved, order.getQuotes_recieved());
        db.insert(TABLE_REQUESTED_ORDER, null, values);
        db.close();
    }

    public void delete_requested_order(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REQUESTED_ORDER, key_requested_person + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_to_be_delivered_order(To_be_delivered_db order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_to_be_delivered_person, order.getName());
        values.put(key_to_be_delivered_amount, order.getAmount());
        values.put(key_to_be_delivered_amount_paid, order.getAmount_paid());
        values.put(key_to_be_delivered_items, order.getItems());
        values.put(key_to_be_delivered_percentage, order.getPercentage());
        db.insert(TABLE_TO_BE_DELIVERED, null, values);
        db.close();
    }

    public void delete_to_be_delivered_order(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TO_BE_DELIVERED, key_to_be_delivered_person + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_dispatched_order(Dispatched_Order_db order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_dispatched_person, order.getName());
        values.put(key_dispatched_amount, order.getAmount());
        values.put(key_dispatched_amount_paid, order.getAmount_paid());
        values.put(key_dispatched_items, order.getItems());
        values.put(key_dispatched_delivery, order.getDelivery());
        values.put(key_dispatched_percentage, order.getPercentage_completed());
        db.insert(TABLE_DISPATCHED_ORDER, null, values);
        db.close();
    }

    public void delete_dispatched_order(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DISPATCHED_ORDER, key_dispatched_person + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_chit(chit_fund chit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_chit_name, chit.getName());
        values.put(key_chit_start_date, chit.getStart_date());
        values.put(key_chit_pooled_amount, chit.getPooled_amount());
        values.put(key_no_chits_done, chit.getNo_of_chits_done());
        values.put(key_chit_no_of_people_involved, chit.getNo_of_ppl());
        values.put(key_chit_no_of_people_due, chit.getNo_of_ppl_due());
        values.put(key_chit_due_amount, chit.getDue_amount());
        db.insert(TABLE_CHIT_FUNDS, null, values);
        db.close();
    }

    public void delete_chit(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHIT_FUNDS, key_chit_name + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_due_chit_fund(chit_fund_due chit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_due_chit_name, chit.getName());
        values.put(key_due_person, chit.getPerson_name());
        values.put(key_due_amount, chit.getAmount());
        db.insert(TABLE_CHIT_FUND_DUE, null, values);
        db.close();
    }

    public void delete_due_chit_fund(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHIT_FUND_DUE, key_due_chit_name + " = ?",
                new String[]{name});
        db.close();
    }

    public void add_employee_skill(Employee_skill e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_employee_skill_no, e.getNo());
        values.put(key_bangles, e.getBangles());
        values.put(key_braclets, e.getBraclets());
        values.put(key_rings, e.getRings());
        values.put(key_necklaces, e.getNecklaces());
        values.put(key_chains, e.getChains());
        db.insert(TABLE_EMPLOYEE_SKILLS, null, values);
        db.close();
    }

    public void delete_employee_skill(String no) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE_SKILLS, key_employee_skill_no + " = ?",
                new String[]{no});
        db.close();
    }

    public void add_employee_type(Employee_Type e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_employee_type_no, e.getNo());
        values.put(key_bargaining, e.getBargaining());
        values.put(key_trustworthy, e.getTrustworthy());
        values.put(key_rich, e.getRich());
        db.insert(TABLE_EMPLOYEE_TYPE, null, values);
        db.close();

    }

    public void delete_employee_type(String no) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE_TYPE, key_employee_type_no + " = ?",
                new String[]{no});
        db.close();
    }

    public void add_employee_attendance(Employee_attendance e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_employee_attendance_no, e.getNo());
        values.put(key_jan, e.getJan());
        values.put(key_feb, e.getFeb());
        values.put(key_mar, e.getMar());
        values.put(key_apr, e.getApr());
        values.put(key_may, e.getMay());
        values.put(key_jun, e.getJun());
        values.put(key_jul, e.getJuly());
        values.put(key_aug, e.getAug());
        values.put(key_sep, e.getSep());
        values.put(key_nov, e.getNov());
        values.put(key_oct, e.getOct());
        values.put(key_dec, e.getDec());
        db.insert(TABLE_EMPLOYEE_ATTENDANCE, null, values);
        db.close();

    }

    public void delete_employee_attendance(String no) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE_ATTENDANCE, key_employee_attendance_no + " = ?",
                new String[]{no});
        db.close();
    }

    public void add_karigar(Karigar k) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_karigar_name, k.getName());
        values.put(key_karigar_address, k.getAddress());
        values.put(key_karigar_phone_no, k.getPhone_no());
        values.put(key_karigar_rating, k.getRating());
        values.put(key_karigar_specialisation, k.getSpecialisation());
        db.insert(TABLE_KARIGAR, null, values);
        db.close();

    }

    public void delete_karigar(String no)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_KARIGAR, key_karigar_phone_no + " = ?",
                new String[]{no});
        db.close();
    }
    public void add_karigar_specialisation(Karigar_specialisation k)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_karigar_spec_no,k.getNo());
        values.put(key_karigar_item,k.getItem());
        values.put(key_item_commision,k.getCommission());
        values.put(key_item_rating,k.getRating());
        db.insert(TABLE_KARIGAR_SPECIALISATION, null, values);
        db.close();
    }
    public void delete_karigar_specialisation(String no)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_KARIGAR_SPECIALISATION, key_karigar_spec_no + " = ?",
                new String[]{no});
        db.close();
    }
    public void add_monthly_revenue(Monthly_Revenue m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_revenue_month_name,m.getName());
        values.put(key_revenue_by_category,m.getAmount());
        values.put(key_monthly_revenue_category,m.getCategory());
        db.insert(TABLE_MONTHLY_REVENUE, null, values);
        db.close();
    }
    public void delete_monthly_revenue(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MONTHLY_REVENUE, key_revenue_month_name + " = ?",
                new String[]{name});
        db.close();
    }
    public void add_monthly_profit(Monthly_Profit m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_profit_month_name,m.getName());
        values.put(key_profit_by_category,m.getAmount());
        values.put(key_monthly_profit_category,m.getCategory());
        db.insert(TABLE_MONTHLY_PROFIT, null, values);
        db.close();
    }
    public void delete_monthly_profit(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MONTHLY_PROFIT, key_profit_month_name + " = ?",
                new String[]{name});
        db.close();
    }
    public void add_weekly_revenue(Weekly_Revenue m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_revenue_week_name,m.getName());
        values.put(key_weekly_revenue_by_category,m.getAmount());
        values.put(key_weekly_revenue_category,m.getCategory());
        db.insert(TABLE_WEEKLY_REVENUE, null, values);
        db.close();
    }
    public void delete_weekly_revenue(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WEEKLY_REVENUE, key_revenue_week_name + " = ?",
                new String[]{name});
        db.close();
    }
    public void add_weekly_profit(Weekly_Profit m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_profit_week_name,m.getName());
        values.put(key_weekly_profit_by_category,m.getAmount());
        values.put(key_weekly_profit_category,m.getCategory());
        db.insert(TABLE_WEEKLY_PROFIT, null, values);
        db.close();
    }
    public void delete_weekly_profit(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WEEKLY_PROFIT, key_profit_week_name + " = ?",
                new String[]{name});
        db.close();
    }
    public void add_daily_revenue(Daily_Revenue m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_revenue_day_name,m.getName());
        values.put(key_daily_revenue_by_category,m.getAmount());
        values.put(key_daily_revenue_category,m.getCategory());
        db.insert(TABLE_DAILY_REVENUE, null, values);
        db.close();
    }
    public void delete_daily_revenue(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DAILY_REVENUE, key_revenue_day_name + " = ?",
                new String[]{name});
        db.close();
    }
    public void add_daily_profit(Daily_Profit m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(key_profit_day_name,m.getName());
        values.put(key_daily_profit_by_category,m.getAmount());
        values.put(key_daily_profit_category,m.getCategory());
        db.insert(TABLE_DAILY_PROFIT, null, values);
        db.close();
    }
    public void delete_daily_profit(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DAILY_PROFIT, key_profit_day_name + " = ?",
                new String[]{name});
        db.close();
    }


}

