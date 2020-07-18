package com.example.healthapp.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthapp.R;

import java.util.logging.LogRecord;

public class StepCounter extends AppCompatActivity implements SensorEventListener {
    private ProgressBar progressBar;
    TextView stepcounter,calories_burnt;
    Sensor stepcounterSensor;
    SensorManager sensorManager;
    boolean isstepcounter;
    int StepCounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);
        stepcounter = findViewById(R.id.textViewStepCounter);
        progressBar = findViewById(R.id.progressBar);
        calories_burnt=findViewById(R.id.calories_burnt);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (StepCounts <= 5000) {
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {

//                        }
//                    });
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            stepcounterSensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isstepcounter=true;
        }else{
            stepcounter.setText("Step Counter not available");
            isstepcounter=false;
        }
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                        StepCounts= 0;
//                Toast.makeText(getApplicationContext(), "Click to reset steps",Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor==stepcounterSensor){
            StepCounts= (int) event.values[0];

            if(StepCounts<=5000){
                progressBar.setProgress(StepCounts);
                stepcounter.setText(StepCounts + " / 5000 STEPS");
                double calory=caloriesBurnt_func(StepCounts);
                String calory_str=String.valueOf(calory);
                calories_burnt.setText(calory_str);
            }
            else{
                Toast.makeText(getApplicationContext(), "5000 STEPS COMPLETE !!",Toast.LENGTH_LONG).show();
                resetStepCount();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void resetStepCount() {
        StepCounts = 0;
    }
    @Override //to register
    protected void onPostResume() {
        super.onPostResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.registerListener(this,stepcounterSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override //to unregister
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            sensorManager.unregisterListener(this, stepcounterSensor);
        }

    }
    public double caloriesBurnt_func(int StepCounts){
        return 0.045*StepCounts;
    }

}