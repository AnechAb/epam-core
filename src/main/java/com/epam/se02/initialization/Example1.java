package com.epam.se02.initialization;

public class Example1 {

    static {
        System.out.println("Static-1 before: " + Example1.staticField);
    }

    static int staticField = 42;

    static {
        System.out.println("Static-2 after: " + Example1.staticField);
        staticField = 50;
    }

    {
        System.out.println("Non-Static-1 before: " + this.field);
    }

    int field = 55;

    {
        System.out.println("Non-Static-2 after: " + this.field);
        field = 60;
    }

    public Example1(int value) {
        System.out.println("Constructor: " + field);
        field = value;
    }
}

class Launcher {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before sleep");
        Thread.sleep(5_000);
        System.out.println("After sleep");

//        System.out.println(Example1.staticField);

        Example1 example1 = new Example1(1000);
        System.out.println(example1.field);
    }
}