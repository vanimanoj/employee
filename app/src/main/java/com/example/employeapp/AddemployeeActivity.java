package com.example.employeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddemployeeActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getemployeecode,getname,getdesignation,getmobileno;
DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);
        ed1=(EditText) findViewById(R.id.employeecode);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.designation);
        ed4=(EditText) findViewById(R.id.mobileno);
        b1=(AppCompatButton) findViewById(R.id.submit);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getemployeecode = ed1.getText().toString();
                getname = ed2.getText().toString();
                getdesignation = ed3.getText().toString();
                getmobileno = ed4.getText().toString();
                boolean status = mydb.insertEmployee(getemployeecode, getname, getdesignation, getmobileno);
                if (status == true)
                {
                    Toast.makeText(getApplicationContext(), "Succesfully Inserted", Toast.LENGTH_SHORT).show();
                } else
                    {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
            }
        });




    }
}