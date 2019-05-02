package com.example.PJS4.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.example.PJS4.Entrainement.Nutrition;

import java.util.List;

@Dao
public interface NutritionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void createRepas(Nutrition nutrition);

    @Update
    public void update(Nutrition nutrition);

    @Delete
    public void delete(Nutrition nutrition);

    @Query("SELECT * FROM Nutrition WHERE date_repas = :date_repas")
    public List<Nutrition> getAllRepas(String date_repas);
}
