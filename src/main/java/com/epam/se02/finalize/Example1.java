package com.epam.se02.finalize;

public class Example1 {

    @Override
    protected void finalize() throws Throwable {
        while (true) {
            System.out.println("I'm finalize!");
        }
    }
}

class Launcher {
    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(10_000);

        Example1 ref = new Example1();

        System.out.println(ref.toString());

        ref = null;

        Runtime.getRuntime().gc();

        System.out.println(ref);
    }
}
