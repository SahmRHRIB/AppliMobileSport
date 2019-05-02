package com.example.PJS4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.DAO.UtilisateurDao;
import com.example.PJS4.Utilisateur.Utilisateur;
import com.example.appli.R;

import java.util.ArrayList;

public class ProfilActivity extends NavigationActivity {

    TextView mTextView_age;
    TextView mTextView_poids;
    TextView mTextView_taille;
    TextView mTextView_massem;
    TextView mTextView_masseg;
    TextView mTextView_biceps;
    TextView mTextView_avant_bras;
    TextView mTextView_poitrine;
    TextView mTextView_epaules;
    TextView mTextView_cou;
    TextView mTextView_tour_taille;
    TextView mTextView_cuisses;
    TextView mTextView_mollets;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initToolbar(R.id.toolbar);

        mTextView_age = (TextView) findViewById(R.id.editText_age);
        mTextView_poids = (TextView) findViewById(R.id.editText_poids);
        mTextView_taille = (TextView) findViewById(R.id.editText_taille);
        mTextView_massem = (TextView) findViewById(R.id.editText_massem);
        mTextView_masseg = (TextView) findViewById(R.id.editText_masseg);
        mTextView_biceps = (TextView) findViewById(R.id.textView_biceps);
        mTextView_avant_bras = (TextView) findViewById(R.id.textView_avant_bras);
        mTextView_poitrine = (TextView) findViewById(R.id.textView_poitrine);
        mTextView_epaules = (TextView) findViewById(R.id.textView_epaules);
        mTextView_cou = (TextView) findViewById(R.id.textView_cou);
        mTextView_tour_taille = (TextView) findViewById(R.id.textView_tour_taille);
        mTextView_cuisses = (TextView) findViewById(R.id.textView_cuisses);
        mTextView_mollets = (TextView) findViewById(R.id.textView_mollets);

        chargerInformations();
    }

    private void chargerInformations() {
        UtilisateurDao utilisateurDao = AppDatabase.getInstance(this).getUtilisateurDao();
        ArrayList<Utilisateur> etats = (ArrayList<Utilisateur>) AppDatabase.getInstance(this).getUtilisateurDao().getEtats();

        mTextView_age.setText(String.valueOf(utilisateurDao.getAge()));
        mTextView_poids.setText(String.valueOf(utilisateurDao.getPoids()));
        mTextView_taille.setText(String.valueOf(utilisateurDao.getTaille()));
        mTextView_massem.setText(String.valueOf(utilisateurDao.getMasseM()));
        mTextView_masseg.setText(String.valueOf(utilisateurDao.getMasseG()));
        mTextView_biceps.setText(String.valueOf(utilisateurDao.getMbiceps()));
        mTextView_avant_bras.setText(String.valueOf(utilisateurDao.getMavantBras()));
        mTextView_poitrine.setText(String.valueOf(utilisateurDao.getMpoitrine()));
        mTextView_epaules.setText(String.valueOf(utilisateurDao.getMepaules()));
        mTextView_cou.setText(String.valueOf(utilisateurDao.getMcou()));
        mTextView_tour_taille.setText(String.valueOf(utilisateurDao.getMtourTaille()));
        mTextView_cuisses.setText(String.valueOf(utilisateurDao.getMcuisses()));
        mTextView_mollets.setText(String.valueOf(utilisateurDao.getMmollets()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profil,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnEdit :
                startActivity(new Intent(this, EditProfilActivity.class));
                return true;
            case R.id.btnHome :
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
