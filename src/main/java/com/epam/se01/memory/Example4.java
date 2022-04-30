package com.epam.se01.memory;

public class Example4 {

    public static void main(String[] args) {
        A a = new A();

    }
}


class A {

    // header
    // 32-bits = 8 bytes
    // 64-bits = 12 bytes
    private int value1; // 4 bytes
    private int value2; // 4 bytes
    // padding = 4 bytes
}

// 8 + 12 = 20 bytes + padding = 24 bytes

class B {

    // header
    // 32-bits = 8 bytes
    // 64-bits = 12 bytes

    // reference type
    // 32-bits = 4 bytes
    // 64-bits = 8 bytes
    private int value1;     // 4 bytes
    private int[] value2;   // 8 bytes
    private String value3;  // 8 bytes
    private A value4;       // 8 bytes
    // padding = 0
}

// 8 + 8 + 8 + 16 = 48 bytes