package com.example.ricardo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Predicacion extends AppCompatActivity  {
    ImageView predicacion;
    PhotoViewAttacher photoViewAttacher;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predicacion);
        predicacion = findViewById(R.id.imageView);
        photoViewAttacher = new PhotoViewAttacher(predicacion);

        Picasso.with(this)

                .load("http://algorit.cl/predicacion.png")
                .error(R.mipmap.predimantencion)
                .fit()
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .centerInside()
                .into(predicacion);




    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_predicacion, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onBackPressed() {
        Intent inte = new Intent();
        inte.setClass(Predicacion.this, Inicio.class);
        startActivity(inte);
        finish();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.anterior:
                Intent intent = new Intent(Predicacion.this, AntPredicacion.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_anim, R.anim.right_anim_out);

                return true;

            case R.id.siguiente:
                Intent intent2 = new Intent(Predicacion.this, ProxPredicacion.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.left_anim, R.anim.left_anim_out);

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }



}
