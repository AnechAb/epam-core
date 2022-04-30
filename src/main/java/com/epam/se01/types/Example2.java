package com.epam.se01.types;

public class Example2 {

    public static void main(String[] args) {
        long value = 0b0101111L;

        String lineSeparator = System.lineSeparator();

        byte val1 = 0;
        byte val2 = 50;
//        byte val3 = val1 + val2; // нельзя
        byte val3 = (byte)(val1 + val2);

        long val4 = 50;
        long val5 = 50;
        long val6 = val4 + val5;

    }
}
