package com.example.gurupradeep.jewelery_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.gurupradeep.jewelery_app.Databases.Login;
import com.example.gurupradeep.jewelery_app.Databases.Login_database_handler;

public class Signup extends AppCompatActivity {


    Login_database_handler login_database_handler;
    EditText username ;
    EditText password;
    EditText confirm_password;
    String _username;
    String _password;
    String _confirm_password;
    Button signup_button;
    EditText email_text;
    String _email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        username = (EditText)findViewById(R.id.signup_username);
        password = (EditText)findViewById(R.id.Signup_password);
        confirm_password = (EditText)findViewById(R.id.Signup_confirm_password);
        email_text =(EditText)findViewById(R.id.email_text);

        signup_button = (Button)findViewById(R.id.signup_button);
        signup_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _username = username.getText().toString();
                _password = password.getText().toString();
                _confirm_password = confirm_password.getText().toString();
                _email = email_text.getText().toString();
                if((_username.length()>0 && _confirm_password.length()>0) &&( _email.length()>0 && _password.length()>0)) {
                    if(!_confirm_password.equals(_password))
                    {
                        Toast.makeText(Signup.this,"Password and confirm password should match!!", Toast.LENGTH_SHORT).show();
                        confirm_password.setText("");
                        password.setText("");
                    }
                    else{
                        Toast.makeText(Signup.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                        login_database_handler = new Login_database_handler(getApplicationContext(), null, null, 8);
                        login_database_handler.add_user(new Login(_username, _password));
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(Signup.this, "All the fields are Compulsory", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                    confirm_password.setText("");
                    email_text.setText("");
                }
            }
        });



    }

}
