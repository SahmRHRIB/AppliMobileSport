package com.example.PJS4.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.PJS4.Entrainement.Exercice;

import java.util.List;

@Dao
public interface ExerciceDao {
    @Insert
    void createExercice(Exercice exercice);

    @Update
    public void update(Exercice exercice);

    @Delete
    public void delete(Exercice exercice);

    @Query("SELECT * FROM Exercice WHERE id_entrainement = :idEntrainement")
    public List<Exercice> getAllExercices(Integer idEntrainement);

    @Query("SELECT *, COUNT(*) FROM Exercice WHERE id_entrainement = :idEntrainement")
    public int getNbExercices(Integer idEntrainement);

    @Query("SELECT * FROM Exercice WHERE id_exercice = :idExercice")
    public Exercice getExercice(Integer idExercice);
}
