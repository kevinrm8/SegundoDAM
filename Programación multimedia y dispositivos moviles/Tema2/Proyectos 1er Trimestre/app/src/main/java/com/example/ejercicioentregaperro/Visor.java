package com.example.ejercicioentregaperro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Visor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        //Obteniendo la instancia del TextView
        TextView nombre = (TextView) findViewById(R.id.nombre_imagen);

//Obteniendo la instancia del Intent
        Intent intent = getIntent();
//Extrayendo el extra de tipo cadena
        String name = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
//Seteando el valor del extra en el TextView
        nombre.setText(name);
    }
}