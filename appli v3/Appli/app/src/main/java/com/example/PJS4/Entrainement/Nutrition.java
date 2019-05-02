package com.example.PJS4.Entrainement;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Nutrition {


    @PrimaryKey(autoGenerate = true)
    private int idRepas;

    @ColumnInfo(name = "date_repas")
    private String date_repas;

    @ColumnInfo(name = "petit_dejeuner")
    private String petit_dejeuner;

    @ColumnInfo(name = "dejeuner")
    private String dejeuner;

    @ColumnInfo(name = "diner")
    private String diner;

    @ColumnInfo(name = "complement")
    private String complement;


    public int getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public String getDate_repas() {
        return date_repas;
    }

    public String getPetit_dejeuner() {
        return petit_dejeuner;
    }

    public String getDejeuner() {
        return dejeuner;
    }

    public String getDiner() {
        return diner;
    }

    public String getComplement() {
        return complement;
    }

    public void setDate_repas(@NonNull String date_repas) {
        this.date_repas = date_repas;
    }

    public void setPetit_dejeuner(String petit_dejeuner) {
        this.petit_dejeuner = petit_dejeuner;
    }

    public void setDejeuner(String dejeuner) {
        this.dejeuner = dejeuner;
    }

    public void setDiner(String diner) {
        this.diner = diner;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String toString(){
        String s = ""+ date_repas + " " + petit_dejeuner + " " + dejeuner + " " + diner + " " + complement +"";
        return s;
    }
}
