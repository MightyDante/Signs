package com.example.ricardo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InformePrimeraVez extends AppCompatActivity {


    Button nuevo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informeprimeravez);
        nuevo = findViewById(R.id.nuevo);
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(InformePrimeraVez.this, formulariodelinforme.class);
                startActivity(ir);
                overridePendingTransition(R.anim.left_anim, R.anim.left_anim_out);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent inte = new Intent();
        inte.setClass(InformePrimeraVez.this, Inicio.class);
        startActivity(inte);
        finish();

    }


}
