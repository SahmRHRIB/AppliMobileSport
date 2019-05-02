package com.example.PJS4.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.PJS4.Entrainement.Exercice;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ExerciceDao_Impl implements ExerciceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfExercice;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfExercice;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfExercice;

  public ExerciceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExercice = new EntityInsertionAdapter<Exercice>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Exercice`(`id_exercice`,`id_entrainement`,`nom_exercice`,`nb_series`,`nb_repet`,`temps_repos`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Exercice value) {
        if (value.getId_exercice() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_exercice());
        }
        if (value.getId_entrainement() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId_entrainement());
        }
        if (value.getNom_exercice() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNom_exercice());
        }
        stmt.bindLong(4, value.getNb_series());
        stmt.bindLong(5, value.getNb_repet());
        stmt.bindLong(6, value.getTemps_repos());
      }
    };
    this.__deletionAdapterOfExercice = new EntityDeletionOrUpdateAdapter<Exercice>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Exercice` WHERE `id_exercice` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Exercice value) {
        if (value.getId_exercice() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_exercice());
        }
      }
    };
    this.__updateAdapterOfExercice = new EntityDeletionOrUpdateAdapter<Exercice>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Exercice` SET `id_exercice` = ?,`id_entrainement` = ?,`nom_exercice` = ?,`nb_series` = ?,`nb_repet` = ?,`temps_repos` = ? WHERE `id_exercice` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Exercice value) {
        if (value.getId_exercice() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_exercice());
        }
        if (value.getId_entrainement() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getId_entrainement());
        }
        if (value.getNom_exercice() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNom_exercice());
        }
        stmt.bindLong(4, value.getNb_series());
        stmt.bindLong(5, value.getNb_repet());
        stmt.bindLong(6, value.getTemps_repos());
        if (value.getId_exercice() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId_exercice());
        }
      }
    };
  }

  @Override
  public void createExercice(Exercice exercice) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfExercice.insert(exercice);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Exercice exercice) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfExercice.handle(exercice);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Exercice exercice) {
    __db.beginTransaction();
    try {
      __updateAdapterOfExercice.handle(exercice);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Exercice> getAllExercices(Integer idEntrainement) {
    final String _sql = "SELECT * FROM Exercice WHERE id_entrainement = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idEntrainement == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idEntrainement);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdExercice = _cursor.getColumnIndexOrThrow("id_exercice");
      final int _cursorIndexOfIdEntrainement = _cursor.getColumnIndexOrThrow("id_entrainement");
      final int _cursorIndexOfNomExercice = _cursor.getColumnIndexOrThrow("nom_exercice");
      final int _cursorIndexOfNbSeries = _cursor.getColumnIndexOrThrow("nb_series");
      final int _cursorIndexOfNbRepet = _cursor.getColumnIndexOrThrow("nb_repet");
      final int _cursorIndexOfTempsRepos = _cursor.getColumnIndexOrThrow("temps_repos");
      final List<Exercice> _result = new ArrayList<Exercice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Exercice _item;
        final Integer _tmpId_entrainement;
        if (_cursor.isNull(_cursorIndexOfIdEntrainement)) {
          _tmpId_entrainement = null;
        } else {
          _tmpId_entrainement = _cursor.getInt(_cursorIndexOfIdEntrainement);
        }
        final String _tmpNom_exercice;
        _tmpNom_exercice = _cursor.getString(_cursorIndexOfNomExercice);
        final int _tmpNb_series;
        _tmpNb_series = _cursor.getInt(_cursorIndexOfNbSeries);
        final int _tmpNb_repet;
        _tmpNb_repet = _cursor.getInt(_cursorIndexOfNbRepet);
        final int _tmpTemps_repos;
        _tmpTemps_repos = _cursor.getInt(_cursorIndexOfTempsRepos);
        _item = new Exercice(_tmpNom_exercice,_tmpNb_series,_tmpNb_repet,_tmpTemps_repos,_tmpId_entrainement);
        final Integer _tmpId_exercice;
        if (_cursor.isNull(_cursorIndexOfIdExercice)) {
          _tmpId_exercice = null;
        } else {
          _tmpId_exercice = _cursor.getInt(_cursorIndexOfIdExercice);
        }
        _item.setId_exercice(_tmpId_exercice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getNbExercices(Integer idEntrainement) {
    final String _sql = "SELECT *, COUNT(*) FROM Exercice WHERE id_entrainement = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idEntrainement == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idEntrainement);
    }
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
  public Exercice getExercice(Integer idExercice) {
    final String _sql = "SELECT * FROM Exercice WHERE id_exercice = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idExercice == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idExercice);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdExercice = _cursor.getColumnIndexOrThrow("id_exercice");
      final int _cursorIndexOfIdEntrainement = _cursor.getColumnIndexOrThrow("id_entrainement");
      final int _cursorIndexOfNomExercice = _cursor.getColumnIndexOrThrow("nom_exercice");
      final int _cursorIndexOfNbSeries = _cursor.getColumnIndexOrThrow("nb_series");
      final int _cursorIndexOfNbRepet = _cursor.getColumnIndexOrThrow("nb_repet");
      final int _cursorIndexOfTempsRepos = _cursor.getColumnIndexOrThrow("temps_repos");
      final Exercice _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmpId_entrainement;
        if (_cursor.isNull(_cursorIndexOfIdEntrainement)) {
          _tmpId_entrainement = null;
        } else {
          _tmpId_entrainement = _cursor.getInt(_cursorIndexOfIdEntrainement);
        }
        final String _tmpNom_exercice;
        _tmpNom_exercice = _cursor.getString(_cursorIndexOfNomExercice);
        final int _tmpNb_series;
        _tmpNb_series = _cursor.getInt(_cursorIndexOfNbSeries);
        final int _tmpNb_repet;
        _tmpNb_repet = _cursor.getInt(_cursorIndexOfNbRepet);
        final int _tmpTemps_repos;
        _tmpTemps_repos = _cursor.getInt(_cursorIndexOfTempsRepos);
        _result = new Exercice(_tmpNom_exercice,_tmpNb_series,_tmpNb_repet,_tmpTemps_repos,_tmpId_entrainement);
        final Integer _tmpId_exercice;
        if (_cursor.isNull(_cursorIndexOfIdExercice)) {
          _tmpId_exercice = null;
        } else {
          _tmpId_exercice = _cursor.getInt(_cursorIndexOfIdExercice);
        }
        _result.setId_exercice(_tmpId_exercice);
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
