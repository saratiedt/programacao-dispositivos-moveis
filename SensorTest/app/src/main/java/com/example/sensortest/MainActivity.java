package com.example.sensortest;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;


import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor sensorLight;
    TextView textViewLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewLight=findViewById(R.id.tvSensorLigh);


        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();

        float currentValue = sensorEvent.values[0];
        textViewLight.setText(Float.toString(currentValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}