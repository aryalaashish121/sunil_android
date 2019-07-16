package com.example.football_club_app.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.football_club_app.R;

import LiveScoreBroadCastReciver.LivescoreNotification;

public class Dashboard extends AppCompatActivity {
    LivescoreNotification livescoreNotification = new LivescoreNotification(this);
Button news,player,kit;
    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        news = findViewById(R.id.news);

        kit = findViewById(R.id.buttonKits);
proximity();



        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,News_Display.class);
                startActivity(intent);
            }
        });



        kit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Dashboard.this, Fixture_Display.class);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(livescoreNotification,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(livescoreNotification);
    }

    public void proximity()
    {
        sensorManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null)
        {
            Toast.makeText(this, "Sensor not detected..", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Sensor Kicking in .....", Toast.LENGTH_SHORT).show();
        }

        SensorEventListener proximityListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                WindowManager.LayoutParams params = Dashboard.this.getWindow().getAttributes();
                if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                    if (event.values[0] == 0) {
                        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                        params.screenBrightness = 0;
                        getWindow().setAttributes(params);
                    } else {
                        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                        params.screenBrightness = -1f;
                        getWindow().setAttributes(params);
                    }
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(proximityListener,sensor,SensorManager.SENSOR_DELAY_FASTEST);
    }
}
