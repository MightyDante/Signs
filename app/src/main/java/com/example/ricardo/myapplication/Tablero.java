package com.example.ricardo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableRow;

public class Tablero extends AppCompatActivity {

    TableRow vyd,aseo,acymi,predc,reupub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablero);

        vyd = findViewById(R.id.vyd);
        aseo = findViewById(R.id.aseo);
        acymi = findViewById(R.id.acymi);
        predc = findViewById(R.id.predc);
        reupub = findViewById(R.id.reupub);


        vyd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablero = new Intent(Tablero.this, Vym.class);
                startActivity(tablero);
            }
        });

        aseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablero = new Intent(Tablero.this, Aseo.class);
                startActivity(tablero);
            }
        });

        acymi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablero = new Intent(Tablero.this, AcomodacionyM.class);
                startActivity(tablero);
            }
        });

        predc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablero = new Intent(Tablero.this, PredicacionExhibidores.class);
                startActivity(tablero);
            }
        });

        reupub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablero = new Intent(Tablero.this, ReunionPublica.class);
                startActivity(tablero);
            }
        });



    }
}
