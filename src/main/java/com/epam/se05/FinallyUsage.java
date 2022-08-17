package com.epam.se05;

public class FinallyUsage {

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception thrown");
        }
        System.out.println(procB());
        System.out.println(procC());
    }

    static void procA() {
        try {
            System.out.println("Inside procA");
            if (true) {
                throw new RuntimeException("demo");
            }
        } finally {
            System.out.println("finally for procA ");
        }
        System.out.println("procA::after try");
    }

    static int procB() {
        try {
            System.out.println("Inside procB");
            return 10;
        } finally {
            System.out.println("finally for procB ");
            return 20;
        }
    }

    static int procC() {
        try {
            System.out.println("Inside procC");
            throw new RuntimeException("demo");
        } catch (RuntimeException ex) {
            return 50;
        } finally {
            System.out.println("finally procC");
            throw new RuntimeException("demo2");
        }
    }
}
