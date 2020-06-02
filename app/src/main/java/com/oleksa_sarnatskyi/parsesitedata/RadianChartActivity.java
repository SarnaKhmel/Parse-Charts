package com.oleksa_sarnatskyi.parsesitedata;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class RadianChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radian_chart);

        RadarChart radarChart = findViewById(R.id.radarChart);

        ArrayList<RadarEntry> profit = new ArrayList<>();

        profit.add(new RadarEntry(4503*30));
        profit.add(new RadarEntry(6480*30));
        profit.add(new RadarEntry(5934*30));
        profit.add(new RadarEntry(4945*30));
        profit.add(new RadarEntry(6740*30));
        profit.add(new RadarEntry(7310*30));

        RadarDataSet profitSum = new RadarDataSet(profit, "Сума прибутку");
        profitSum.setColor(Color.GREEN);
        profitSum.setLineWidth(3f);
        profitSum.setValueTextColor(Color.BLACK);
        profitSum.setValueTextSize(16f);

        RadarData radarData = new RadarData();
        radarData.addDataSet(profitSum);

        String[] labels = {"2014", "2015", "2016", "2017", "2018", "2019"};

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        radarChart.setData(radarData);


    }

}
