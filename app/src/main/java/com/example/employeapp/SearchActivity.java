package com.example.employeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getcode,getname,getdesignation,getmobileno;
DbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText) findViewById(R.id.employeecode);
        ed2=(EditText) findViewById(R.id.employeename);
        ed3=(EditText) findViewById(R.id.designation);
        ed4=(EditText) findViewById(R.id.mobileno);
        b1=(AppCompatButton) findViewById(R.id.search);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             getcode=ed1.getText().toString();
                Cursor c=mydb.SearchEmployee(getcode);
                if (c.getCount()==0)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "NO RESULT", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   while(c.moveToNext())
                   {
                     getname=c.getString(2);
                     getdesignation=c.getString(3);
                     getmobileno=c.getString(4);
                   }
                   ed2.setText(getname);
                   ed3.setText(getdesignation);
                   ed4.setText(getmobileno);
                }
            }
        });


    }
}