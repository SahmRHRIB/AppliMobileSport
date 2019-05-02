package com.example.PJS4.DAO;


import android.arch.persistence.room.TypeConverter;

import com.example.PJS4.Utilisateur.Utilisateur;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

    @TypeConverter
    public static ArrayList<Utilisateur> fromString(String value) {
        if(value == null){
            return null;
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Utilisateur>>(){}.getType();
        ArrayList<Utilisateur> ingredients = gson.fromJson(value, listType);
        return ingredients;
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Utilisateur> list) {
        if(list == null){
            return null;
        }

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Utilisateur>>() {}.getType();
        String json = gson.toJson(list);
        return json;
    }
}
