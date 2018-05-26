package com.example.ricardo.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class Formulario extends AppCompatActivity {
Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        final CharSequence[] items = {
                  "Predicación", "Territorio 1", "Territorio 2", "Territorio 3", "Territorio 4", "Territorio 5", "Territorio 6", "Territorio 7"
                , "Territorio 8", "Territorio 9", "Territorio 10", "Territorio 11", "Territorio 12", "Territorio 13", "Territorio 14"
                , "Territorio 15", "Territorio 16", "Territorio 17", "Territorio 18", "Territorio 19", "Territorio 20", "Territorio 21"
                , "Territorio 22", "Territorio 23", "Territorio 24", "Territorio 25", "Territorio 26", "Territorio 27", "Territorio 28",
                "Territorio 29" ,"Territorio 30","Territorio 31","Territorio 32","Territorio 33","Territorio 34","Territorio 35"
                ,"Territorio 36","Territorio 37","Territorio 38"

        };


        builder.setCancelable(true);
        builder.setIcon(R.mipmap.icon);


        builder.setItems(items,  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)  {
                switch (which) {

                    case 0:
                        Intent predi = new Intent(Formulario.this, Predicacion.class );
                        startActivity(predi);
                        break;
                    case 1:
                        Intent terr1 = new Intent(Formulario.this, TerrBase.class );
                        startActivity(terr1);
                        break;
//                    case 2:
////                        Intent terr2 = new Intent(Formulario.this, Terr2.class );
////                        startActivity(terr2);
////                        break;
////                    case 3:
////                        Intent terr3 = new Intent(Formulario.this, Terr3.class );
////                        startActivity(terr3);
////                        break;
////                    case 4:
////                        Intent terr4 = new Intent(Formulario.this, Terr4.class );
////                        startActivity(terr4);
////                        break;
////                    case 5:
////                        Intent terr5 = new Intent(Formulario.this, Terr5.class );
////                        startActivity(terr5);
////                        break;
////                    case 6:
////                        Intent terr6 = new Intent(Formulario.this, Terr6.class );
////                        startActivity(terr6);
////                        break;
////                    case 7:
////                        Intent terr7 = new Intent(Formulario.this, Terr7.class );
////                        startActivity(terr7);
////                        break;
////                    case 8:
////                        Intent terr8 = new Intent(Formulario.this, Terr8.class );
////                        startActivity(terr8);
////                        break;
////                    case 9:
////                        Intent terr9 = new Intent(Formulario.this, Terr9.class );
////                        startActivity(terr9);
////                        break;
////                    case 10:
////                        Intent terr10 = new Intent(Formulario.this, Terr10.class );
////                        startActivity(terr10);
////                        break;
////                    case 11:
////                        Intent terr11 = new Intent(Formulario.this, Terr11.class );
////                        startActivity(terr11);
////                        break;
////                    case 12:
////                        Intent terr12 = new Intent(Formulario.this, Terr12.class );
////                        startActivity(terr12);
////                        break;
////                    case 13:
////                        Intent terr13 = new Intent(Formulario.this, Terr13.class );
////                        startActivity(terr13);
////                        break;
////                    case 14:
////                        Intent terr14 = new Intent(Formulario.this, Terr14.class );
////                        startActivity(terr14);
////                        break;
////                    case 15:
////                        Intent terr15 = new Intent(Formulario.this, Terr15.class );
////                        startActivity(terr15);
////                        break;
////                    case 16:
////                        Intent terr16 = new Intent(Formulario.this, Terr16.class );
////                        startActivity(terr16);
////                        break;
////                    case 17:
////                        Intent terr17 = new Intent(Formulario.this, Terr17.class );
////                        startActivity(terr17);
////                        break;
////                    case 18:
////                        Intent terr18 = new Intent(Formulario.this, Terr18.class );
////                        startActivity(terr18);
////                        break;
////                    case 19:
////                        Intent terr19 = new Intent(Formulario.this, Terr19.class );
////                        startActivity(terr19);
////                        break;
////                    case 20:
////                        Intent terr20 = new Intent(Formulario.this, Terr20.class );
////                        startActivity(terr20);
////                        break;
////                    case 21:
////                        Intent terr21 = new Intent(Formulario.this, Terr21.class );
////                        startActivity(terr21);
////                        break;
////                    case 22:
////                        Intent terr22 = new Intent(Formulario.this, Terr22.class );
////                        startActivity(terr22);
////                        break;
////                    case 23:
////                        Intent terr23 = new Intent(Formulario.this, Terr23.class );
////                        startActivity(terr23);
////                        break;
////                    case 24:
////                        Intent terr24 = new Intent(Formulario.this, Terr24.class );
////                        startActivity(terr24);
////                        break;
////                    case 25:
////                        Intent terr25 = new Intent(Formulario.this, Terr25.class );
////                        startActivity(terr25);
////                        break;
////                    case 26:
////                        Intent terr26 = new Intent(Formulario.this, Terr26.class );
////                        startActivity(terr26);
////                        break;
////                    case 27:
////                        Intent terr27 = new Intent(Formulario.this, Terr27.class );
////                        startActivity(terr27);
////                        break;
////                    case 28:
////                        Intent terr28 = new Intent(Formulario.this, Terr28.class );
////                        startActivity(terr28);
////                        break;
////                    case 29:
////                        Intent terr29 = new Intent(Formulario.this, Terr29.class );
////                        startActivity(terr29);
////                        break;
////                    case 30:
////                        Intent terr30 = new Intent(Formulario.this, Terr30.class );
////                        startActivity(terr30);
////                        break;
////                    case 31:
////                        Intent terr31 = new Intent(Formulario.this, Terr31.class );
////                        startActivity(terr31);
////                        break;
////                    case 32:
////                        Intent terr32 = new Intent(Formulario.this, Terr32.class );
////                        startActivity(terr32);
////                        break;
////                    case 33:
////                        Intent terr33 = new Intent(Formulario.this, Terr33.class );
////                        startActivity(terr33);
////                        break;
////                    case 34:
////                        Intent terr34 = new Intent(Formulario.this, Terr34.class );
////                        startActivity(terr34);
////                        break;
////                    case 35:
////                        Intent terr35 = new Intent(Formulario.this, Terr35.class );
////                        startActivity(terr35);
////                        break;
////                    case 36:
////                        Intent terr36 = new Intent(Formulario.this, Terr36.class );
////                        startActivity(terr36);
////                        break;
////                    case 37:
////                        Intent terr37 = new Intent(Formulario.this, Terr37.class );
////                        startActivity(terr37);
////                        break;
////                    case 38:
////                        Intent terr38 = new Intent(Formulario.this, Terr38.class );
////                        startActivity(terr38);
////                        break;




            }}
        });


        builder.setTitle("Selección Rapida");
        AlertDialog alert=builder.create();
        alert.show();
        }



}