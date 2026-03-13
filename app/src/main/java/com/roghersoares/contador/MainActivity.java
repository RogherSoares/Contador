package com.roghersoares.contador;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    //Define as variáveis globais (objetos de tela)
    private int contador = 0;
    private TextView tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincula os componetes XML com o Java
        tvContador = findViewById(R.id.tvContador);
        Button btninc = findViewById(R.id.btnIncrementar);
        Button btndec = findViewById(R.id.btnDecrementar);

        //Evento de click para incrementar
        btninc.setOnClickListener(v -> {
            contador ++;
            atualizarInterface();
        });

        //Evento de click para decrementar
        btndec.setOnClickListener(v -> {
            if(contador > 0) {
                contador --;
                atualizarInterface();
            }
        });
    }
    //Método para centralizar e atualizar a UI
    private void atualizarInterface() {
        tvContador.setText(String.valueOf(contador));

        //Reagra de mudança de cor ao atingir limite de 10
        if(contador >= 20) {
            tvContador.setTextColor(Color.GREEN);
        } else if(contador >= 10) {
            tvContador.setTextColor(Color.RED);
        }else {
            tvContador.setTextColor(Color.BLACK);
        }
    }

}