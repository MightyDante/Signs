package com.example.ricardo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class VentanaSplash extends AppCompatActivity{

    // Assume thisActivity is the current activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ventanasplash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(VentanaSplash.this, Inicio.class);
                startActivity(intent);
            }

        },1500);



    }


}
