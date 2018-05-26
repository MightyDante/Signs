package com.example.ricardo.myapplication;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;



public class Widget extends AppWidgetProvider {


public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    final int N = appWidgetIds.length;

    for (int appWidgetId : appWidgetIds) {
        Intent intent = new Intent(context, Formulario.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.designwidget);
        views.setOnClickPendingIntent(R.id.imageButton2, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}

    }

