package com.sample.accesscontrol.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHora {
    
    public static String getDia() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(now);
    }

    public static String getHorario() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(now);
    }
}
