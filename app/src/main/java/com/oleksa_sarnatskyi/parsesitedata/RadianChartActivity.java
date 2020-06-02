package com.oleksa_sarnatskyi.parsesitedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;

public class RadianChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radian_chart);

        RadarChart radarChart = findViewById(R.id.radarChart);


    }

}
