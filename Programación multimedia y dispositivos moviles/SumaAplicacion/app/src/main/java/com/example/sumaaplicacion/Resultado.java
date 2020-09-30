package com.example.sumaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        final TextView Resultado = (TextView) findViewById(R.id.VerResultado);


        Bundle  miBundleRecoger = getIntent().getExtras();
        Resultado.setText(miBundleRecoger.getString("ResultadoSuma"));

    }
}