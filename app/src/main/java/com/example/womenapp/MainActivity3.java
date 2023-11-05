package com.example.womenapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
    ProgressDialog pd;
    private SensorManager mSensorManager;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;
    private String phonenumber;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 10f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Women safety");
        Button menu8;
        menu8=findViewById(R.id.button8);
        menu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createPackageContext;
                Intent intent8=new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent8);
            }
        });

        Button b=(Button) findViewById(R.id.button7);
        Button saftey=(Button) findViewById(R.id.saftey);
        saftey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), fragment1_menu.class));
            }
        });

        b.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity3.this);

                builder.setTitle("Logout")

                        .setMessage("Are you sure?")

                        .setCancelable(false)

                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent i7=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i7);

                                Toast.makeText(MainActivity3.this,"Selected option is yes",Toast.LENGTH_LONG).show();

                            }

                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity3.this,"Selected option is No",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
    }
    private final SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta;
            if (mAccel > 12) {
                Toast.makeText(getApplicationContext(), "Shake event detected", Toast.LENGTH_SHORT).show();
                /*user=MainActivity.getValue();
                user = user.replaceAll("[.#$\\[\\]]", "");
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference ref=database.getReference("women").child("number");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {*/
                        String value ="9390837026";
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + value));
                        if (ActivityCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // Request for permission
                            ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        } else {
                            // Permission already granted
                            startActivity(callIntent);
                        }
                  /*  }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"failed to read", Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
    @Override
    protected void onResume() {
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }
    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }






    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {

            case R.id.share:
                Toast.makeText(this, "Share Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.refresh:
                Toast.makeText(this, "Refresh Clicked", Toast.LENGTH_SHORT).show();
                break;



            case R.id.safetytips:

                Intent i1=new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(i1);
                break;
            case R.id.help:

                Intent help=new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(help);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}