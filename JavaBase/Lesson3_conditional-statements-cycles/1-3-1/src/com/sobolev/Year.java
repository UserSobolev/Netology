package com.sobolev;

public class Year {

    public static int calculatorDays(int year) {
        if ((year % 400) == 0) {
            return 366;
        } else if ((year % 4) == 0 && (year % 100) > 0) {
            return 366;
        } else {
            return 365;
        }
    }
}
