package com.example.ricardo.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tut3 extends AppCompatActivity {
    Button siguiente3;
    private static final int INTERVALO = 100; //0,1 segundos para salir
    private long tiempoPrimerClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tut3);

        siguiente3 = findViewById(R.id.bsiguiente);

        siguiente3.setOnClickListener(new View.OnClickListener() {

                                          @Override
                                          public void onClick(View v) {

                                              Intent sig3 = new Intent(Tut3.this, Registro.class );
                                              startActivity(sig3);
                                              overridePendingTransition(R.anim.left_anim, R.anim.left_anim_out);

                                          }


                                      }
        );
    }
    @Override
    public void onBackPressed(){
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()){
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            }
        }else {
            Toast.makeText(this, "Presiona siguiente", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }
}
