package com.oleksa_sarnatskyi.parsesitedata;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> visitorsAge = new ArrayList<>();
        visitorsAge.add(new PieEntry(1462, "0 - 10"));
        visitorsAge.add(new PieEntry(1828, "10 - 20"));
        visitorsAge.add(new PieEntry(1096, "20 - 30"));
        visitorsAge.add(new PieEntry(731, "30 - 50"));
        visitorsAge.add(new PieEntry(2193, "50 - 100"));

        PieDataSet pieDataSet = new PieDataSet(visitorsAge, "Вік відвідувачів");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Вік відвідувачів");
        pieChart.animate();



    }
}
