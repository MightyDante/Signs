package com.example.ricardo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;


public class Informe extends AppCompatActivity {
    LinearLayout titulo;
    TextView nombre, nombre1, texto, texto2, mes, mes3;
    Button nuevo;
    boolean click = false;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.informe);
        nuevo = findViewById(R.id.nuevo);

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(Informe.this, formulariodelinforme.class);
                startActivity(ir);
                overridePendingTransition(R.anim.left_anim, R.anim.left_anim_out);
            }
        });



        nombre1 = findViewById(R.id.nombre1);
        texto2 = findViewById(R.id.texto2);
        mes3 = findViewById(R.id.mes3);


        SharedPreferences preferencias = getSharedPreferences("MP", Context.MODE_PRIVATE);
        nombre1.setText(preferencias.getString("ZH", ""));
        texto2.setText(preferencias.getString("ZK", ""));
        mes3.setText(preferencias.getString("ZP", ""));


        Boolean isFirstRun =
                getSharedPreferences("VAFUNC", MODE_PRIVATE)
                        .getBoolean("isFirstRun", true);


        if (isFirstRun) {

            startActivity(new Intent(Informe.this, InformePrimeraVez.class));

        }

        getSharedPreferences("VAFUNC", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();

        String ñi = getIntent().getStringExtra("PAL");

        if (Objects.equals(ñi, "vaca")) {
            String name = getIntent().getStringExtra("FA");
            String horas = getIntent().getStringExtra("FE");
            String publi = getIntent().getStringExtra("FI");
            String vid = getIntent().getStringExtra("FO");
            String est = getIntent().getStringExtra("FU");
            String rev = getIntent().getStringExtra("FF");
            String ms = getIntent().getStringExtra("FG");


            nombre1.setText("Nombre: " + name);
            texto2.setText("Horas: " + horas + " / Publicaciones: " + publi + " / Videos: " + vid + " / Revisitas: " + rev + " / Estudios: " + est);
            mes3.setText("Mes: " + ms);


            SharedPreferences hoi = getSharedPreferences("MP", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = hoi.edit();
            editor.putString("ZH", nombre1.getText().toString());
            editor.putString("ZK", texto2.getText().toString());
            editor.putString("ZP", mes3.getText().toString());
            editor.commit();

        }


    }


    @Override
    public void onBackPressed() {
        Intent inte = new Intent();
        inte.setClass(Informe.this, Inicio.class);
        startActivity(inte);
        finish();

    }
}
