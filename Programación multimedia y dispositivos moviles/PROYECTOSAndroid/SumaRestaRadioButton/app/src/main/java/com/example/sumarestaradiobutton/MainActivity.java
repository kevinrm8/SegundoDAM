package com.example.sumarestaradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText numero1 = (EditText) findViewById(R.id.Numero1);
        final EditText numero2 = (EditText) findViewById(R.id.Numero2);


    }
}