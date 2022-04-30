package com.epam.se01.memory;

public class Example8 {

    public static void main(String[] args) {
        Integer val1 = Integer.valueOf(200);
        Integer val2 = Integer.valueOf(200);
        System.out.println(val1.equals(val2));

        int val3 = 10;
        int val4 = 10;
        System.out.println(val3 == val4);

        String a = new String("123");
        String b = new String("125");
        System.out.println(a == b);

    }
}
