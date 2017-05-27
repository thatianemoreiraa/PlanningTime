package br.com.devqa.planningtime.model;

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
}
