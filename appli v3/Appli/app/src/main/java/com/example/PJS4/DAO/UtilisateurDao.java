package com.example.PJS4.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;
import android.arch.persistence.room.Update;

import com.example.PJS4.Utilisateur.Utilisateur;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UtilisateurDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createUtilisateur(Utilisateur utilisateur);

    @Update
    public void update(Utilisateur utilisateur);

    @Delete
    public void delete(Utilisateur utilisateur);

    /**
     * GETTERS
     */
    @Query("SELECT age_utilisateur FROM Utilisateur")
    public int getAge();
    @Query("SELECT poids_utilisateur FROM Utilisateur")
    public float getPoids();
    @Query("SELECT taille_utilisateur FROM Utilisateur")
    public float getTaille();
    @Query("SELECT masse_musculaire FROM Utilisateur")
    public float getMasseM();
    @Query("SELECT masse_graisseuse FROM Utilisateur")
    public float getMasseG();
    @Query("SELECT mensuration_biceps FROM Utilisateur")
    public float getMbiceps();
    @Query("SELECT mensuration_avant_bras FROM Utilisateur")
    public float getMavantBras();
    @Query("SELECT mensuration_poitrine FROM Utilisateur")
    public float getMpoitrine();
    @Query("SELECT mensuration_epaules FROM Utilisateur")
    public float getMepaules();
    @Query("SELECT mensuration_cou FROM Utilisateur")
    public float getMcou();
    @Query("SELECT mensuration_tour_de_taille FROM Utilisateur")
    public float getMtourTaille();
    @Query("SELECT mensuration_cuisses FROM Utilisateur")
    public float getMcuisses();
    @Query("SELECT mensuration_mollets FROM Utilisateur")
    public float getMmollets();

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT etats_utilisateur, * FROM Utilisateur")
    public List<Utilisateur> getEtats();
    @Query("UPDATE Utilisateur SET etats_utilisateur = :utilisateurs")
    public void setEtats(ArrayList<Utilisateur> utilisateurs);
    @Query("SELECT * FROM Utilisateur")
    public Utilisateur getUtilisateur();
}
