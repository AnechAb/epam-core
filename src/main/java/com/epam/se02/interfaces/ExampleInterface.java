package com.epam.se02.interfaces;

public interface ExampleInterface {

    public static final int FIELD = 42;
}

abstract class A implements ExampleInterface{

}

class Launcher {

    public static void main(String[] args) {
//        ExampleInterface.field = 55;
        System.out.println(ExampleInterface.FIELD);
    }
}