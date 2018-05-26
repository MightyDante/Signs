package com.example.ricardo.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class Configuracion extends AppCompatActivity {

    Switch saveName;
    TextView name;
    SharedPreferences Preferencias;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracion);
        saveName = findViewById(R.id.saveName);
        name = findViewById(R.id.name);

        Preferencias = getSharedPreferences("GLOBAL", Context.MODE_PRIVATE);
        name.setText(Preferencias.getString("name", ""));

        saveName.setChecked(Preferencias.getBoolean("useName",false));

        Log.d("Name", "\""+name.getText().toString().trim()+"\"");
        if(!name.getText().toString().equalsIgnoreCase("") )
            name.setBackgroundColor(Color.parseColor("#cb6232"));


        name.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence value, int start, int before, int count) {
                if(value.toString().equals(""))
                    name.setBackgroundColor(Color.parseColor("#FFF1986F"));
                else
                    name.setBackgroundColor(Color.parseColor("#cb6232"));
                SharedPreferences.Editor editor = Preferencias.edit();
                editor.putString("name", value.toString());
                editor.apply();
            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
            }

            public void afterTextChanged(Editable c) {
            }
        });

        saveName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = Preferencias.edit();
                editor.putBoolean("useName", isChecked);
                editor.apply();
            }
        });


    }

}
