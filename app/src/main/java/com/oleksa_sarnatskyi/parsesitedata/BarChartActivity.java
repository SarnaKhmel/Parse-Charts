package com.oleksa_sarnatskyi.parsesitedata;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> visitirs = new ArrayList<>();
        visitirs.add(new BarEntry(2014, 4503));
        visitirs.add(new BarEntry(2015, 6480));
        visitirs.add(new BarEntry(2016, 5934));
        visitirs.add(new BarEntry(2017, 4945));
        visitirs.add(new BarEntry(2018, 6740));
        visitirs.add(new BarEntry(2019, 7310));

        BarDataSet barDataSet = new BarDataSet(visitirs, "Відвідувачі");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Гістограма відвідувачів");
        barChart.animateY(2000);



    }
}
