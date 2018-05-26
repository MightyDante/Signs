package com.example.ricardo.myapplication;

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

public class AntPredicacion extends AppCompatActivity {
    ImageView predicacion;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antpredicacion);
        predicacion = findViewById(R.id.imageView);
        photoViewAttacher = new PhotoViewAttacher(predicacion);
        Picasso.with(this)
                .load("http://algorit.cl/antpredicacion.png")
                .error(R.mipmap.predimantencion)
                .fit()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {



            case R.id.siguiente:
                Intent intent2 = new Intent(AntPredicacion.this, Predicacion.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.left_anim, R.anim.left_anim_out);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
