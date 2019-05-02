package com.example.PJS4.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.DAO.EntrainementDao;
import com.example.PJS4.DAO.ExerciceDao;
import com.example.PJS4.Entrainement.Exercice;
import com.example.appli.R;

import java.util.ArrayList;

public class SeanceActivity extends NavigationActivity implements View.OnClickListener {

    private Integer idEnt;
    private TextView mTextNbSerie;
    private TextView mTextNbRep;
    private EditText mEditPoids;
    private Button mBtnValider;
    private Toolbar mToolbar;
    EntrainementDao entrainementDao;
    ExerciceDao exerciceDao;
    ArrayList<Exercice> exercices;
    private int nSerie;
    private int nExercice;
    private int tempsRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seance);

        initToolbarSeance(R.id.toolbar);

        idEnt = getIntent().getIntExtra("id_ent",0);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextNbSerie = (TextView) findViewById(R.id.textView_num_series);
        mTextNbRep = (TextView) findViewById(R.id.textView_nb_rep);
        mEditPoids = (EditText) findViewById(R.id.editText_poids);
        mBtnValider = (Button) findViewById(R.id.button_valider);

        mBtnValider.setOnClickListener(this);

        entrainementDao = AppDatabase.getInstance(getBaseContext()).getEntrainementDao();
        exerciceDao = AppDatabase.getInstance(getBaseContext()).getExerciceDao();
        exercices = (ArrayList<Exercice>) exerciceDao.getAllExercices(idEnt);

        nExercice = 1;
        nSerie = 1;

        chargerExercice(nExercice,nSerie);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnClose :
                final AlertDialog.Builder builder = new AlertDialog.Builder(SeanceActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Terminer la séance");
                builder.setMessage("Voulez-vous vraiment terminer la séance ici ?");
                builder.setPositiveButton("Oui j'en ai marre",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                builder.setNegativeButton("Non !",
                        new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.btnSkip :
                nExercice++;
                nSerie = 1;
                chargerExercice(nExercice,nSerie);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
    public void chargerExercice(int nExercice, int nSerie) {
        if(nExercice < exercices.size()+1) {
            mToolbar.setTitle(exercices.get(nExercice - 1).getNom_exercice());
            mTextNbSerie.setText("Série n°" + nSerie);
            mTextNbRep.setText("Nombre de répétitions : " + Integer.toString(exercices.get(nExercice - 1).getNb_repet()));
            tempsRepos = exercices.get(nExercice - 1).getTemps_repos();
        }
        else {
            Toast.makeText(getBaseContext(),"Séance terminée",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if(mEditPoids.getText().toString().matches("")) {
            Toast.makeText(getBaseContext(),"Veuillez rentrer le poids utilisé.",Toast.LENGTH_SHORT).show();
        }
        else {
            // eventuellement enregistrer le poids
            if (nSerie < exercices.get(nExercice - 1).getNb_series()) {
                nSerie++;
                chargerExercice(nExercice, nSerie);
            } else {
                nExercice++;
                nSerie = 1;
                chargerExercice(nExercice, nSerie);
            }
            Intent chrono = new Intent(SeanceActivity.this,ChronoActivity.class);
            chrono.putExtra("temps_repos",tempsRepos);
            startActivity(chrono);
            mEditPoids.setText("");
        }
    }
}
