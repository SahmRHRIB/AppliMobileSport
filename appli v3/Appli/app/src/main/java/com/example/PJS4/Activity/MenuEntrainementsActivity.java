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
import com.example.PJS4.DAO.EntrainementDao;
import com.example.PJS4.Entrainement.Entrainement;
import com.example.appli.R;

import java.util.ArrayList;

public class MenuEntrainementsActivity extends NavigationActivity implements View.OnClickListener{

    private FloatingActionButton mBtnAjouter;
    private Toolbar mToolbar;
    private LinearLayout mLlListeEntrainements;
    private int idMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_entrainements);

        idMenu = R.menu.menu_entrainement;
        initToolbar(R.id.toolbar);

        mBtnAjouter = (FloatingActionButton) findViewById(R.id.fab);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mLlListeEntrainements = (LinearLayout) findViewById(R.id.LL_entrainements);

        mToolbar.setTitle(R.string.entrainement);
        chargerEntrainements();

        mBtnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuEntrainementsActivity.this, CreationEntrainementActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    private void chargerEntrainements() {
        ArrayList<Entrainement> entrainements = (ArrayList<Entrainement>) AppDatabase.getInstance(getBaseContext()).getEntrainementDao().getAllEntrainements();
        for(Entrainement e : entrainements) {
            Button newBtn = new Button(getBaseContext());

            newBtn.setHeight(0);
            newBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
            newBtn.setText(e.getNom_entrainement());
            newBtn.setTextColor(getResources().getColor(R.color.colorText));

            LinearLayout mLlListeEntrainements = (LinearLayout) findViewById(R.id.LL_entrainements);
            mLlListeEntrainements.addView(newBtn,mLlListeEntrainements.getChildCount());

            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) newBtn.getLayoutParams();
            params.bottomMargin = 5;

            newBtn.setOnClickListener(this);
            newBtn.setTag(e.getId_entrainement());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String nom = data.getStringExtra("nom");
                String desc = data.getStringExtra("desc");

                creerEntrainement(nom,desc);
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MenuEntrainementsActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void creerEntrainement(String nom, String desc) {
        Entrainement ent = new Entrainement(nom,desc);

        EntrainementDao entrainementDao = AppDatabase.getInstance(getBaseContext()).getEntrainementDao();
        entrainementDao.createEntrainement(ent);

        Button newBtn = new Button(getBaseContext());

        newBtn.setHeight(0);
        newBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
        newBtn.setText(ent.getNom_entrainement());
        newBtn.setTextColor(getResources().getColor(R.color.colorText));

        mLlListeEntrainements = (LinearLayout) findViewById(R.id.LL_entrainements);
        mLlListeEntrainements.addView(newBtn,mLlListeEntrainements.getChildCount());

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) newBtn.getLayoutParams();
        params.bottomMargin = 10;

        Toast.makeText(MenuEntrainementsActivity.this, "Entrainement créé avec succès", Toast.LENGTH_SHORT).show();

        newBtn.setOnClickListener(this);
        newBtn.setTag(ent.getId_entrainement());
    }
    private void supprimerEntrainements(ViewGroup view) {
        EntrainementDao entrainementDao = AppDatabase.getInstance(getBaseContext()).getEntrainementDao();
        Entrainement ent;

        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                if(v.isActivated()) {
                    ent = entrainementDao.getEntrainement((Integer) v.getTag());
                    entrainementDao.delete(ent);
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        Integer idEnt = (Integer) view.getTag();
        Intent intent = new Intent(MenuEntrainementsActivity.this, EntrainementActivity.class);
        intent.putExtra("idEnt",idEnt);
        startActivity(intent);
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
                addOnNewClickListener(mLlListeEntrainements);
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
                delOnNewClickListener(mLlListeEntrainements);
                addOnClickListener(mLlListeEntrainements);
                idMenu = R.menu.menu_entrainement;
                invalidateOptionsMenu();
                mBtnAjouter.show();
                return true;
            case R.id.btnInfo :
                if(!getSelectedButton(mLlListeEntrainements).equals(0)) {
                    startActivity(new Intent(MenuEntrainementsActivity.this,InfosEntrainementActivity.class).putExtra("id_ent",getSelectedButton(mLlListeEntrainements)));
                }
                return true;
            case R.id.btnDelete :
                delSelectedButtons(mLlListeEntrainements);
                supprimerEntrainements(mLlListeEntrainements);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    private void addOnClickListener(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                v.setOnClickListener(this);
            }
        }
    }

    private FloatingActionButton switchButton(FloatingActionButton fab) {
        FloatingActionButton fabPlay = fab;
        fabPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
        fabPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return fabPlay;
    }

    private void addOnNewClickListener(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View v = view.getChildAt(i);
            if (v instanceof Button) {
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!v.isActivated()) {
                            v.setActivated(true);
                            v.setBackgroundColor(Color.parseColor("#AFAFAF"));
                        }
                        else {
                            v.setActivated(false);
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
                if(v.isActivated())
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
                if(v.isActivated()) {
                    nb++;
                    bouton = v;
                }
            }
        }
        if(nb == 1)
            return (Integer) bouton.getTag();
        else {
            Toast.makeText(MenuEntrainementsActivity.this, "Veuillez selectionner un seul entrainement pour afficher ses informations.", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

}
