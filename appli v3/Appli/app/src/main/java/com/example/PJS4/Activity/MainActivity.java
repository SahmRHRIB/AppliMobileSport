package com.example.PJS4.Activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.DAO.UtilisateurDao;
import com.example.PJS4.Utilisateur.Utilisateur;
import com.example.appli.R;

import java.util.ArrayList;

public class MainActivity extends NavigationActivity {

    private Button mBtnEntrainements = null;
    private Button mBtnNutrition = null;
    private Button mBtnStatistiques = null;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class,"mydb")
                .allowMainThreadQueries()
                .build();

        initToolbar(R.id.toolbar);

        mBtnNutrition = (Button) findViewById(R.id.button_nutrition);
        mBtnStatistiques = (Button) findViewById(R.id.button_statistiques);
        mBtnEntrainements = (Button) findViewById(R.id.button_entrainements);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setNavigationIcon(null);
        mToolbar.setTitle(R.string.app_name);


        mBtnEntrainements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_entrainements = new Intent(MainActivity.this, MenuEntrainementsActivity.class);
                startActivity(menu_entrainements);
            }
        });

        mBtnNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nutrition_activity = new Intent(MainActivity.this, NutritionActivity.class);
                startActivity(nutrition_activity);
            }
        });

        mBtnStatistiques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statistiques_activity = new Intent(MainActivity.this, StatistiquesActivity.class);
                startActivity(statistiques_activity);
            }
        });

        UtilisateurDao utilisateurDao = AppDatabase.getInstance(this).getUtilisateurDao();
        ArrayList<Utilisateur> etats = (ArrayList<Utilisateur>) utilisateurDao.getEtats();
        etats.add(utilisateurDao.getUtilisateur());
        utilisateurDao.setEtats(etats);
    }


}
