package com.example.angel.holamundo2;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class HolaMundo2 extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola_mundo2);


        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludo = (TextView) findViewById(R.id.miLbl);

        /*Probar MÚSICA */

        MediaPlayer miMusica= MediaPlayer.create(getApplicationContext(),R.raw.desigual);
        miMusica.start();

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(HolaMundo2.this, Pantalla2.class);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                //Toast.makeText(this, "Pulsado BOTON", Toast.LENGTH_SHORT).show();
                //showToast("Pulsado BOTON");
                showAlert("Pulsado BOTON");
            }

        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    protected void showAlert(CharSequence text) {
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok, null);
        alert.show();
    }

}
