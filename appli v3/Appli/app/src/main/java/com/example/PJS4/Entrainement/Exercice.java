package com.example.PJS4.Entrainement;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity
public class Exercice {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_exercice")
    private Integer id_exercice;
    @ColumnInfo(name = "id_entrainement")
    private Integer id_entrainement;
    @ColumnInfo(name = "nom_exercice")
    private String nom_exercice;
    @ColumnInfo(name = "nb_series")
    private int nb_series;
    @ColumnInfo(name = "nb_repet")
    private int nb_repet;
    @ColumnInfo(name = "temps_repos")
    private int temps_repos;
    //private long com;

    public Exercice(String nom_exercice,int nb_series,int nb_repet,int temps_repos, Integer id_entrainement) {
        this.nom_exercice = nom_exercice;
        this.nb_series = nb_series;
        this.nb_repet = nb_repet;
        this.temps_repos = temps_repos;
        this.id_entrainement = id_entrainement;
    }
    public Integer getId_exercice() { return id_exercice; }
    public String getNom_exercice() {
        return nom_exercice;
    }

    public int getNb_series() {
        return nb_series;
    }

    public void setNb_series(int nb_series) {
        this.nb_series = nb_series;
    }

    public int getNb_repet() {
        return nb_repet;
    }

    public void setNb_repet(int nb_repet) {
        this.nb_repet = nb_repet;
    }

    public int getTemps_repos() {
        return temps_repos;
    }

    public void setTemps_repos(int temps_repos) {
        this.temps_repos = temps_repos;
    }

    public Integer getId_entrainement() {
        return id_entrainement;
    }

    public void setId_entrainement(Integer ex_id_entrainement) {
        this.id_entrainement = ex_id_entrainement;
    }

    public void setId_exercice(Integer id_exercice) {
        this.id_exercice = id_exercice;
    }
}
