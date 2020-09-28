package com.example.angel.holamundo1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HolaMundo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo1);


        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final TextView elSaludo= (TextView)findViewById(R.id.miLbl);
        miTexto.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                miTexto.setText("");
            }
        });

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                String mensajePaso= "Te saludo " + miTexto.getText();
                elSaludo.setText(mensajePaso);
            }
        });
    }
}
