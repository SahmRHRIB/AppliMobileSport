package com.example.PJS4;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.PJS4.DAO.ExerciceDao;
import com.example.PJS4.DAO.Converters;
import com.example.PJS4.DAO.EntrainementDao;
import com.example.PJS4.DAO.NutritionDao;
import com.example.PJS4.DAO.UtilisateurDao;
import com.example.PJS4.Entrainement.Entrainement;
import com.example.PJS4.Entrainement.Exercice;
import com.example.PJS4.Entrainement.Nutrition;
import com.example.PJS4.Utilisateur.Utilisateur;

@Database(entities = {Entrainement.class, Exercice.class, Utilisateur.class, Nutrition.class},version=12,exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract EntrainementDao getEntrainementDao();
    public abstract ExerciceDao getExerciceDao();
    public abstract UtilisateurDao getUtilisateurDao();
    public abstract NutritionDao getNutritionDao();
    /**
     * Retourne une instance de la base de données
     * @param context
     * @return
     */
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "MyDatabase.db")
                            .addCallback(prepopulateDatabase())
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                ContentValues contentValues = new ContentValues();
                contentValues.put("id_utilisateur", 1);
                contentValues.put("age_utilisateur", 0);
                contentValues.put("poids_utilisateur", 0.0);
                contentValues.put("taille_utilisateur", 0.0);
                contentValues.put("masse_musculaire", 0.0);
                contentValues.put("masse_graisseuse", 0.0);
                contentValues.put("mensuration_biceps", 0.0);
                contentValues.put("mensuration_avant_bras", 0.0);
                contentValues.put("mensuration_poitrine", 0.0);
                contentValues.put("mensuration_epaules", 0.0);
                contentValues.put("mensuration_cou", 0.0);
                contentValues.put("mensuration_tour_de_taille", 0.0);
                contentValues.put("mensuration_cuisses", 0.0);
                contentValues.put("mensuration_mollets", 0.0);
                db.insert("Utilisateur", OnConflictStrategy.IGNORE, contentValues);
            }
        };
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
