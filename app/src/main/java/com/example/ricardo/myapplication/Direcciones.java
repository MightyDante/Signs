package com.example.ricardo.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

import java.net.URI;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Direcciones extends AppCompatActivity {

    private static final String user = "mobile";
    private static final String password = "mobile.app.789";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direcciones);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        int count=0;

        try {
            Connection conexionMySQL = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance ();
            conexionMySQL = DriverManager.getConnection("jdbc:mysql://" + "45.33.10.142" + ":" + "3306" + "/" + "Signs", user, password);
            Statement st = conexionMySQL.createStatement();
            ResultSet rs = st
                    .executeQuery("select * from Personas");

            while (rs.next()) {

                Log.d("Dato ", rs.getString(0));

            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }





    }
}
