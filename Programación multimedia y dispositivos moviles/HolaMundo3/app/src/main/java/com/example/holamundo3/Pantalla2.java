package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final Button miBoton2 = (Button)findViewById(R.id.miBtn2);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        miBoton2.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(Pantalla2.this, MainActivity.class);
                Bundle miBundle=new Bundle();
                String mensajeDevuelto= "" + otroSaludo.getText();
                miBundle.putString("TEXTO2", mensajeDevuelto);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

    }

}