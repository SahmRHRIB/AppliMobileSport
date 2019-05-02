package com.example.PJS4.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.appli.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class StatistiquesActivity extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistiques);

        initToolbar(R.id.toolbar);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle(R.string.statistiques);




        GraphView graph = (GraphView) findViewById(R.id.statgraph);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"J", "F", "M", "A", "M", "J", "J", "A", "S", "O", "N", "D"});
        staticLabelsFormatter.setVerticalLabels(new String[] {"0", "20", "40", "60", "80", "100", "120", "140"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(0.2, 1.5),
                new DataPoint(0.4, 2),
                new DataPoint(0.6, 2.5),

        });
        graph.addSeries(series);

    }


}
