package com.example.PJS4.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.Entrainement.Entrainement;
import com.example.PJS4.Entrainement.Exercice;
import com.example.appli.R;

import java.util.ArrayList;

public class InfosEntrainementActivity extends Activity {

    private Integer idEnt;
    private Entrainement ent;
    private TextView textView_com;
    private TextView textView_nb_exercices;
    private LinearLayout LL_liste_exercices;
    private ArrayList<Exercice> liste_exercices;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_entrainement);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int) (height*.6));

        idEnt = getIntent().getIntExtra("id_ent",0);

        if(idEnt == 0)
            setTitle("Erreur");
        else {
            ent = AppDatabase.getInstance(getBaseContext()).getEntrainementDao().getEntrainement(idEnt);
            setTitle(ent.getNom_entrainement());
            textView_com = (TextView) findViewById(R.id.textView_com);
            textView_nb_exercices = (TextView) findViewById(R.id.textView_nb_exercices);
            LL_liste_exercices = (LinearLayout) findViewById(R.id.LL_liste_exercices);

            textView_com.setText(ent.getCom_entrainement());
            textView_nb_exercices.setText(String.valueOf(AppDatabase.getInstance(getBaseContext()).getExerciceDao().getNbExercices(idEnt)));

            liste_exercices = (ArrayList<Exercice>) AppDatabase.getInstance(getBaseContext()).getExerciceDao().getAllExercices(idEnt);

            for(Exercice exo : liste_exercices) {
                TextView exercice = new TextView(getBaseContext());
                exercice.setGravity(Gravity.START);
                exercice.setTextSize(14);
                exercice.setText(exo.getNom_exercice());
                LL_liste_exercices.addView(exercice);
            }

        }
    }
}
