package com.xftxyz.chapter9;

import java.util.GregorianCalendar;

public class T5 {

    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();

        System.out.println("Current year, month, and day in format Mth/Day/Year: ");
        System.out.println(gregorianCalendar.get(GregorianCalendar.MONTH) + 1 + "/"
                + gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                + gregorianCalendar.get(GregorianCalendar.YEAR));

        gregorianCalendar.setTimeInMillis(1234567898765L);

        System.out.println("Elapsed time since January 1, 1970 set to 1234567898765L in format Mth/Day/Year: ");
        System.out.println(gregorianCalendar.get(GregorianCalendar.MONTH) + 1 + "/"
                + gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                + gregorianCalendar.get(GregorianCalendar.YEAR));
    }
}
