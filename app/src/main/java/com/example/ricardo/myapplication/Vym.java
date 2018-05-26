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

public class Vym extends AppCompatActivity  {
    ImageView vym;
    PhotoViewAttacher photoViewAttacher;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vym);
        vym = findViewById(R.id.imageView);
        photoViewAttacher = new PhotoViewAttacher(vym);

        Picasso.with(this)

                .load("http://algorit.cl/vym.png")
                .error(R.mipmap.predimantencion)
                .fit()
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .centerInside()
                .into(vym);




    }


}
