package com.example.PJS4.Entrainement;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Entrainement {

    @PrimaryKey(autoGenerate = true)
    private Integer id_entrainement;
    @ColumnInfo(name = "nom_entrainement")
    private String nom_entrainement;
    @ColumnInfo(name = "com_entrainement")
    private String com_entrainement;

    public Entrainement(String nom_entrainement, String com_entrainement) {
        this.nom_entrainement = nom_entrainement;
        this.com_entrainement = com_entrainement;
    }
    public Integer  getId_entrainement() {
        return id_entrainement;
    }

    public String getNom_entrainement() {
        return nom_entrainement;
    }
    public String getCom_entrainement() {
        return com_entrainement;
    }

    public void setId_entrainement(Integer id_entrainement) {
        this.id_entrainement = id_entrainement;
    }
}
