package com.epam.se01.operators;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Example4 {

    public static void main(String[] args) {
        float val1 = 0f / 0f; //error, т.к 0 и 0 - ints, нужны 0f и 0f
        float val2 = 0f / 0f;
        Float val3 = 0f / 0f;
        Float val4 = 0f / 0f;
        Float val5 = Float.NaN;
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val1 == val2);
        System.out.println(val3 == val4);
        System.out.println(val4 == val5);
        System.out.println(val4.equals(val5));

        System.out.println(val3.equals(Float.NaN));
        System.out.println(Float.isNaN(val3));
        System.out.println(Float.isInfinite(val3));
        System.out.println(val3 > 0);

        System.out.println(Double.MAX_VALUE + Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        System.out.println(abs(PI * 3 + PI));
    }
}
