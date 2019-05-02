package com.example.PJS4.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appli.R;

public class CreationExerciceActivity extends NavigationActivity {
    private Button mBtnValider;
    private EditText mEditName;
    private EditText mEditSeries;
    private EditText mEditRep;
    private EditText mEditTemps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_exercice);

        initToolbar(R.id.toolbar);
        mBtnValider = (Button) findViewById(R.id.button_valider);
        mEditName = (EditText) findViewById(R.id.editText_nom);
        mEditSeries = (EditText) findViewById(R.id.editText_series);
        mEditRep = (EditText) findViewById(R.id.editText_reps);
        mEditTemps = (EditText) findViewById(R.id.editText_temps);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.ajouter_exercice);

        mBtnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(mEditName.getText().toString().matches("") || mEditRep.getText().toString().matches("") || mEditSeries.getText().toString().matches("") || mEditTemps.getText().toString().matches(""))) {
                    String editSeries = mEditSeries.getText().toString();
                    String editRep = mEditRep.getText().toString();
                    String editTemps = mEditTemps.getText().toString();

                    String nom = mEditName.getText().toString();
                    int nbSeries = Integer.parseInt(editSeries);
                    int nbReps = Integer.parseInt(editRep);
                    int tempsRepos = Integer.parseInt(editTemps);

                    Intent returnIntent = new Intent();

                    returnIntent.putExtra("nom", nom);
                    returnIntent.putExtra("nbSeries", nbSeries);
                    returnIntent.putExtra("nbReps", nbReps);
                    returnIntent.putExtra("tempsRepos", tempsRepos);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
                else {
                    Toast.makeText(CreationExerciceActivity.this, "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
