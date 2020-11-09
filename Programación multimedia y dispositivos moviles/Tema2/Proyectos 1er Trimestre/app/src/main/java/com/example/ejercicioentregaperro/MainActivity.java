package com.example.ejercicioentregaperro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

    private Button show_pet_button;
    public final static String EXTRA_NOMBRE = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obteniendo una instancia del boton show_pet_button
        show_pet_button = (Button)findViewById(R.id.show_pet_button);

        //Registrando la escucha sobre la actividad Main
        show_pet_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){

        //Iniciando la actividad Visor
        Intent intent = new Intent(this,Visor.class);
        intent.putExtra(EXTRA_NOMBRE,"Perro Salchicha");
        startActivity(intent);

    }

}