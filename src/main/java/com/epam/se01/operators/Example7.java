package com.epam.se01.operators;

public class Example7 {

    public static void main(String[] args) {
        int value = 70;

        switch (value) {
            case 10: {
                int a = 10;
                System.out.println(a);
                break;
            }

            case 20: {
                int a = 20;
                System.out.println(a);
                break;
            }

            case 30:
                int b = 10;
                System.out.println("3");
                break;

            default:
                b = 20;
                System.out.println(b);
                System.out.println("Default");

            case 40:
                System.out.println("4");
                break;
        }
    }
}
