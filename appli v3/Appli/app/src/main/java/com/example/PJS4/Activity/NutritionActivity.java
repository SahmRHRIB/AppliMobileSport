package com.example.PJS4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.Entrainement.Nutrition;
import com.example.appli.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NutritionActivity extends NavigationActivity {

    private Toolbar mToolbar;
    private CalendarView calendarView;
    private TextView repasaffichage;
    TextView madate;
    private Button rep;
    static private String date ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        initToolbar(R.id.toolbar);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        repasaffichage = findViewById(R.id.affichage_repas);
        mToolbar.setTitle(R.string.nutrition);
        rep = (Button)findViewById(R.id.Repas);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        madate= (TextView) findViewById(R.id.date);
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        final String todayString = formatter.format(todayDate);
        madate.setText(todayString);

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Repas = new Intent(NutritionActivity.this, CreationRepasActivity.class);
                Repas.putExtra("Date", todayString);
                startActivity(Repas);
            }
        });
       calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

           @Override
           public void onSelectedDayChange(CalendarView view, int i, int i1, int i2) {
                   date = i2+ "/" +(i1+1)+ "/"+i;
                   madate.setText(date);
                   chargerRepas(date);
               rep.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent Repas = new Intent(NutritionActivity.this,CreationRepasActivity.class);
                       Repas.putExtra("Date", date);
                       startActivity(Repas);
                   }
               });}
       });
    }
    private void chargerRepas(String date){
        ArrayList<Nutrition> repas = (ArrayList<Nutrition>) AppDatabase.getInstance(getBaseContext()).getNutritionDao().getAllRepas(date);
        String liste = "";
        for(Nutrition p : repas) {
            String petit_dej = p.getPetit_dejeuner();
            String dejeuner = p.getDejeuner();
            String diner = p.getDiner();
            String complement = p.getComplement();
            liste = "Petite dejeuner: " + petit_dej + "\n" + "Dejeuner: " + dejeuner + "\n" + "Diner: " + diner + "\n" + "Complement: " + complement + "\n";
        }
        repasaffichage.setText(liste);
    }
}
