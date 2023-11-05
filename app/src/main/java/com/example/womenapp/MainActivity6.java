package com.example.womenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        EditText name=(EditText)findViewById(R.id.editTextTextPersonName6);
        EditText no=(EditText) findViewById(R.id.editTextTextPersonName9);
        Button b5=(Button) findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name1=name.getText().toString();
                Intent i=new Intent(MainActivity6.this,MainActivity7.class);
                i.putExtra("N","name : "+name1);
                String r=no.getText().toString();
                i.putExtra("R","Number :"+r);
                startActivity(i);
            }
        });
    }
}