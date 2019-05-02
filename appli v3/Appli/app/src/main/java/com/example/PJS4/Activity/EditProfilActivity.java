package com.example.PJS4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.DAO.UtilisateurDao;
import com.example.PJS4.Utilisateur.Utilisateur;
import com.example.appli.R;

import java.util.ArrayList;

public class EditProfilActivity extends NavigationActivity {

    private Button mBtnValider;
    private Button mBtnMensurations;
    private EditText mEditAge;
    private EditText mEditPoids;
    private EditText mEditTaille;
    private EditText mEditMasseM;
    private EditText mEditMasseG;
    private Bundle extras;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        initToolbar(R.id.toolbar);

        mEditAge = (EditText) findViewById(R.id.editText_age);
        mEditPoids = (EditText) findViewById(R.id.editText_poids);
        mEditTaille = (EditText) findViewById(R.id.editText_taille);
        mEditMasseG = (EditText) findViewById(R.id.editText_masseg);
        mEditMasseM = (EditText) findViewById(R.id.editText_massem);
        mBtnMensurations = (Button) findViewById(R.id.button_mensurations);
        mBtnValider = (Button) findViewById(R.id.button_valider);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle(R.string.profil);

        mBtnMensurations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfilActivity.this,EditProfilPlusActivity.class);
                Bundle extras = new Bundle();
                extras.putString("age",mEditAge.getText().toString());
                extras.putString("poids",mEditPoids.getText().toString());
                extras.putString("taille",mEditTaille.getText().toString());
                extras.putString("massem",mEditMasseM.getText().toString());
                extras.putString("masseg",mEditMasseG.getText().toString());

                intent.putExtras(extras);

                startActivityForResult(intent,1);
            }
        });
        mBtnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditAge.getText().toString().matches("") || mEditPoids.getText().toString().matches("") || mEditTaille.getText().toString().matches("")) {
                    Toast.makeText(EditProfilActivity.this, "Vous devez au moins renseigner un age, un poids et une taille.", Toast.LENGTH_SHORT).show();
                }
                else {
                    UtilisateurDao utilisateurDao = AppDatabase.getInstance(getBaseContext()).getUtilisateurDao();

                    Utilisateur utilisateur = new Utilisateur(Integer.parseInt(mEditAge.getText().toString()),Float.parseFloat(mEditPoids.getText().toString()),Float.parseFloat(mEditTaille.getText().toString()));

                    if(!mEditMasseM.getText().toString().matches("")) utilisateur.setMasse_musculaire(Float.parseFloat(mEditMasseM.getText().toString()));
                    if(!mEditMasseG.getText().toString().matches("")) utilisateur.setMasse_graisseuse(Float.parseFloat(mEditMasseG.getText().toString()));

                    if(extras!=null) {
                        utilisateur.setMensuration_biceps(extras.getFloat("m_biceps"));
                        utilisateur.setMensuration_avant_bras(extras.getFloat("m_avant_bras"));
                        utilisateur.setMensuration_poitrine(extras.getFloat("m_poitrine"));
                        utilisateur.setMensuration_epaules(extras.getFloat("m_epaules"));
                        utilisateur.setMensuration_cou(extras.getFloat("m_cou"));
                        utilisateur.setMensuration_tour_de_taille(extras.getFloat("m_tour_taille"));
                        utilisateur.setMensuration_cuisses(extras.getFloat("m_cuisses"));
                        utilisateur.setMensuration_mollets(extras.getFloat("m_mollets"));
                    }

                    ArrayList<Utilisateur> etats = (ArrayList<Utilisateur>) utilisateurDao.getEtats();
                    etats.add(utilisateur);

                    utilisateurDao.createUtilisateur(utilisateur);
                    utilisateurDao.setEtats(etats);

                    startActivity(new Intent(EditProfilActivity.this,ProfilActivity.class));
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                extras = data.getExtras();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(EditProfilActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
