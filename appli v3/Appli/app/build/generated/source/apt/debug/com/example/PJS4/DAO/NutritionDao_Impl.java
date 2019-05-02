package com.example.PJS4.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.PJS4.Entrainement.Nutrition;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class NutritionDao_Impl implements NutritionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfNutrition;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfNutrition;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfNutrition;

  public NutritionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNutrition = new EntityInsertionAdapter<Nutrition>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Nutrition`(`idRepas`,`date_repas`,`petit_dejeuner`,`dejeuner`,`diner`,`complement`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Nutrition value) {
        stmt.bindLong(1, value.getIdRepas());
        if (value.getDate_repas() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate_repas());
        }
        if (value.getPetit_dejeuner() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPetit_dejeuner());
        }
        if (value.getDejeuner() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDejeuner());
        }
        if (value.getDiner() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDiner());
        }
        if (value.getComplement() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getComplement());
        }
      }
    };
    this.__deletionAdapterOfNutrition = new EntityDeletionOrUpdateAdapter<Nutrition>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Nutrition` WHERE `idRepas` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Nutrition value) {
        stmt.bindLong(1, value.getIdRepas());
      }
    };
    this.__updateAdapterOfNutrition = new EntityDeletionOrUpdateAdapter<Nutrition>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Nutrition` SET `idRepas` = ?,`date_repas` = ?,`petit_dejeuner` = ?,`dejeuner` = ?,`diner` = ?,`complement` = ? WHERE `idRepas` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Nutrition value) {
        stmt.bindLong(1, value.getIdRepas());
        if (value.getDate_repas() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate_repas());
        }
        if (value.getPetit_dejeuner() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPetit_dejeuner());
        }
        if (value.getDejeuner() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDejeuner());
        }
        if (value.getDiner() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDiner());
        }
        if (value.getComplement() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getComplement());
        }
        stmt.bindLong(7, value.getIdRepas());
      }
    };
  }

  @Override
  public void createRepas(Nutrition nutrition) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfNutrition.insert(nutrition);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Nutrition nutrition) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfNutrition.handle(nutrition);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Nutrition nutrition) {
    __db.beginTransaction();
    try {
      __updateAdapterOfNutrition.handle(nutrition);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Nutrition> getAllRepas(String date_repas) {
    final String _sql = "SELECT * FROM Nutrition WHERE date_repas = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date_repas == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date_repas);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdRepas = _cursor.getColumnIndexOrThrow("idRepas");
      final int _cursorIndexOfDateRepas = _cursor.getColumnIndexOrThrow("date_repas");
      final int _cursorIndexOfPetitDejeuner = _cursor.getColumnIndexOrThrow("petit_dejeuner");
      final int _cursorIndexOfDejeuner = _cursor.getColumnIndexOrThrow("dejeuner");
      final int _cursorIndexOfDiner = _cursor.getColumnIndexOrThrow("diner");
      final int _cursorIndexOfComplement = _cursor.getColumnIndexOrThrow("complement");
      final List<Nutrition> _result = new ArrayList<Nutrition>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Nutrition _item;
        _item = new Nutrition();
        final int _tmpIdRepas;
        _tmpIdRepas = _cursor.getInt(_cursorIndexOfIdRepas);
        _item.setIdRepas(_tmpIdRepas);
        final String _tmpDate_repas;
        _tmpDate_repas = _cursor.getString(_cursorIndexOfDateRepas);
        _item.setDate_repas(_tmpDate_repas);
        final String _tmpPetit_dejeuner;
        _tmpPetit_dejeuner = _cursor.getString(_cursorIndexOfPetitDejeuner);
        _item.setPetit_dejeuner(_tmpPetit_dejeuner);
        final String _tmpDejeuner;
        _tmpDejeuner = _cursor.getString(_cursorIndexOfDejeuner);
        _item.setDejeuner(_tmpDejeuner);
        final String _tmpDiner;
        _tmpDiner = _cursor.getString(_cursorIndexOfDiner);
        _item.setDiner(_tmpDiner);
        final String _tmpComplement;
        _tmpComplement = _cursor.getString(_cursorIndexOfComplement);
        _item.setComplement(_tmpComplement);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
