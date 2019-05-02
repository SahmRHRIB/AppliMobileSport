package com.example.PJS4.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.appli.R;

public abstract class NavigationActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    private int idMenu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initToolbar(int toolbarId) {
        idMenu = R.menu.menu;
        mToolbar = (Toolbar) findViewById(toolbarId);
        mToolbar.setNavigationIcon(R.drawable.baseline_arrow_back_black_18dp);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void initToolbarSeance(int toolbarId) {
        idMenu = R.menu.menu_seance;
        mToolbar = (Toolbar) findViewById(toolbarId);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(idMenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnHome :
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.btnProfil :
                startActivity(new Intent(this, ProfilActivity.class));
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
