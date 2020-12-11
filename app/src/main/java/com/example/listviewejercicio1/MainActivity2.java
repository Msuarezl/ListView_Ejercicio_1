package com.example.listviewejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.listviewejercicio1.Adapter.Adapter;
import com.example.listviewejercicio1.model.Paises;

public class MainActivity2 extends AppCompatActivity {
    public static final String url = "https://api.covid19api.com/summary";
    RequestQueue requestQueue;
    ArrayList<String> paises;
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lstOpciones = (ListView)findViewById(R.id.lstListaNoticias);

        View header = getLayoutInflater().inflate(R.layout.ly_headernoticias, null);
        lstOpciones.addHeaderView(header);
        Listar();
    }

    private void Listar ()
    {
        requestQueue = Volley.newRequestQueue(MainActivity2.this);
        StringRequest jsonObjectRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            ArrayList<Paises> lstpaises = new ArrayList<Paises> ();

                            JSONObject JSONlista =  new JSONObject( response);
                            JSONArray JSONlistapaises=  JSONlista.getJSONArray("Countries");

                            lstpaises = Paises.JsonObjectsBuild(JSONlistapaises);

                            Adapter adapatorUsuario = new Adapter(MainActivity2.this, lstpaises);

                            lstOpciones.setAdapter(adapatorUsuario);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);


    }
}