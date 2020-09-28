package com.example.angel.holamundo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView) findViewById(R.id.miMensaje);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        final Button miBotonVolver = (Button) findViewById(R.id.botonVolver);
        miBotonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(Pantalla2.this, HolaMundo2.class);
                startActivity(miIntent);

            }
        });
        //final ImageButton miBotonImagenVolver = (ImageButton) findViewById(R.id.BtnImageVolver);
    }

}