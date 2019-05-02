package com.example.PJS4.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.PJS4.AppDatabase;
import com.example.PJS4.Entrainement.Nutrition;
import com.example.appli.R;

public class CreationRepasActivity extends NavigationActivity {
    private Button btn;
    private TextView dateRepas, petit_dej, dej, diner, complement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_repas);

        initToolbar(R.id.toolbar);

        btn = findViewById(R.id.send_repas);
        petit_dej = findViewById(R.id.editText_petit_dej);
        dej = findViewById(R.id.editText_dej);
        diner = findViewById(R.id.editText_diner);
        complement = findViewById(R.id.editText_complement);
        dateRepas = findViewById(R.id.dateRepas);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(petit_dej.getText().toString().matches("") || dej.getText().toString().matches("") || diner.getText().toString().matches(""))) {
                    String petit_dejF = petit_dej.getText().toString();
                    String dejeunerF = dej.getText().toString();
                    String dinerF = diner.getText().toString();
                    String complementF = complement.getText().toString();
                    Nutrition nutrition = new Nutrition();
                    nutrition.setDate_repas(getIntent().getStringExtra("Date"));
                    nutrition.setPetit_dejeuner(petit_dejF);
                    nutrition.setDejeuner(dejeunerF);
                    nutrition.setDiner(dinerF);
                    nutrition.setComplement(complementF);
                    AppDatabase.getInstance(getBaseContext()).getNutritionDao().createRepas(nutrition);
                    finish();
                }
                else {
                    Toast.makeText(CreationRepasActivity.this, "Veuillez renseigner tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
