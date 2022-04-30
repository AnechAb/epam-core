package com.epam.se01.memory;

public class Example6 {

    // local args = []
    // local i    = ref -> heap {10}

    @SuppressWarnings("UnnecessaryBoxing")
    public static void main(String[] args) {

        Integer i = new Integer(10);
        System.out.println("i1=" + i);   // 10
        changeInteger(i);
        System.out.println("i2=" + i);   // 10
    }

    // local x    = ref -> heap {10 -> 20}

    public static void changeInteger(Integer x) {
        System.out.println("x1=" + x);   // 10
        x = 20;
        System.out.println("x2=" + x);   // 10

    }
}
