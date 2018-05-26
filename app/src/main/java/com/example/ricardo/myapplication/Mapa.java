package com.example.ricardo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

import uk.co.senab.photoview.PhotoViewAttacher;
public class Mapa extends AppCompatActivity {

    ImageView Mapa;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);

        PDFView pdfView = findViewById(R.id.pdf);
        pdfView.fromAsset("TFnail.pdf").load();



    }
}
