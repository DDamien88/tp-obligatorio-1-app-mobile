package com.example.tp1deramo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class ModoAvion extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        boolean datoIntent = intent.getBooleanExtra("state", false);
        if (datoIntent) {
            Log.d("modo_avion", "Modo avión ACTIVADO");
            Toast.makeText(context, "Modo avión ACTIVADO", Toast.LENGTH_LONG).show();

            //Intent implícito para abrir la app de llamadas
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:2664553747"));
            callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(callIntent);
        } else {
            Log.d("modo_avion", "Modo avión DESACTIVADO");
            Toast.makeText(context, "Modo avión DESACTIVADO", Toast.LENGTH_LONG).show();

        }

    }
}