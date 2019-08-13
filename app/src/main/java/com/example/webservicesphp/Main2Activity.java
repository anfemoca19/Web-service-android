package com.example.webservicesphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    //recibir eñ dato del nombre de usuario
    public static final String nombrel = "nombre";
    public static final String usuario = "usr";
    TextView nombreu, usru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombreu = findViewById(R.id.tvnombre);
        usru= findViewById(R.id.tvusru);

        nombreu.setText("Bienvenido/a " + getIntent().getStringExtra("nombre"));
        usru.setText("Usuario " + getIntent().getStringExtra("usr"));
    }
}