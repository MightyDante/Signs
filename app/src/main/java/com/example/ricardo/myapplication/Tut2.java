package com.example.ricardo.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tut2 extends AppCompatActivity {
    Button siguiente2;
    private static final int INTERVALO = 100; //0,1 segundos para salir
    private long tiempoPrimerClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tut2);

        siguiente2 = findViewById(R.id.bsiguiente2);

        siguiente2.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void onClick(View v) {

                                             Intent sig2 = new Intent(Tut2.this, Tut3.class );
                                             startActivity(sig2);
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
