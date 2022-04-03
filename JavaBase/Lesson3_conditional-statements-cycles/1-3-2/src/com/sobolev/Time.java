package com.sobolev;

public class Time {
    public static int calculatorTime(int qtyDays, int qtyHours, int qtyMinutes) {
        int time1 = qtyDays * 24 * 60 * 60;
        int time2 = qtyHours * 60 * 60;
        int time3 = qtyMinutes * 60;
        return time1 + time2 + time3;
    }
}
