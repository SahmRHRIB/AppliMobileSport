package com.example.PJS4.Utilisateur;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;

@Entity
public class Utilisateur {
    // INFOS DE BASE
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id_utilisateur")
    private long id_utilisateur;
    @ColumnInfo(name = "age_utilisateur")
    private int age_utilisateur;
    @ColumnInfo(name = "poids_utilisateur")
    private float poids_utilisateur;
    @ColumnInfo(name = "taille_utilisateur")
    private float taille_utilisateur;
    @ColumnInfo(name = "masse_musculaire")
    private float masse_musculaire;
    @ColumnInfo(name = "masse_graisseuse")
    private float masse_graisseuse;

    // MENSURATIONS OPTIONELLES
    @ColumnInfo(name = "mensuration_biceps")
    private float mensuration_biceps;
    @ColumnInfo(name = "mensuration_avant_bras")
    private float mensuration_avant_bras;
    @ColumnInfo(name = "mensuration_poitrine")
    private float mensuration_poitrine;
    @ColumnInfo(name = "mensuration_epaules")
    private float mensuration_epaules;
    @ColumnInfo(name = "mensuration_cou")
    private float mensuration_cou;
    @ColumnInfo(name = "mensuration_tour_de_taille")
    private float mensuration_tour_de_taille;
    @ColumnInfo(name = "mensuration_cuisses")
    private float mensuration_cuisses;
    @ColumnInfo(name = "mensuration_mollets")
    private float mensuration_mollets;

    // LISTE PRECEDENTES INFOS
    @ColumnInfo(name = "etats_utilisateur")
    private ArrayList<Utilisateur> etats_utilisateur;

    public Utilisateur(int age_utilisateur, float poids_utilisateur, float taille_utilisateur) {
        this.age_utilisateur = age_utilisateur;
        this.poids_utilisateur = poids_utilisateur;
        this.taille_utilisateur = taille_utilisateur;
        etats_utilisateur = new ArrayList<>();
    }

    public long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getAge_utilisateur() {
        return age_utilisateur;
    }

    public void setAge_utilisateur(int age_utilisateur) {
        this.age_utilisateur = age_utilisateur;
    }

    public float getPoids_utilisateur() {
        return poids_utilisateur;
    }

    public void setPoids_utilisateur(float poids_utilisateur) {
        this.poids_utilisateur = poids_utilisateur;
    }

    public float getTaille_utilisateur() {
        return taille_utilisateur;
    }

    public void setTaille_utilisateur(float taille_utilisateur) {
        this.taille_utilisateur = taille_utilisateur;
    }

    public float getMasse_musculaire() {
        return masse_musculaire;
    }

    public void setMasse_musculaire(float masse_musculaire) {
        this.masse_musculaire = masse_musculaire;
    }

    public float getMasse_graisseuse() {
        return masse_graisseuse;
    }

    public void setMasse_graisseuse(float masse_graisseuse) {
        this.masse_graisseuse = masse_graisseuse;
    }

    public float getMensuration_biceps() {
        return mensuration_biceps;
    }

    public void setMensuration_biceps(float mensuration_biceps) {
        this.mensuration_biceps = mensuration_biceps;
    }

    public float getMensuration_avant_bras() {
        return mensuration_avant_bras;
    }

    public void setMensuration_avant_bras(float mensuration_avant_bras) {
        this.mensuration_avant_bras = mensuration_avant_bras;
    }

    public float getMensuration_poitrine() {
        return mensuration_poitrine;
    }

    public void setMensuration_poitrine(float mensuration_poitrine) {
        this.mensuration_poitrine = mensuration_poitrine;
    }

    public float getMensuration_epaules() {
        return mensuration_epaules;
    }

    public void setMensuration_epaules(float mensuration_epaules) {
        this.mensuration_epaules = mensuration_epaules;
    }

    public float getMensuration_cou() {
        return mensuration_cou;
    }

    public void setMensuration_cou(float mensuration_cou) {
        this.mensuration_cou = mensuration_cou;
    }

    public float getMensuration_tour_de_taille() {
        return mensuration_tour_de_taille;
    }

    public void setMensuration_tour_de_taille(float mensuration_tour_de_taille) {
        this.mensuration_tour_de_taille = mensuration_tour_de_taille;
    }

    public float getMensuration_cuisses() {
        return mensuration_cuisses;
    }

    public void setMensuration_cuisses(float mensuration_cuisses) {
        this.mensuration_cuisses = mensuration_cuisses;
    }

    public float getMensuration_mollets() {
        return mensuration_mollets;
    }

    public void setMensuration_mollets(float mensuration_mollets) {
        this.mensuration_mollets = mensuration_mollets;
    }

    public ArrayList<Utilisateur> getEtats_utilisateur() {
        return etats_utilisateur;
    }

    public void setEtats_utilisateur(ArrayList<Utilisateur> etats_utilisateur) {
        this.etats_utilisateur = etats_utilisateur;
    }
}
