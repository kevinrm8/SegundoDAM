package com.example.sumaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Numero1 = (EditText) findViewById(R.id.Num1);
        final EditText Numero2 = (EditText) findViewById(R.id.Num2);

        final Button SUMAR = (Button) findViewById(R.id.Sumar);

        //TEST RES
       // final TextView Res = (TextView) findViewById(R.id.Resultado);

        //Borrar el texto inicial del EditText
        Numero1.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b){
                if (b) Numero1.setText("");
            }
        });
        //Borrar el texto inicial del EditText
        Numero2.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b){
                if (b) Numero2.setText("");
            }
        });

        SUMAR.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                Intent miIntent= new Intent(MainActivity.this, Resultado.class);
                Bundle miBundle=new Bundle();

        //RESULADO DE LA SUMA:
        Double num1 = Double.parseDouble(String.valueOf(Numero1.getText()));
        Double num2 = Double.parseDouble(String.valueOf(Numero2.getText()));
        Double suma = num1+num2;
        String result = String.valueOf(suma);
        miBundle.putString("ResultadoSuma", result);
        miIntent.putExtras(miBundle);
        startActivityForResult(miIntent, COD_RESPUESTA);
                }
        });


    }

    public void onActivityResult(int cod_resp, int cod_result,Intent intent) {
      /*  if (cod_result== RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        } */
        super.onActivityResult(cod_resp, cod_result, intent);
    }
    /* Proceso para entender el ciclo de vida */
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause-ClasePrincipal", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart-ClasePrincipal", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy-ClasePrincipaly", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}