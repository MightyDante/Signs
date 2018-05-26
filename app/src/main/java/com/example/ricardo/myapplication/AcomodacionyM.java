package com.example.ricardo.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class AcomodacionyM extends AppCompatActivity  {
    ImageView acym;
    PhotoViewAttacher photoViewAttacher;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acym);
        acym = findViewById(R.id.imageView);
        photoViewAttacher = new PhotoViewAttacher(acym);

        Picasso.with(this)

                .load("http://algorit.cl/acym.png")
                .error(R.mipmap.predimantencion)
                .fit()
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .centerInside()
                .into(acym);




    }


}
