package com.example.PJS4.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.DAO.UtilisateurDao;
import com.example.appli.R;

public class EditProfilPlusActivity extends NavigationActivity {

    private EditText mEditBiceps;
    private EditText mEditAvantBras;
    private EditText mEditPoitrine;
    private EditText mEditEpaules;
    private EditText mEditCou;
    private EditText mEditTourTaille;
    private EditText mEditCuisses;
    private EditText mEditMollets;

    private float m_biceps = 0;
    private float m_avant_bras = 0;
    private float m_poitrine = 0;
    private float m_epaules = 0;
    private float m_cou = 0;
    private float m_tour_taille = 0;
    private float m_cuisses = 0;
    private float m_mollets = 0;

    private Button mBtnValider;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_plus);

        extras = getIntent().getExtras();

        initToolbar(R.id.toolbar);

        mEditBiceps = (EditText) findViewById(R.id.editText_biceps);
        mEditAvantBras = (EditText) findViewById(R.id.editText_avant_bras);
        mEditPoitrine = (EditText) findViewById(R.id.editText_poitrine);
        mEditEpaules = (EditText) findViewById(R.id.editText_epaules);
        mEditCou = (EditText) findViewById(R.id.editText_cou);
        mEditTourTaille = (EditText) findViewById(R.id.editText_tour_de_taille);
        mEditCuisses = (EditText) findViewById(R.id.editText_cuisses);
        mEditMollets = (EditText) findViewById(R.id.editText_mollets);

        mBtnValider = (Button) findViewById(R.id.button_valider);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle(R.string.profil);

        mBtnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UtilisateurDao utilisateurDao = AppDatabase.getInstance(getBaseContext()).getUtilisateurDao();

                if(!mEditBiceps.getText().toString().matches("")) {m_biceps = Float.parseFloat(mEditBiceps.getText().toString());}
                if(!mEditAvantBras.getText().toString().matches("")) {m_avant_bras = Float.parseFloat(mEditAvantBras.getText().toString());}
                if(!mEditPoitrine.getText().toString().matches("")) {m_poitrine = Float.parseFloat(mEditPoitrine.getText().toString());}
                if(!mEditEpaules.getText().toString().matches("")) {m_epaules = Float.parseFloat(mEditEpaules.getText().toString());}
                if(!mEditCou.getText().toString().matches("")) {m_cou = Float.parseFloat(mEditCou.getText().toString());}
                if(!mEditTourTaille.getText().toString().matches("")) {m_tour_taille = Float.parseFloat(mEditTourTaille.getText().toString());}
                if(!mEditCuisses.getText().toString().matches("")) {m_cuisses = Float.parseFloat(mEditCuisses.getText().toString());}
                if(!mEditMollets.getText().toString().matches("")) {m_mollets = Float.parseFloat(mEditMollets.getText().toString());}

                extras.putFloat("m_biceps",m_biceps);
                extras.putFloat("m_avant_bras",m_avant_bras);
                extras.putFloat("m_poitrine",m_poitrine);
                extras.putFloat("m_epaules",m_epaules);
                extras.putFloat("m_cou",m_cou);
                extras.putFloat("m_tour_taille",m_tour_taille);
                extras.putFloat("m_cuisses",m_cuisses);
                extras.putFloat("m_mollets",m_mollets);

                Intent returnIntent = new Intent();
                returnIntent.putExtras(extras);
                setResult(Activity.RESULT_OK,returnIntent);

                finish();
            }
        });
    }
}
