package com.example.listviewejercicio1.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Paises {

    private String paises;
    private String slug;

    public Paises(String tit, String sub) {
        paises = tit;
        slug = sub;
    }

    public String getPaises() {
        return paises;
    }

    public String getSlug() {
        return slug;
    }

    public Paises(JSONObject a) throws JSONException {
        paises = a.getString("Country").toString();

        slug = a.getString("Slug").toString();


    }

    public static ArrayList<Paises> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Paises> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Paises(datos.getJSONObject(i)));
        }
        return usuarios;

    }
}



