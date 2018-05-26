package com.example.ricardo.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Objects;


public class TerrBase extends AppCompatActivity implements View.OnClickListener {
    private int BlocksAll;
    private int Blocks;
    private int TerritoryNumber;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.arg1 == 1)
                Toast.makeText(getBaseContext(),"Rellena todos los campos", Toast.LENGTH_LONG).show();
        }

    };

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.territorybase);

        BlocksAll = 0;
        Intent input = getIntent();
        Bundle data = input.getExtras();
        Blocks = data.getInt("Blocks");
        int image = data.getInt("Image");
        TerritoryNumber= data.getInt("TerritoryNumber");
        setTitle("Territorio "+TerritoryNumber);

        ImageView blocksImage = findViewById(R.id.blocksImage);
        blocksImage.setImageResource(image);

        LinearLayout checkBoxContainer = findViewById(R.id.checkbox_container);

        for(int i = 1; i <= Blocks; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText(String.valueOf(i));
            cb.setId(i+10);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    BlocksAll += isChecked ? 1 : -1;
                    ((ToggleButton)findViewById(R.id.toggleButton)).setChecked(BlocksAll == Blocks);
                }
            });

            checkBoxContainer.addView(cb);
        }

        SharedPreferences preferencias = getSharedPreferences("GLOBAL", Context.MODE_PRIVATE);
        if(preferencias.getBoolean("useName",false))
            ((EditText)findViewById(R.id.Nombre)).setText(preferencias.getString("name", ""));

    }

    public void onToogle(View view) {

        ToggleButton toogle = findViewById(R.id.toggleButton);
        Boolean estado = toogle.isChecked();

        for(int i = 1; i <= Blocks; i++) {
            @SuppressLint("ResourceType") CheckBox chk = findViewById(i+10);
            chk.setChecked(estado);
        }

    }

    public void changeTime(View view) {
        if(((Switch)findViewById(R.id.cambio)).isChecked())
            findViewById(R.id.cambiocolor).setBackgroundColor(Color.parseColor("#00325B"));
        else
            findViewById(R.id.cambiocolor).setBackgroundColor(Color.parseColor("#FF03A29D"));
    }


    public void onPickDate(View view) {

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                mes = mes + 1;
                String fecha = dia + "/" + mes + "/" + año;
                ((TextView)findViewById(R.id.fecha)).setText(fecha);
            }
        };

        Calendar cal = Calendar.getInstance();
        int año = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                TerrBase.this,
                android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth,
                mDateSetListener,
                año,mes,dia);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));


        dialog.show();
    }

    @SuppressLint("CutPasteId")
    @Override
    public void onClick(View view) {

        String horario = ((Switch)findViewById(R.id.cambio)).isChecked() ? "Tarde" : "Mañana";

        StringBuilder manzanas = new StringBuilder();
        int blocksCounter = 0;
        for(int i = 1; i <= Blocks; i++) {
            if(((CheckBox) findViewById(i + 10)).isChecked())
                manzanas.append(manzanas.toString() == "" ? String.valueOf(i) : "," + String.valueOf(i));
            blocksCounter += ((CheckBox) findViewById(i + 10)).isChecked() ? 1 : 0;
        }

        if(blocksCounter == Blocks)
            manzanas = new StringBuilder("Completo");


        String fecha = ((TextView)findViewById(R.id.fecha)).getText().toString().trim();
        String nombre =  ((EditText)findViewById(R.id.Nombre)).getText().toString().trim();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(!Objects.equals(manzanas.toString(), "") && !Objects.equals(fecha, "") && !Objects.equals(nombre, "")) {
                    manzanas.append(".");
                    String manufacturer = Build.ID;
                    EnviadorCorreo sm = new EnviadorCorreo(this, fecha, manzanas.toString(), horario, "Territorio "+TerritoryNumber, nombre, manufacturer);
                    sm.execute();
            }
            else{
                Message msg = handler.obtainMessage();
                msg.arg1 = 1;
                handler.sendMessage(msg);
            }
        }
    }

}