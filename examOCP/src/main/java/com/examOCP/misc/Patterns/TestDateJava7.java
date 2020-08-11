package com.examOCP.misc.Patterns;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDateJava7 {
    public static void main( String[] args )
    {
       dateToCalendar();
    }

    private static void dateToCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String dateInString = "31-01-2020 15:02:56.1231111111";
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("UTC") );
            Date date = sdf.parse(dateInString);

            System.out.println(sdf.format(date));

            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(date);

            calendar = Calendar.getInstance();
            Date dateCon = calendar.getTime();

            System.out.println(sdf.format(dateCon));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
