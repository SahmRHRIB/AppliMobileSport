package com.example.PJS4;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.example.PJS4.DAO.EntrainementDao;
import com.example.PJS4.DAO.EntrainementDao_Impl;
import com.example.PJS4.DAO.ExerciceDao;
import com.example.PJS4.DAO.ExerciceDao_Impl;
import com.example.PJS4.DAO.NutritionDao;
import com.example.PJS4.DAO.NutritionDao_Impl;
import com.example.PJS4.DAO.UtilisateurDao;
import com.example.PJS4.DAO.UtilisateurDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDatabase_Impl extends AppDatabase {
  private volatile EntrainementDao _entrainementDao;

  private volatile ExerciceDao _exerciceDao;

  private volatile UtilisateurDao _utilisateurDao;

  private volatile NutritionDao _nutritionDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(12) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Entrainement` (`id_entrainement` INTEGER PRIMARY KEY AUTOINCREMENT, `nom_entrainement` TEXT, `com_entrainement` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Exercice` (`id_exercice` INTEGER PRIMARY KEY AUTOINCREMENT, `id_entrainement` INTEGER, `nom_exercice` TEXT, `nb_series` INTEGER NOT NULL, `nb_repet` INTEGER NOT NULL, `temps_repos` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Utilisateur` (`id_utilisateur` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `age_utilisateur` INTEGER NOT NULL, `poids_utilisateur` REAL NOT NULL, `taille_utilisateur` REAL NOT NULL, `masse_musculaire` REAL NOT NULL, `masse_graisseuse` REAL NOT NULL, `mensuration_biceps` REAL NOT NULL, `mensuration_avant_bras` REAL NOT NULL, `mensuration_poitrine` REAL NOT NULL, `mensuration_epaules` REAL NOT NULL, `mensuration_cou` REAL NOT NULL, `mensuration_tour_de_taille` REAL NOT NULL, `mensuration_cuisses` REAL NOT NULL, `mensuration_mollets` REAL NOT NULL, `etats_utilisateur` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Nutrition` (`idRepas` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date_repas` TEXT, `petit_dejeuner` TEXT, `dejeuner` TEXT, `diner` TEXT, `complement` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"5b19129488478637a3a3a92e9521159b\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Entrainement`");
        _db.execSQL("DROP TABLE IF EXISTS `Exercice`");
        _db.execSQL("DROP TABLE IF EXISTS `Utilisateur`");
        _db.execSQL("DROP TABLE IF EXISTS `Nutrition`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEntrainement = new HashMap<String, TableInfo.Column>(3);
        _columnsEntrainement.put("id_entrainement", new TableInfo.Column("id_entrainement", "INTEGER", false, 1));
        _columnsEntrainement.put("nom_entrainement", new TableInfo.Column("nom_entrainement", "TEXT", false, 0));
        _columnsEntrainement.put("com_entrainement", new TableInfo.Column("com_entrainement", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEntrainement = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEntrainement = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEntrainement = new TableInfo("Entrainement", _columnsEntrainement, _foreignKeysEntrainement, _indicesEntrainement);
        final TableInfo _existingEntrainement = TableInfo.read(_db, "Entrainement");
        if (! _infoEntrainement.equals(_existingEntrainement)) {
          throw new IllegalStateException("Migration didn't properly handle Entrainement(com.example.PJS4.Entrainement.Entrainement).\n"
                  + " Expected:\n" + _infoEntrainement + "\n"
                  + " Found:\n" + _existingEntrainement);
        }
        final HashMap<String, TableInfo.Column> _columnsExercice = new HashMap<String, TableInfo.Column>(6);
        _columnsExercice.put("id_exercice", new TableInfo.Column("id_exercice", "INTEGER", false, 1));
        _columnsExercice.put("id_entrainement", new TableInfo.Column("id_entrainement", "INTEGER", false, 0));
        _columnsExercice.put("nom_exercice", new TableInfo.Column("nom_exercice", "TEXT", false, 0));
        _columnsExercice.put("nb_series", new TableInfo.Column("nb_series", "INTEGER", true, 0));
        _columnsExercice.put("nb_repet", new TableInfo.Column("nb_repet", "INTEGER", true, 0));
        _columnsExercice.put("temps_repos", new TableInfo.Column("temps_repos", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExercice = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExercice = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExercice = new TableInfo("Exercice", _columnsExercice, _foreignKeysExercice, _indicesExercice);
        final TableInfo _existingExercice = TableInfo.read(_db, "Exercice");
        if (! _infoExercice.equals(_existingExercice)) {
          throw new IllegalStateException("Migration didn't properly handle Exercice(com.example.PJS4.Entrainement.Exercice).\n"
                  + " Expected:\n" + _infoExercice + "\n"
                  + " Found:\n" + _existingExercice);
        }
        final HashMap<String, TableInfo.Column> _columnsUtilisateur = new HashMap<String, TableInfo.Column>(15);
        _columnsUtilisateur.put("id_utilisateur", new TableInfo.Column("id_utilisateur", "INTEGER", true, 1));
        _columnsUtilisateur.put("age_utilisateur", new TableInfo.Column("age_utilisateur", "INTEGER", true, 0));
        _columnsUtilisateur.put("poids_utilisateur", new TableInfo.Column("poids_utilisateur", "REAL", true, 0));
        _columnsUtilisateur.put("taille_utilisateur", new TableInfo.Column("taille_utilisateur", "REAL", true, 0));
        _columnsUtilisateur.put("masse_musculaire", new TableInfo.Column("masse_musculaire", "REAL", true, 0));
        _columnsUtilisateur.put("masse_graisseuse", new TableInfo.Column("masse_graisseuse", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_biceps", new TableInfo.Column("mensuration_biceps", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_avant_bras", new TableInfo.Column("mensuration_avant_bras", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_poitrine", new TableInfo.Column("mensuration_poitrine", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_epaules", new TableInfo.Column("mensuration_epaules", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_cou", new TableInfo.Column("mensuration_cou", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_tour_de_taille", new TableInfo.Column("mensuration_tour_de_taille", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_cuisses", new TableInfo.Column("mensuration_cuisses", "REAL", true, 0));
        _columnsUtilisateur.put("mensuration_mollets", new TableInfo.Column("mensuration_mollets", "REAL", true, 0));
        _columnsUtilisateur.put("etats_utilisateur", new TableInfo.Column("etats_utilisateur", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUtilisateur = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUtilisateur = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUtilisateur = new TableInfo("Utilisateur", _columnsUtilisateur, _foreignKeysUtilisateur, _indicesUtilisateur);
        final TableInfo _existingUtilisateur = TableInfo.read(_db, "Utilisateur");
        if (! _infoUtilisateur.equals(_existingUtilisateur)) {
          throw new IllegalStateException("Migration didn't properly handle Utilisateur(com.example.PJS4.Utilisateur.Utilisateur).\n"
                  + " Expected:\n" + _infoUtilisateur + "\n"
                  + " Found:\n" + _existingUtilisateur);
        }
        final HashMap<String, TableInfo.Column> _columnsNutrition = new HashMap<String, TableInfo.Column>(6);
        _columnsNutrition.put("idRepas", new TableInfo.Column("idRepas", "INTEGER", true, 1));
        _columnsNutrition.put("date_repas", new TableInfo.Column("date_repas", "TEXT", false, 0));
        _columnsNutrition.put("petit_dejeuner", new TableInfo.Column("petit_dejeuner", "TEXT", false, 0));
        _columnsNutrition.put("dejeuner", new TableInfo.Column("dejeuner", "TEXT", false, 0));
        _columnsNutrition.put("diner", new TableInfo.Column("diner", "TEXT", false, 0));
        _columnsNutrition.put("complement", new TableInfo.Column("complement", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNutrition = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNutrition = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNutrition = new TableInfo("Nutrition", _columnsNutrition, _foreignKeysNutrition, _indicesNutrition);
        final TableInfo _existingNutrition = TableInfo.read(_db, "Nutrition");
        if (! _infoNutrition.equals(_existingNutrition)) {
          throw new IllegalStateException("Migration didn't properly handle Nutrition(com.example.PJS4.Entrainement.Nutrition).\n"
                  + " Expected:\n" + _infoNutrition + "\n"
                  + " Found:\n" + _existingNutrition);
        }
      }
    }, "5b19129488478637a3a3a92e9521159b", "061ced8a3c14165f3c5d338d9f73a034");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Entrainement","Exercice","Utilisateur","Nutrition");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Entrainement`");
      _db.execSQL("DELETE FROM `Exercice`");
      _db.execSQL("DELETE FROM `Utilisateur`");
      _db.execSQL("DELETE FROM `Nutrition`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public EntrainementDao getEntrainementDao() {
    if (_entrainementDao != null) {
      return _entrainementDao;
    } else {
      synchronized(this) {
        if(_entrainementDao == null) {
          _entrainementDao = new EntrainementDao_Impl(this);
        }
        return _entrainementDao;
      }
    }
  }

  @Override
  public ExerciceDao getExerciceDao() {
    if (_exerciceDao != null) {
      return _exerciceDao;
    } else {
      synchronized(this) {
        if(_exerciceDao == null) {
          _exerciceDao = new ExerciceDao_Impl(this);
        }
        return _exerciceDao;
      }
    }
  }

  @Override
  public UtilisateurDao getUtilisateurDao() {
    if (_utilisateurDao != null) {
      return _utilisateurDao;
    } else {
      synchronized(this) {
        if(_utilisateurDao == null) {
          _utilisateurDao = new UtilisateurDao_Impl(this);
        }
        return _utilisateurDao;
      }
    }
  }

  @Override
  public NutritionDao getNutritionDao() {
    if (_nutritionDao != null) {
      return _nutritionDao;
    } else {
      synchronized(this) {
        if(_nutritionDao == null) {
          _nutritionDao = new NutritionDao_Impl(this);
        }
        return _nutritionDao;
      }
    }
  }
}
