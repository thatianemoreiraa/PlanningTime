package br.com.devqa.planningtime.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tatiane on 27/05/2017.
 */

public class Util {

    public static Date stringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
        try {
            return (Date) format.parse(date);
        } catch (ParseException e) {
            Log.e("DATE_FORMAT", e.getStackTrace().toString());
            return null;
        }
    }

    public static int obterIdUsuario(Intent intent) {
       return Integer.parseInt(intent.getStringExtra("idUsuario"));
    }

    public static Intent enviarIntentComIdUsuario(Context context, Class<?> cls, String idUsuario) {
        Intent intent = new Intent();
        intent.putExtra("idUsuario", idUsuario);
        intent.setClass(context, cls);
        return intent;
    }
}
