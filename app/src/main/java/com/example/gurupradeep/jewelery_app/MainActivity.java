package com.example.gurupradeep.jewelery_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;


public class MainActivity extends AppCompatActivity {
    TextView b;
    EditText username;
    EditText password;
    Button login;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    SQLiteDatabase db;
    Login_database_handler login_database_handler;
    String _username;
    String _password;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Adding dummy data
        login_database_handler = new Login_database_handler(this,null,null,8);
//        login_database_handler.add_user(new Login("Guru","1234"));

        //Getting username and password
        username = (EditText)findViewById(R.id.Username);
        password =(EditText)findViewById(R.id.Password);
        b =(TextView)findViewById(R.id.signup_link);
       // login_database_handler = new Login_database_handler();
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });
        login = (Button)findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                login_validation();

            }
        });
    }
    public void login_validation()
    {
        _username = username.getText().toString();
        _password = password.getText().toString();
        username.setText("");
        password.setText("");
        try{
            if(_username.length() >0 && _password.length()>0)
            {
                db = login_database_handler.getWritableDatabase();
                Cursor mCursor = db.rawQuery("SELECT * FROM " + login_database_handler.TABLE_LOGIN+" WHERE "
                        +login_database_handler.key_username+"=? AND "+login_database_handler.key_password
                        +"=?", new String[]{_username, _password});
                if(mCursor!=null)
                {
                    if(mCursor.getCount() > 0)
                    {
                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }
                }
                if(mCursor.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "Invalid Username Or Password", Toast.LENGTH_SHORT).show();
                }

            }
        }
        catch(Exception e){
            Toast.makeText(MainActivity.this, "login unsuccessfull", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
