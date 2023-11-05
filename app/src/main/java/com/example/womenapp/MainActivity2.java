package com.example.womenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    Button b1;
    EditText username,mobile,place,email,password;
    FirebaseDatabase rootNode;
    DatabaseReference ref;


    myDbAdapter helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = findViewById(R.id.button3);
        username=findViewById(R.id.editTextTextPersonName3);
        mobile=findViewById(R.id.editTextTextPersonName4);
        place=findViewById(R.id.editTextTextPersonName5);
        email=findViewById(R.id.editTextTextPersonName8);
        password=findViewById(R.id.editTextTextPersonName7);


        helper = new myDbAdapter(this);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                ref=rootNode.getReference("women");
                String user=username.getText().toString();
                String number=mobile.getText().toString();
                String location=place.getText().toString();
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                Userhelper users=new Userhelper(user,number,location,mail,pass);
                rootNode =FirebaseDatabase.getInstance();
                ref=rootNode.getReference("women");
                ref.child(user).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity2.this,"successfully updated",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void addUser(View view)
    {
        String t1 = username.getText().toString();
        String t2 = password.getText().toString();
        if(t1.isEmpty() || t2.isEmpty())
        {
            com.example.womenapp.message.message(getApplicationContext(),"Enter Both Name and Password");

        }
        else
        {
            long id = helper.insertData(t1,t2);
            if(id<=0)
            {
                com.example.womenapp.message.message(getApplicationContext(),"Insertion Unsuccessful");
                username.setText("");
                password.setText("");
            } else
            {
                com.example.womenapp.message.message(getApplicationContext(),"Insertion Successful");
                username.setText("");
                password.setText("");
            }
        }
    }

    public void viewdata(View view)
    {
        String data = helper.getData();
        com.example.womenapp.message.message(this,data);
    }



}