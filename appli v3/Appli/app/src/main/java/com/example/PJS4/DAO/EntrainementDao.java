package com.example.PJS4.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.PJS4.Entrainement.Entrainement;

import java.util.List;

@Dao
public interface EntrainementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createEntrainement(Entrainement entrainement);

    @Update
    public void update(Entrainement entrainement);

    @Delete
    public void delete(Entrainement entrainement);

    @Query("SELECT nom_entrainement, com_entrainement FROM Entrainement WHERE id_entrainement LIKE :idEntrainement")
    public Entrainement getEntrainement(Integer idEntrainement);

    @Query("SELECT * FROM Entrainement")
    public List<Entrainement> getAllEntrainements();
}
