package com.example.ricardo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Inicio extends AppCompatActivity {
    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;
    Button tablero, direcciones;
    Context context;
    ImageButton mapa;
    ImageButton informe;
    ImageButton predicacion;
    TextView nmapa, npredi, ninforme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean primeravez =
                getSharedPreferences("Primeravez", MODE_PRIVATE)
                        .getBoolean("primeravez", true);


        if (primeravez) {

            startActivity(new Intent(Inicio.this, Tut1.class));

        }

        getSharedPreferences("Primeravez", MODE_PRIVATE).edit()
                .putBoolean("primeravez", false).commit();

// Here, thisActivity is the current activity


        setContentView(R.layout.inicio);
        mapa = findViewById(R.id.mapa);
        informe = findViewById(R.id.carrito);
        predicacion = findViewById(R.id.predicacion);
        nmapa = findViewById(R.id.nmapa);
        npredi = findViewById(R.id.npredica);
        ninforme = findViewById(R.id.ninfo);
        tablero = findViewById(R.id.tablero);
        direcciones = findViewById(R.id.dir);

        tablero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tablero = new Intent(Inicio.this, Tablero.class);
                startActivity(tablero);
            }
        });
        direcciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent direcciones = new Intent(Inicio.this, Direcciones.class);
                startActivity(direcciones);
            }
        });

        nmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapa = new Intent(Inicio.this, Mapa.class);
                startActivity(mapa);
            }
        });

        npredi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent predicacion = new Intent(Inicio.this, Predicacion.class);
                startActivity(predicacion);

            }
        });

        ninforme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent inf = new Intent(Inicio.this, Informe.class);
                startActivity(inf);

            }
        });


        informe.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {


                                           Intent infor = new Intent(Inicio.this, Informe.class);
                                           startActivity(infor);
                                       }
                                   }

        );



        final Context that = this;

        final int[] blockList = new int[] {3,5,3,4,3,3,3,5,5,5,5,3,5,5,6,6,6,5,5,6,4,7,1,4,4,3,7,4,1,7,2,5,4,3,4,5,5,5};

        for(int i = 1; i <= blockList.length; i++) {
            final int index = i;

            int blockId = getResources().getIdentifier("terr"+i, "id", getPackageName());

            findViewById(blockId).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    int imageId = getResourseId(that, "terr"+index, "mipmap", getPackageName());
                    Intent territorio = new Intent(Inicio.this, TerrBase.class);
                    territorio.putExtra("Blocks",blockList[index-1]);
                    territorio.putExtra("Image", imageId);
                    territorio.putExtra("TerritoryNumber", index);

                    startActivity(territorio);
                }
            });

        }

        predicacion.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {

                                               Intent predicacion = new Intent(Inicio.this, Predicacion.class);
                                               startActivity(predicacion);
                                           }
                                       }
        );


    }

    public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
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
            Toast.makeText(this, "Vuelva a presionar para salir", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_terrx4, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.config:
                Intent intent2 = new Intent(Inicio.this, Configuracion.class);
                startActivity(intent2);
                return true;

            case R.id.add:
                Intent intent3 = new Intent(Inicio.this, formPerson.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
