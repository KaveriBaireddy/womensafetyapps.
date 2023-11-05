package com.example.womenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText username,password;
   private static String value;
   public static String getValue()
   {
       return value;
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button);
         username=findViewById(R.id.editTextTextPersonName);
         password=findViewById(R.id.editTextTextPersonName2);
        b2.setOnClickListener(view -> {
            loginuser();
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void loginuser() {
        String user=username.getText().toString();
        String pass=password.getText().toString();
        FirebaseDatabase.getInstance().getReference().child("women").addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(user)) {
                    final String getpass = snapshot.child(user).child("pass").getValue(String.class);
                    if (getpass.equals(pass))
                    {
                        value=user.toString().trim();
                        Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"wrong password or username",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}