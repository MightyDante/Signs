package com.example.ricardo.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviadorCorreo extends AsyncTask<Void,Void,Void> {

    @SuppressLint("StaticFieldLeak")
    private Context context;

    //Information to send email
    private String fecha;
    private String nombre;
    private String manzanas;
    private String territorio;
    private String id;
    private String horario;

    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;


    //Class Constructor
    public EnviadorCorreo(Context context, String fecha, String manzanas, String horario, String territorio, String nombre, String id){
        //Initializing variables
        this.context = context;
        this.fecha = fecha;
        this.manzanas = manzanas;
        this.horario = horario;
        this.territorio = territorio;
        this.nombre = nombre;
        this.id = id;

    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context,"Enviando...","Un molino esta girando para poder enviar esto :D",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message
    }



    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.arg1 == 1){
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.icon);
                builder.setTitle("No enviado");
                builder.setMessage("Asegurese de estar conectado a internet");
                builder.setPositiveButton("Ok",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
            if(msg.arg1 == 2) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.icon);
                builder.setTitle("Enviado");
                builder.setMessage("¡Su Registro se ha enviado con exito!");
                builder.setPositiveButton("Listo",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert=builder.create();
                alert.show();
            }
        }

    };

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });




        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);








            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
            //Adding receiver
            mm.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("csanchez077@hotmail.com"));
            //Adding su subject
            mm.setSubject(territorio);
            //Adding message
            mm.setText("Nombre: "+ nombre +"\nFecha: "+fecha +"\nHorario: "+horario+ "\nManzanas trabajadas: "+manzanas+ "\nId: "+id);

            //Sending email
            Transport.send(mm);

            //Mensaje Enviado
            android.os.Message msg = handler.obtainMessage();
            msg.arg1 = 2;
            handler.sendMessage(msg);


        } catch (MessagingException e) {

            //Mensaje No Enviado
            android.os.Message msg = handler.obtainMessage();
            msg.arg1 = 1;
            handler.sendMessage(msg);
        }
        return null;
    }


}