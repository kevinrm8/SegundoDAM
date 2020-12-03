package com.example.gridlayoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button N1 = (Button) findViewById(R.id.numero_1);
        final Button N2 = (Button) findViewById(R.id.numero_2);
        final Button N3 = (Button) findViewById(R.id.numero_3);
        final Button N4 = (Button) findViewById(R.id.numero_4);
        final Button N5 = (Button) findViewById(R.id.numero_5);
        final Button N6 = (Button) findViewById(R.id.numero_6);
        final Button N7 = (Button) findViewById(R.id.numero_7);
        final Button N8 = (Button) findViewById(R.id.numero_8);
        final Button N9 = (Button) findViewById(R.id.numero_9);

        final Button division = (Button) findViewById(R.id.division);
        final Button multiplicacion = (Button) findViewById(R.id.multiplicacion);
        final Button sumar = (Button) findViewById(R.id.sumar);
        final Button restar = (Button) findViewById(R.id.restar);
        final Button igual = (Button) findViewById(R.id.igual);


    }
}