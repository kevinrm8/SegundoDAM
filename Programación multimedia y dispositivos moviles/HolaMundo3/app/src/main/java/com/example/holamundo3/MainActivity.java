package com.example.holamundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView elSaludo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);

        //Recoger el texto devuelto
        final TextView saludoDevuelto= (TextView)findViewById(R.id.miTxt2);

        Bundle miBundleRecoger = getIntent().getExtras();
        saludoDevuelto.setText(miBundleRecoger.getString("TEXTO2"));

        //Borrar el texto inicial del EditText
        miTexto.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b){
                if (b) miTexto.setText("");
            }
        });

/*        miTexto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                miTexto.setText("");
            }
        });*/

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }
}