package com.nutritech.nutritech.Activity.Funcionalidades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nutritech.nutritech.R;

public class CalculoAguaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_agua);

        //Ação dos botoes
        Button btAguaCalcular = (Button) findViewById(R.id.btAguaCalcular);
        btAguaCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView editAguaPeso = (TextView) findViewById(R.id.editAguaPeso);
                TextView tvAguaResultado = (TextView) findViewById(R.id.tvAguaResultado);

                //calculo de consumo de agua
                double peso = Double.parseDouble(editAguaPeso.getText().toString());

                int agua = 35;

                tvAguaResultado.setText("voce deve consumir " + peso*agua+" ml de agua por dia");
            }
        });

    }
}
