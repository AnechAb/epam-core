package com.epam.se01.types;

public class Example3 {

    public static void main(String[] args) {
        Integer a = 50;
        Number num = a;

        Double c = 5.5;
        num = c;


        Integer b = (Integer) num; // нельзя без каста
        System.out.println(b);

    }
}
