package com.epam.se01.memory;

public class Example3 {

    public static void main(String[] args) {
        int arrLength = Integer.parseInt(args[0]);
        int[] arr = new int[arrLength];

        method(arr, 0);
    }

    public static void method(int[] values, int level) {
        System.out.println(level);
        method(values, level + 1);
    }
}
