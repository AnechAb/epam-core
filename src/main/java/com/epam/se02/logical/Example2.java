package com.epam.se02.logical;

public class Example2 {

    static {
        System.out.println("Static-1 before: " + Example2.staticField);
    }

    static final int staticField;

    static {
        System.out.println("Static-2 after: " + Example2.staticField);
        staticField = 50;
    }

    {
        System.out.println("Non-Static-1 before: " + this.field);
    }

    int field = 55; //final

    {
        System.out.println("Non-Static-2 after: " + this.field);
        field = 60;
    }

    public Example2(int value) {
        System.out.println("Constructor: " + field);
        field = value;
    }
}

class Launcher2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before sleep");
        Thread.sleep(5_000);
        System.out.println("After sleep");

        synchronized (Launcher.class) {
            Example2 Example2 = new Example2(1000);
            System.out.println(Example2.field);
        }
    }
}
