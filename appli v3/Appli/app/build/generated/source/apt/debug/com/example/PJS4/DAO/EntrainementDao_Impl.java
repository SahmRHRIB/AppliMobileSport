package com.example.PJS4.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.PJS4.Entrainement.Entrainement;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class EntrainementDao_Impl implements EntrainementDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEntrainement;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfEntrainement;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfEntrainement;

  public EntrainementDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntrainement = new EntityInsertionAdapter<Entrainement>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Entrainement`(`id_entrainement`,`nom_entrainement`,`com_entrainement`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entrainement value) {
        if (value.getId_entrainement() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_entrainement());
        }
        if (value.getNom_entrainement() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNom_entrainement());
        }
        if (value.getCom_entrainement() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCom_entrainement());
        }
      }
    };
    this.__deletionAdapterOfEntrainement = new EntityDeletionOrUpdateAdapter<Entrainement>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Entrainement` WHERE `id_entrainement` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entrainement value) {
        if (value.getId_entrainement() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_entrainement());
        }
      }
    };
    this.__updateAdapterOfEntrainement = new EntityDeletionOrUpdateAdapter<Entrainement>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Entrainement` SET `id_entrainement` = ?,`nom_entrainement` = ?,`com_entrainement` = ? WHERE `id_entrainement` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entrainement value) {
        if (value.getId_entrainement() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId_entrainement());
        }
        if (value.getNom_entrainement() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNom_entrainement());
        }
        if (value.getCom_entrainement() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCom_entrainement());
        }
        if (value.getId_entrainement() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId_entrainement());
        }
      }
    };
  }

  @Override
  public void createEntrainement(Entrainement entrainement) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEntrainement.insert(entrainement);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Entrainement entrainement) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfEntrainement.handle(entrainement);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Entrainement entrainement) {
    __db.beginTransaction();
    try {
      __updateAdapterOfEntrainement.handle(entrainement);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Entrainement getEntrainement(Integer idEntrainement) {
    final String _sql = "SELECT nom_entrainement, com_entrainement FROM Entrainement WHERE id_entrainement LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idEntrainement == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idEntrainement);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNomEntrainement = _cursor.getColumnIndexOrThrow("nom_entrainement");
      final int _cursorIndexOfComEntrainement = _cursor.getColumnIndexOrThrow("com_entrainement");
      final Entrainement _result;
      if(_cursor.moveToFirst()) {
        final String _tmpNom_entrainement;
        _tmpNom_entrainement = _cursor.getString(_cursorIndexOfNomEntrainement);
        final String _tmpCom_entrainement;
        _tmpCom_entrainement = _cursor.getString(_cursorIndexOfComEntrainement);
        _result = new Entrainement(_tmpNom_entrainement,_tmpCom_entrainement);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Entrainement> getAllEntrainements() {
    final String _sql = "SELECT * FROM Entrainement";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdEntrainement = _cursor.getColumnIndexOrThrow("id_entrainement");
      final int _cursorIndexOfNomEntrainement = _cursor.getColumnIndexOrThrow("nom_entrainement");
      final int _cursorIndexOfComEntrainement = _cursor.getColumnIndexOrThrow("com_entrainement");
      final List<Entrainement> _result = new ArrayList<Entrainement>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Entrainement _item;
        final String _tmpNom_entrainement;
        _tmpNom_entrainement = _cursor.getString(_cursorIndexOfNomEntrainement);
        final String _tmpCom_entrainement;
        _tmpCom_entrainement = _cursor.getString(_cursorIndexOfComEntrainement);
        _item = new Entrainement(_tmpNom_entrainement,_tmpCom_entrainement);
        final Integer _tmpId_entrainement;
        if (_cursor.isNull(_cursorIndexOfIdEntrainement)) {
          _tmpId_entrainement = null;
        } else {
          _tmpId_entrainement = _cursor.getInt(_cursorIndexOfIdEntrainement);
        }
        _item.setId_entrainement(_tmpId_entrainement);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
