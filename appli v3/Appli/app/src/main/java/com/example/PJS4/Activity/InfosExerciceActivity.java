package com.example.PJS4.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.Entrainement.Exercice;
import com.example.appli.R;

public class InfosExerciceActivity extends Activity {

    private Integer idEx;
    private Exercice exercice;
    private TextView textView_com;
    private TextView textView_nb_series;
    private TextView textView_nb_repet;
    private TextView textView_temps_repos;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_exercice);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int) (height*.6));

        idEx = getIntent().getIntExtra("id_ex",0);

        if(idEx == 0)
            setTitle("Erreur");
        else {
            exercice = AppDatabase.getInstance(getBaseContext()).getExerciceDao().getExercice(idEx);
            setTitle(exercice.getNom_exercice());
            textView_com = (TextView) findViewById(R.id.textView_com);
            textView_nb_series = (TextView) findViewById(R.id.textView_nb_series);
            textView_nb_repet = (TextView) findViewById(R.id.textView_nb_repetitions);
            textView_temps_repos = (TextView) findViewById(R.id.textView_temps_repos);

            textView_com.setText(exercice.getNom_exercice());
            textView_nb_series.setText(String.valueOf(exercice.getNb_series()));
            textView_nb_repet.setText(String.valueOf(exercice.getNb_repet()));
            textView_temps_repos.setText(String.valueOf(exercice.getTemps_repos()));
        }
    }
}
