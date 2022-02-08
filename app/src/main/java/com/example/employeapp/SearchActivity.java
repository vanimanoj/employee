package com.example.employeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
AppCompatButton b1;
String getcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText) findViewById(R.id.employeecode);
        ed2=(EditText) findViewById(R.id.employeename);
        ed3=(EditText) findViewById(R.id.designation);
        ed4=(EditText) findViewById(R.id.mobileno);
        b1=(AppCompatButton) findViewById(R.id.search);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             getcode=ed1.getText().toString();
                Toast.makeText(getApplicationContext(), getcode, Toast.LENGTH_SHORT).show();
            }
        });


    }
}