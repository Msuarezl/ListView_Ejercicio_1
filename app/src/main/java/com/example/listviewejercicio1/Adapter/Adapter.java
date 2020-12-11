package com.example.listviewejercicio1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listviewejercicio1.R;
import com.example.listviewejercicio1.model.Paises;

import java.util.ArrayList;


public class Adapter extends ArrayAdapter<Paises> {
    public Adapter(Context context, ArrayList<Paises> datos) {
        super(context, R.layout.ly_item, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_item, null);

        TextView lblpais = (TextView)item.findViewById(R.id.LblPais);
        TextView lblSlug = (TextView)item.findViewById(R.id.LblSlug);




        //.error(R.drawable.imgnotfound)



        lblpais.setText(getItem(position).getPaises());
        lblSlug.setText(getItem(position).getSlug());

        return(item);
    }
}
