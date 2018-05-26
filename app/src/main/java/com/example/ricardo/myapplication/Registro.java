package com.example.ricardo.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    private static final int INTERVALO = 100; //0,1 segundos para salir
    private long tiempoPrimerClick;
    ImageView TableRow;
    PhotoViewAttacher photoViewAttacher;
    private EditText Nombre, Telefono;
    Context context;

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.arg1 == 1)
                Toast.makeText(getBaseContext(), "Rellena todos los campos :(", Toast.LENGTH_LONG).show();

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        Nombre = findViewById(R.id.Nombre);
        Telefono = findViewById(R.id.Telefono);

    }

    public void Registro(View view) {

        String nombre = Nombre.getText().toString().trim();
        String telefono = Telefono.getText().toString().trim();
        String manufacturer = Build.ID;
        if (!Objects.equals(nombre, "") && !Objects.equals(telefono, "+569")) {
            EnviadorRegistro sm = new EnviadorRegistro(this, nombre, telefono, manufacturer);
            sm.execute();
            Intent intent = new Intent(Registro.this, Inicio.class);

            startActivity(intent);

        } else {
            android.os.Message msg = handler.obtainMessage();
            msg.arg1 = 1;
            handler.sendMessage(msg);
        }
    }


    @Override
    public void onBackPressed() {
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()) {
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            }
        } else {
            Toast.makeText(this, "Presiona Finalizar", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }

    @Override
    public void onClick(View view) {

    }
}

