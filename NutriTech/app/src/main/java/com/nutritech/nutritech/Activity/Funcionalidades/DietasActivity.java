package com.nutritech.nutritech.Activity.Funcionalidades;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.nutritech.nutritech.R;

public class DietasActivity extends AppCompatActivity {

ImageView imagemdieta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);


        final float[] imc = new float[1];
        Button btExibirDieta = (Button) findViewById(R.id.btExibirDieta);
        btExibirDieta.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                TextView editDietaPeso = (TextView) findViewById(R.id.editDietaPeso);
                TextView editDietaAltura = (TextView) findViewById(R.id.editDietaAltura);

                //chamada das imagens no layout
                imagemdieta =(ImageView) findViewById(R.id.Imagem);

                //Calculo de IMC com finalidade de atribuir dieta
                int peso = Integer.parseInt(editDietaPeso.getText().toString());
                float altura = Float.parseFloat(editDietaAltura.getText().toString());
                imc[0] = peso / (altura * altura);
                if (imc[0] < 18.5) {
                    //chamada da dieta para grau de baixo peso
                    imagemdieta.setImageResource(R.drawable.baixopeso);

                } else {
                    if (imc[0] < 25) {
                        //chamada da dieta para peso ideal
                        imagemdieta.setImageResource(R.drawable.normal);


                    } else {
                        if (imc[0] < 30) {
                            //chamada da dieta para grau de sobrepeso
                            imagemdieta.setImageResource(R.drawable.obesidade);
                            //chamada da dieta para grau de obesidade
                        } else {
                            imagemdieta.setImageResource(R.drawable.obesidade);

                        }
                    }
                }
            }

        });

    }
}
