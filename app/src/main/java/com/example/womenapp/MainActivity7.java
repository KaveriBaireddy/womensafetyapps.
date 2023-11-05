package com.example.womenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        TextView t12=(TextView) findViewById(R.id.textView12);
        Intent i=getIntent();
        String n=i.getStringExtra("N");
        String r=i.getStringExtra("R");
        t12.setText(n+"\n\n"+r);
    }
}