package com.example.PJS4.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.PJS4.Utilisateur.Utilisateur;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class UtilisateurDao_Impl implements UtilisateurDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUtilisateur;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUtilisateur;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUtilisateur;

  private final SharedSQLiteStatement __preparedStmtOfSetEtats;

  public UtilisateurDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUtilisateur = new EntityInsertionAdapter<Utilisateur>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Utilisateur`(`id_utilisateur`,`age_utilisateur`,`poids_utilisateur`,`taille_utilisateur`,`masse_musculaire`,`masse_graisseuse`,`mensuration_biceps`,`mensuration_avant_bras`,`mensuration_poitrine`,`mensuration_epaules`,`mensuration_cou`,`mensuration_tour_de_taille`,`mensuration_cuisses`,`mensuration_mollets`,`etats_utilisateur`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Utilisateur value) {
        stmt.bindLong(1, value.getId_utilisateur());
        stmt.bindLong(2, value.getAge_utilisateur());
        stmt.bindDouble(3, value.getPoids_utilisateur());
        stmt.bindDouble(4, value.getTaille_utilisateur());
        stmt.bindDouble(5, value.getMasse_musculaire());
        stmt.bindDouble(6, value.getMasse_graisseuse());
        stmt.bindDouble(7, value.getMensuration_biceps());
        stmt.bindDouble(8, value.getMensuration_avant_bras());
        stmt.bindDouble(9, value.getMensuration_poitrine());
        stmt.bindDouble(10, value.getMensuration_epaules());
        stmt.bindDouble(11, value.getMensuration_cou());
        stmt.bindDouble(12, value.getMensuration_tour_de_taille());
        stmt.bindDouble(13, value.getMensuration_cuisses());
        stmt.bindDouble(14, value.getMensuration_mollets());
        final String _tmp;
        _tmp = Converters.fromArrayList(value.getEtats_utilisateur());
        if (_tmp == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp);
        }
      }
    };
    this.__deletionAdapterOfUtilisateur = new EntityDeletionOrUpdateAdapter<Utilisateur>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Utilisateur` WHERE `id_utilisateur` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Utilisateur value) {
        stmt.bindLong(1, value.getId_utilisateur());
      }
    };
    this.__updateAdapterOfUtilisateur = new EntityDeletionOrUpdateAdapter<Utilisateur>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Utilisateur` SET `id_utilisateur` = ?,`age_utilisateur` = ?,`poids_utilisateur` = ?,`taille_utilisateur` = ?,`masse_musculaire` = ?,`masse_graisseuse` = ?,`mensuration_biceps` = ?,`mensuration_avant_bras` = ?,`mensuration_poitrine` = ?,`mensuration_epaules` = ?,`mensuration_cou` = ?,`mensuration_tour_de_taille` = ?,`mensuration_cuisses` = ?,`mensuration_mollets` = ?,`etats_utilisateur` = ? WHERE `id_utilisateur` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Utilisateur value) {
        stmt.bindLong(1, value.getId_utilisateur());
        stmt.bindLong(2, value.getAge_utilisateur());
        stmt.bindDouble(3, value.getPoids_utilisateur());
        stmt.bindDouble(4, value.getTaille_utilisateur());
        stmt.bindDouble(5, value.getMasse_musculaire());
        stmt.bindDouble(6, value.getMasse_graisseuse());
        stmt.bindDouble(7, value.getMensuration_biceps());
        stmt.bindDouble(8, value.getMensuration_avant_bras());
        stmt.bindDouble(9, value.getMensuration_poitrine());
        stmt.bindDouble(10, value.getMensuration_epaules());
        stmt.bindDouble(11, value.getMensuration_cou());
        stmt.bindDouble(12, value.getMensuration_tour_de_taille());
        stmt.bindDouble(13, value.getMensuration_cuisses());
        stmt.bindDouble(14, value.getMensuration_mollets());
        final String _tmp;
        _tmp = Converters.fromArrayList(value.getEtats_utilisateur());
        if (_tmp == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp);
        }
        stmt.bindLong(16, value.getId_utilisateur());
      }
    };
    this.__preparedStmtOfSetEtats = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Utilisateur SET etats_utilisateur = ?";
        return _query;
      }
    };
  }

  @Override
  public void createUtilisateur(Utilisateur utilisateur) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUtilisateur.insert(utilisateur);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Utilisateur utilisateur) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUtilisateur.handle(utilisateur);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Utilisateur utilisateur) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUtilisateur.handle(utilisateur);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void setEtats(ArrayList<Utilisateur> utilisateurs) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetEtats.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final String _tmp;
      _tmp = Converters.fromArrayList(utilisateurs);
      if (_tmp == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _tmp);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetEtats.release(_stmt);
    }
  }

  @Override
  public int getAge() {
    final String _sql = "SELECT age_utilisateur FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getPoids() {
    final String _sql = "SELECT poids_utilisateur FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getTaille() {
    final String _sql = "SELECT taille_utilisateur FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMasseM() {
    final String _sql = "SELECT masse_musculaire FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMasseG() {
    final String _sql = "SELECT masse_graisseuse FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMbiceps() {
    final String _sql = "SELECT mensuration_biceps FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMavantBras() {
    final String _sql = "SELECT mensuration_avant_bras FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMpoitrine() {
    final String _sql = "SELECT mensuration_poitrine FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMepaules() {
    final String _sql = "SELECT mensuration_epaules FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMcou() {
    final String _sql = "SELECT mensuration_cou FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMtourTaille() {
    final String _sql = "SELECT mensuration_tour_de_taille FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMcuisses() {
    final String _sql = "SELECT mensuration_cuisses FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public float getMmollets() {
    final String _sql = "SELECT mensuration_mollets FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final float _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getFloat(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Utilisateur> getEtats() {
    final String _sql = "SELECT etats_utilisateur, * FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfEtatsUtilisateur = _cursor.getColumnIndexOrThrow("etats_utilisateur");
      final int _cursorIndexOfIdUtilisateur = _cursor.getColumnIndexOrThrow("id_utilisateur");
      final int _cursorIndexOfAgeUtilisateur = _cursor.getColumnIndexOrThrow("age_utilisateur");
      final int _cursorIndexOfPoidsUtilisateur = _cursor.getColumnIndexOrThrow("poids_utilisateur");
      final int _cursorIndexOfTailleUtilisateur = _cursor.getColumnIndexOrThrow("taille_utilisateur");
      final int _cursorIndexOfMasseMusculaire = _cursor.getColumnIndexOrThrow("masse_musculaire");
      final int _cursorIndexOfMasseGraisseuse = _cursor.getColumnIndexOrThrow("masse_graisseuse");
      final int _cursorIndexOfMensurationBiceps = _cursor.getColumnIndexOrThrow("mensuration_biceps");
      final int _cursorIndexOfMensurationAvantBras = _cursor.getColumnIndexOrThrow("mensuration_avant_bras");
      final int _cursorIndexOfMensurationPoitrine = _cursor.getColumnIndexOrThrow("mensuration_poitrine");
      final int _cursorIndexOfMensurationEpaules = _cursor.getColumnIndexOrThrow("mensuration_epaules");
      final int _cursorIndexOfMensurationCou = _cursor.getColumnIndexOrThrow("mensuration_cou");
      final int _cursorIndexOfMensurationTourDeTaille = _cursor.getColumnIndexOrThrow("mensuration_tour_de_taille");
      final int _cursorIndexOfMensurationCuisses = _cursor.getColumnIndexOrThrow("mensuration_cuisses");
      final int _cursorIndexOfMensurationMollets = _cursor.getColumnIndexOrThrow("mensuration_mollets");
      final int _cursorIndexOfEtatsUtilisateur_1 = _cursor.getColumnIndexOrThrow("etats_utilisateur");
      final List<Utilisateur> _result = new ArrayList<Utilisateur>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Utilisateur _item;
        final int _tmpAge_utilisateur;
        _tmpAge_utilisateur = _cursor.getInt(_cursorIndexOfAgeUtilisateur);
        final float _tmpPoids_utilisateur;
        _tmpPoids_utilisateur = _cursor.getFloat(_cursorIndexOfPoidsUtilisateur);
        final float _tmpTaille_utilisateur;
        _tmpTaille_utilisateur = _cursor.getFloat(_cursorIndexOfTailleUtilisateur);
        _item = new Utilisateur(_tmpAge_utilisateur,_tmpPoids_utilisateur,_tmpTaille_utilisateur);
        final ArrayList<Utilisateur> _tmpEtats_utilisateur;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfEtatsUtilisateur);
        _tmpEtats_utilisateur = Converters.fromString(_tmp);
        _item.setEtats_utilisateur(_tmpEtats_utilisateur);
        final long _tmpId_utilisateur;
        _tmpId_utilisateur = _cursor.getLong(_cursorIndexOfIdUtilisateur);
        _item.setId_utilisateur(_tmpId_utilisateur);
        final float _tmpMasse_musculaire;
        _tmpMasse_musculaire = _cursor.getFloat(_cursorIndexOfMasseMusculaire);
        _item.setMasse_musculaire(_tmpMasse_musculaire);
        final float _tmpMasse_graisseuse;
        _tmpMasse_graisseuse = _cursor.getFloat(_cursorIndexOfMasseGraisseuse);
        _item.setMasse_graisseuse(_tmpMasse_graisseuse);
        final float _tmpMensuration_biceps;
        _tmpMensuration_biceps = _cursor.getFloat(_cursorIndexOfMensurationBiceps);
        _item.setMensuration_biceps(_tmpMensuration_biceps);
        final float _tmpMensuration_avant_bras;
        _tmpMensuration_avant_bras = _cursor.getFloat(_cursorIndexOfMensurationAvantBras);
        _item.setMensuration_avant_bras(_tmpMensuration_avant_bras);
        final float _tmpMensuration_poitrine;
        _tmpMensuration_poitrine = _cursor.getFloat(_cursorIndexOfMensurationPoitrine);
        _item.setMensuration_poitrine(_tmpMensuration_poitrine);
        final float _tmpMensuration_epaules;
        _tmpMensuration_epaules = _cursor.getFloat(_cursorIndexOfMensurationEpaules);
        _item.setMensuration_epaules(_tmpMensuration_epaules);
        final float _tmpMensuration_cou;
        _tmpMensuration_cou = _cursor.getFloat(_cursorIndexOfMensurationCou);
        _item.setMensuration_cou(_tmpMensuration_cou);
        final float _tmpMensuration_tour_de_taille;
        _tmpMensuration_tour_de_taille = _cursor.getFloat(_cursorIndexOfMensurationTourDeTaille);
        _item.setMensuration_tour_de_taille(_tmpMensuration_tour_de_taille);
        final float _tmpMensuration_cuisses;
        _tmpMensuration_cuisses = _cursor.getFloat(_cursorIndexOfMensurationCuisses);
        _item.setMensuration_cuisses(_tmpMensuration_cuisses);
        final float _tmpMensuration_mollets;
        _tmpMensuration_mollets = _cursor.getFloat(_cursorIndexOfMensurationMollets);
        _item.setMensuration_mollets(_tmpMensuration_mollets);
        final ArrayList<Utilisateur> _tmpEtats_utilisateur_1;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfEtatsUtilisateur_1);
        _tmpEtats_utilisateur_1 = Converters.fromString(_tmp_1);
        _item.setEtats_utilisateur(_tmpEtats_utilisateur_1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Utilisateur getUtilisateur() {
    final String _sql = "SELECT * FROM Utilisateur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdUtilisateur = _cursor.getColumnIndexOrThrow("id_utilisateur");
      final int _cursorIndexOfAgeUtilisateur = _cursor.getColumnIndexOrThrow("age_utilisateur");
      final int _cursorIndexOfPoidsUtilisateur = _cursor.getColumnIndexOrThrow("poids_utilisateur");
      final int _cursorIndexOfTailleUtilisateur = _cursor.getColumnIndexOrThrow("taille_utilisateur");
      final int _cursorIndexOfMasseMusculaire = _cursor.getColumnIndexOrThrow("masse_musculaire");
      final int _cursorIndexOfMasseGraisseuse = _cursor.getColumnIndexOrThrow("masse_graisseuse");
      final int _cursorIndexOfMensurationBiceps = _cursor.getColumnIndexOrThrow("mensuration_biceps");
      final int _cursorIndexOfMensurationAvantBras = _cursor.getColumnIndexOrThrow("mensuration_avant_bras");
      final int _cursorIndexOfMensurationPoitrine = _cursor.getColumnIndexOrThrow("mensuration_poitrine");
      final int _cursorIndexOfMensurationEpaules = _cursor.getColumnIndexOrThrow("mensuration_epaules");
      final int _cursorIndexOfMensurationCou = _cursor.getColumnIndexOrThrow("mensuration_cou");
      final int _cursorIndexOfMensurationTourDeTaille = _cursor.getColumnIndexOrThrow("mensuration_tour_de_taille");
      final int _cursorIndexOfMensurationCuisses = _cursor.getColumnIndexOrThrow("mensuration_cuisses");
      final int _cursorIndexOfMensurationMollets = _cursor.getColumnIndexOrThrow("mensuration_mollets");
      final int _cursorIndexOfEtatsUtilisateur = _cursor.getColumnIndexOrThrow("etats_utilisateur");
      final Utilisateur _result;
      if(_cursor.moveToFirst()) {
        final int _tmpAge_utilisateur;
        _tmpAge_utilisateur = _cursor.getInt(_cursorIndexOfAgeUtilisateur);
        final float _tmpPoids_utilisateur;
        _tmpPoids_utilisateur = _cursor.getFloat(_cursorIndexOfPoidsUtilisateur);
        final float _tmpTaille_utilisateur;
        _tmpTaille_utilisateur = _cursor.getFloat(_cursorIndexOfTailleUtilisateur);
        _result = new Utilisateur(_tmpAge_utilisateur,_tmpPoids_utilisateur,_tmpTaille_utilisateur);
        final long _tmpId_utilisateur;
        _tmpId_utilisateur = _cursor.getLong(_cursorIndexOfIdUtilisateur);
        _result.setId_utilisateur(_tmpId_utilisateur);
        final float _tmpMasse_musculaire;
        _tmpMasse_musculaire = _cursor.getFloat(_cursorIndexOfMasseMusculaire);
        _result.setMasse_musculaire(_tmpMasse_musculaire);
        final float _tmpMasse_graisseuse;
        _tmpMasse_graisseuse = _cursor.getFloat(_cursorIndexOfMasseGraisseuse);
        _result.setMasse_graisseuse(_tmpMasse_graisseuse);
        final float _tmpMensuration_biceps;
        _tmpMensuration_biceps = _cursor.getFloat(_cursorIndexOfMensurationBiceps);
        _result.setMensuration_biceps(_tmpMensuration_biceps);
        final float _tmpMensuration_avant_bras;
        _tmpMensuration_avant_bras = _cursor.getFloat(_cursorIndexOfMensurationAvantBras);
        _result.setMensuration_avant_bras(_tmpMensuration_avant_bras);
        final float _tmpMensuration_poitrine;
        _tmpMensuration_poitrine = _cursor.getFloat(_cursorIndexOfMensurationPoitrine);
        _result.setMensuration_poitrine(_tmpMensuration_poitrine);
        final float _tmpMensuration_epaules;
        _tmpMensuration_epaules = _cursor.getFloat(_cursorIndexOfMensurationEpaules);
        _result.setMensuration_epaules(_tmpMensuration_epaules);
        final float _tmpMensuration_cou;
        _tmpMensuration_cou = _cursor.getFloat(_cursorIndexOfMensurationCou);
        _result.setMensuration_cou(_tmpMensuration_cou);
        final float _tmpMensuration_tour_de_taille;
        _tmpMensuration_tour_de_taille = _cursor.getFloat(_cursorIndexOfMensurationTourDeTaille);
        _result.setMensuration_tour_de_taille(_tmpMensuration_tour_de_taille);
        final float _tmpMensuration_cuisses;
        _tmpMensuration_cuisses = _cursor.getFloat(_cursorIndexOfMensurationCuisses);
        _result.setMensuration_cuisses(_tmpMensuration_cuisses);
        final float _tmpMensuration_mollets;
        _tmpMensuration_mollets = _cursor.getFloat(_cursorIndexOfMensurationMollets);
        _result.setMensuration_mollets(_tmpMensuration_mollets);
        final ArrayList<Utilisateur> _tmpEtats_utilisateur;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfEtatsUtilisateur);
        _tmpEtats_utilisateur = Converters.fromString(_tmp);
        _result.setEtats_utilisateur(_tmpEtats_utilisateur);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
