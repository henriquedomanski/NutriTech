package com.nutritech.nutritech.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.nutritech.nutritech.Activity.Funcionalidades.AlimentosActivity;
import com.nutritech.nutritech.Activity.Funcionalidades.CalculoAguaActivity;
import com.nutritech.nutritech.Activity.Funcionalidades.CalculoIMCActivity;
import com.nutritech.nutritech.Activity.Funcionalidades.DietasActivity;
import com.nutritech.nutritech.Activity.Funcionalidades.MapsActivity;
import com.nutritech.nutritech.R;

public class MenuActivity extends AppCompatActivity {

    private Button btnAbrirActivityAlimentos;
    private Button btnAbrirActivityDieta;
    private Button btnAbrirActivityAgua;
    private Button btnAbrirActivityMaps;
    private Button btnAbrirActivityCalculoIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Chamada da funcionalidade "Calculo de IMC"
        btnAbrirActivityCalculoIMC = (Button) findViewById(R.id.btnCalculoimc);
        btnAbrirActivityCalculoIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAbrirTelaImc = new Intent(MenuActivity.this, CalculoIMCActivity.class);
                startActivity(intentAbrirTelaImc);
            }
        });

        //Chamada da funcionalidade "Localização"
        btnAbrirActivityMaps = (Button) findViewById(R.id.btnMaps);
        btnAbrirActivityMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAbrirMaps = new Intent(MenuActivity.this, MapsActivity.class);
                startActivity(intentAbrirMaps);
            }
        });

        //Chamada da funcionalidade "Calculo de Consumo de agua diaria"
        btnAbrirActivityAgua = (Button)findViewById(R.id.btnCalculoAgua);
        btnAbrirActivityAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAbrirAgua = new Intent(MenuActivity.this, CalculoAguaActivity.class);
                startActivity(intentAbrirAgua);
            }
        });


        //Chamada da funcionalidade "Dieta personalizada"
        btnAbrirActivityDieta = (Button) findViewById(R.id.btnDietas);
        btnAbrirActivityDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAbrirDieta = new Intent(MenuActivity.this, DietasActivity.class);
                startActivity(intentAbrirDieta);
            }
        });

        //Chamada da funcionalidade "Alimentos"
        btnAbrirActivityAlimentos = (Button) findViewById(R.id.btnAlimentos);
        btnAbrirActivityAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAbrirAlimentos = new Intent(MenuActivity.this, AlimentosActivity.class);
                startActivity(intentAbrirAlimentos);
            }
        });



    }
}
