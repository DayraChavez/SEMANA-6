package com.example.a123456;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class AdaptadorAlumno extends ArrayAdapter<Alumno> {
        public AdaptadorAlumno(Context context, Alumno[] datos) {
            super(context, R.layout.lyitem, datos);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.lyitem, null);

            TextView txtNombre = (TextView)item.findViewById(R.id.LblNombre);
            txtNombre.setText(getItem(position).getNombre());

            TextView txtCorreo = (TextView)item.findViewById(R.id.LblCorreo);
            txtCorreo.setText(getItem(position).getCorreo());
            return(item);
        }
    }






