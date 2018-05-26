package com.example.ricardo.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class formPerson extends AppCompatActivity {
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.arg1 == 1)
                Toast.makeText(getBaseContext(),"Rellena todos los campos", Toast.LENGTH_LONG).show();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_person);



    }

    public void enviar (View view) {


        EditText nombre = findViewById(R.id.nombre);
        EditText direccion = findViewById(R.id.direccion);
        EditText telefono = findViewById(R.id.telefono);
        EditText publicacion = findViewById(R.id.publicacion);
        EditText observaciones = findViewById(R.id.observacion);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
    {
        if (!Objects.equals(nombre.toString(), "") && !Objects.equals(direccion, "") && !Objects.equals(telefono, "") && !Objects.equals(publicacion, "")&& !Objects.equals(observaciones, "")) {
            EnviadorNuevaDireccion sm = new EnviadorNuevaDireccion(this, nombre.getText().toString(), direccion.getText().toString(), telefono.getText().toString(), publicacion.getText().toString() , observaciones.getText().toString());
            sm.execute();
        } else {
            Message msg = handler.obtainMessage();
            msg.arg1 = 1;
            handler.sendMessage(msg);
        }
    }

}
}

