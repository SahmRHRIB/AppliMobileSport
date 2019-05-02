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

public class CreationEntrainementActivity extends NavigationActivity {

    private Button mBtnValider;
    private EditText mEditName;
    private EditText mEditDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_entrainement);

        initToolbar(R.id.toolbar);
        mBtnValider = (Button) findViewById(R.id.button_valider);
        mEditDesc = (EditText) findViewById(R.id.editText_desc);
        mEditName = (EditText) findViewById(R.id.editText_nom);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.entrainement);

        mBtnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = mEditName.getText().toString();
                String desc = mEditDesc.getText().toString();

                if (nom.matches("")) {
                    Toast.makeText(CreationEntrainementActivity.this, "Vous devez au moins renseigner un nom !", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent returnIntent = new Intent();

                    returnIntent.putExtra("nom",nom);
                    returnIntent.putExtra("desc",desc);

                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            }
        });
    }
}
