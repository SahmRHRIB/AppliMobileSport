package com.example.PJS4.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.PJS4.AppDatabase;
import com.example.PJS4.DAO.ExerciceDao;
import com.example.PJS4.Entrainement.Exercice;
import com.example.appli.R;

import java.util.ArrayList;

public class EntrainementActivity extends NavigationActivity {

    private FloatingActionButton mBtnAjouter;
    private Toolbar mToolbar;
    private Toolbar mToolbarCommencer;
    private LinearLayout mLlListeExercices;
    private Button mBtnCommencer;
    private Integer idEnt;
    private int idMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrainement);

        idMenu = R.menu.menu_entrainement;
        initToolbar(R.id.toolbar);

        final Intent intent = getIntent();
        if(intent!=null) {
            idEnt = intent.getIntExtra("idEnt", 0);
        }

        mBtnAjouter = (FloatingActionButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarCommencer = (Toolbar) findViewById(R.id.toolbar_commencer);
        mLlListeExercices = (LinearLayout) findViewById(R.id.LL_exercices);
        mBtnCommencer = (Button) findViewById(R.id.button_commencer);

        mToolbar.setTitle(AppDatabase.getInstance(getBaseContext()).getEntrainementDao().getEntrainement(idEnt).getNom_entrainement());

        chargerExercices();

        mBtnCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AppDatabase.getInstance(getBaseContext()).getExerciceDao().getNbExercices(idEnt) >= 1) {
                    startActivity(new Intent(EntrainementActivity.this,SeanceActivity.class).putExtra("id_ent", idEnt));
                }
                else {
                    Toast.makeText(getBaseContext(),"Ajoutez au moins un exercice pour pouvoir commencer la séance.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrainementActivity.this,CreationExerciceActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    private void chargerExercices() {
        ArrayList<Exercice> exercices = (ArrayList<Exercice>) AppDatabase.getInstance(getBaseContext()).getExerciceDao().getAllExercices(idEnt);
        for(Exercice e : exercices) {
            Button newBtn = new Button(getBaseContext());

            newBtn.setHeight(0);
            newBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
            newBtn.setText(e.getNom_exercice());
            newBtn.setTextColor(getResources().getColor(R.color.colorText));

            mLlListeExercices = (LinearLayout) findViewById(R.id.LL_exercices);
            mLlListeExercices.addView(newBtn,mLlListeExercices.getChildCount());

            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) newBtn.getLayoutParams();
            params.bottomMargin = 10;

            newBtn.setTag(e.getId_exercice());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String nom = data.getStringExtra("nom");
                int nbSeries = data.getIntExtra("nbSeries",0);
                int nbReps = data.getIntExtra("nbReps",0);
                int tempsRepos = data.getIntExtra("tempsRepos",0);

                creerExercice(nom,nbSeries,nbReps,tempsRepos);
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(EntrainementActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void creerExercice(String nom, int series, int reps, int repos) {
        Exercice exo = new Exercice(nom,series,reps,repos,idEnt);

        ExerciceDao exerciceDao = AppDatabase.getInstance(getBaseContext()).getExerciceDao();
        exerciceDao.createExercice(exo);

        Button newBtn = new Button(getBaseContext());

        newBtn.setHeight(0);
        newBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
        newBtn.setText(exo.getNom_exercice());
        newBtn.setTextColor(getResources().getColor(R.color.colorText));

        mLlListeExercices = (LinearLayout) findViewById(R.id.LL_exercices);
        mLlListeExercices.addView(newBtn,mLlListeExercices.getChildCount());

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) newBtn.getLayoutParams();
        params.bottomMargin = 5;

        Toast.makeText(EntrainementActivity.this, "Exercice créé avec succès", Toast.LENGTH_SHORT).show();

        newBtn.setTag(exo.getId_exercice());
    }

    private void supprimerExercices(ViewGroup view) {
        ExerciceDao exerciceDao = AppDatabase.getInstance(getBaseContext()).getExerciceDao();
        Exercice ex;

        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                if(v.isSelected()) {
                    ex = exerciceDao.getExercice((Integer) v.getTag());
                    exerciceDao.delete(ex);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(idMenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnEdit :
                addOnNewClickListener(mLlListeExercices);
                idMenu = R.menu.menu_edit;
                invalidateOptionsMenu();
                mBtnAjouter.hide();
                return true;
            case R.id.btnProfil :
                startActivity(new Intent(this, ProfilActivity.class));
                return true;
            case R.id.btnHome :
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.btnClose :
                delOnNewClickListener(mLlListeExercices);
                idMenu = R.menu.menu_entrainement;
                invalidateOptionsMenu();
                mBtnAjouter.show();
                return true;
            case R.id.btnInfo :
                if(getSelectedButton(mLlListeExercices) != 0) {
                    startActivity(new Intent(EntrainementActivity.this,InfosExerciceActivity.class).putExtra("id_ex",getSelectedButton(mLlListeExercices)));
                }
                return true;
            case R.id.btnDelete :
                delSelectedButtons(mLlListeExercices);
                supprimerExercices(mLlListeExercices);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
    private void addOnNewClickListener(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!v.isSelected()) {
                            v.setSelected(true);
                            v.setBackgroundColor(Color.parseColor("#AFAFAF"));
                        }
                        else {
                            v.setSelected(false);
                            v.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
                        }
                    }
                });
            }
        }
    }
    private void delOnNewClickListener(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                v.setOnClickListener(null);
                v.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
            }
        }
    }
    private void delSelectedButtons(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                if(v.isSelected())
                    view.removeView(v);
            }
        }
    }
    private Integer getSelectedButton(ViewGroup view) {
        int nb = 0;
        View bouton = null;
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                if(v.isSelected()) {
                    nb++;
                    bouton = v;
                }
            }
        }
        if(nb == 1)
            return (Integer) bouton.getTag();
        else {
            Toast.makeText(EntrainementActivity.this, "Veuillez selectionner un seul entrainement pour afficher ses informations.", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

}
