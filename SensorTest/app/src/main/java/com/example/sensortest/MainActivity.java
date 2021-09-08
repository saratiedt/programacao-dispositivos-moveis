package com.example.sensortest;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;


import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    TextView textViewLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewLight=findViewById(R.id.tvSensorLigh);
        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

        List<Sensor> listSensor =  sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorListText = new StringBuilder();

        for (Sensor s: listSensor) {
            sensorListText.append(s.getName()).append(System.getProperty("line.separator"));
        }

        textViewLight.setText(sensorListText);

    }


}