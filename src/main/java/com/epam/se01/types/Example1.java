package com.epam.se01.types;

public class Example1 {

    public static void main(String[] args) {
        int val = (int)2_200_000_000L; // часть информации потеряем

        int val2 = 0;
        val2 += 1;
        val2 += 2_200_000_000L; // компилятор съест
        System.out.println(val2);
    }
}
