package com.epam.se01.types;

public class Example4 {

    public static void main(String[] args) {
        Number n1 = 1;
        Number n2 = 7.1;


        Number[] array = {71, 7.1, 7L};
        Integer i1 = (Integer) n1;
        Integer i2 = (Integer) n2; // runtime error
        Integer[] i3 = (Integer[]) array; //runtime error
    }
}
