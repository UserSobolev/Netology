package com.sobolev;

public class Compare {
    public static void compareValue(double value1, float value2) {
        if (Math.abs(value1 - value2) < 0.0000001) {
            System.out.println("Числа равны");
        } else if (value1 > value2) {
            System.out.println("Числа не равны, большее число - " + value1);
        } else if (value1 < value2) {
            System.out.println("Числа не равны, большее число - " + value2);
        }
    }
}
