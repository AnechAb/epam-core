package com.epam.se01.memory;

import java.util.concurrent.ThreadLocalRandom;

public class Example2 {

    public static void main(String[] args) {
        method(0);
    }

    public static void method(int value) {
        double randomValue = ThreadLocalRandom.current().nextDouble();
        System.out.println(value + " " + randomValue);
        method(value + 1);
    }
}
