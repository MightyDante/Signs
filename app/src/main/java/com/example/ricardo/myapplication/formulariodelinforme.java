package com.example.ricardo.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class formulariodelinforme extends AppCompatActivity {
    Context context;

    TextView mes, grupo;
    EditText nombre, horas, videos, estudios, publicaciones, revisitas;
    Button enviar;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.informeformulario);
        nombre = findViewById(R.id.Nombre);
        horas = findViewById(R.id.Horas);
        publicaciones = findViewById(R.id.Publicaciones);
        videos = findViewById(R.id.Videos);
        estudios = findViewById(R.id.Estudios);
        revisitas = findViewById(R.id.Revisitas);
        mes = findViewById(R.id.Mes);
        enviar = findViewById(R.id.enviarform);
        grupo = findViewById(R.id.grupo);

    }

    public void enviarinforme(View v) {
        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.arg1 == 1)
                    Toast.makeText(getBaseContext(), "Rellena todos los campos :(", Toast.LENGTH_LONG).show();

            }

        };



        Intent datos = new Intent(formulariodelinforme.this, Informe.class);
        datos.putExtra("FA", nombre.getText() + "");
        datos.putExtra("FE", horas.getText() + "");
        datos.putExtra("FI", publicaciones.getText() + "");
        datos.putExtra("FO", videos.getText() + "");
        datos.putExtra("FU", estudios.getText() + "");
        datos.putExtra("FF", revisitas.getText() + "");
        datos.putExtra("FG", mes.getText() + "");
        datos.putExtra("PAL", "vaca");

        String ms = mes.getText().toString();
        String nm = nombre.getText().toString();
        String hr = horas.getText().toString();
        String vd = videos.getText().toString();
        String pb = publicaciones.getText().toString();
        String es = estudios.getText().toString();
        String rev = revisitas.getText().toString();
        String grup = grupo.getText().toString();


        if (!Objects.equals(ms, "") && !Objects.equals(nm, "") && !Objects.equals(hr, "") && !Objects.equals(vd, "")
                && !Objects.equals(pb, "") && !Objects.equals(es, "") && !Objects.equals(grup, "")) {

            EnviadorInforme sm = new EnviadorInforme(this, ms, nm, hr, vd, pb, es, rev, grup);
            sm.execute();

            String publi = getIntent().getStringExtra("Pass");


            if (!Objects.equals(publi, "listo")) {

                startActivity(datos);
            }

        } else {
            android.os.Message msg = handler.obtainMessage();
            msg.arg1 = 1;
            handler.sendMessage(msg);
        }


    }


    public void grupo(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final CharSequence[] items = {
                "Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4", "Grupo 5"
        };


        builder.setCancelable(true);
        builder.setIcon(R.mipmap.icon);


        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                grupo.setText("Grupo " + (which + 1));
            }
        });


        builder.setTitle("Grupo de Predicación");
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void mes(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final CharSequence[] items = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto"
                , "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };


        builder.setCancelable(true);
        builder.setIcon(R.mipmap.icon);


        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {

                    case 0:
                        mes.setText("Enero");

                        break;
                    case 1:
                        mes.setText("Febrero");

                        break;
                    case 2:
                        mes.setText("Marzo");

                        break;
                    case 3:
                        mes.setText("Abril");

                        break;
                    case 4:
                        mes.setText("Mayo");

                        break;
                    case 5:
                        mes.setText("Junio");

                        break;
                    case 6:
                        mes.setText("Julio");

                        break;
                    case 7:
                        mes.setText("Agosto");

                        break;
                    case 8:
                        mes.setText("Septiembre");

                        break;
                    case 9:
                        mes.setText("Octubre");

                        break;
                    case 10:
                        mes.setText("Noviembre");

                        break;
                    case 11:
                        mes.setText("Diciembre");

                        break;


                }
            }
        });


        builder.setTitle("Seleccionar Mes");
        AlertDialog alert = builder.create();
        alert.show();
    }


}


