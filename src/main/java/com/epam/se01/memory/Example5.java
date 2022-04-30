package com.epam.se01.memory;

import java.util.concurrent.ThreadLocalRandom;

public class Example5 {

    private static int staticIntDefaultValue;
    private static double doubleDefaultValue;
    private static String stringDefaultValue;

    // header = 12
    private int dynamicIntvalue; // 4

    public static void main(String[] args) {
//        int a;
//        if (ThreadLocalRandom.current().nextBoolean()){
//            a = 10;
//        } else {
//            a = 20;
//        }
//        System.out.println(a);
//
//        System.out.println(staticIntDefaultValue);
//        System.out.println(doubleDefaultValue);
//        System.out.println(stringDefaultValue);

//        int _ = 4;

        Example5 example5_1 = new Example5();
        example5_1.dynamicIntvalue = 1;
        example5_1.staticIntDefaultValue = 10;

        Example5 example5_2 = new Example5();
        example5_2.dynamicIntvalue = 2;
        example5_2.staticIntDefaultValue = 20;


        Example5 example5_3 = new Example5();
        example5_3.dynamicIntvalue = 3;
        example5_3.staticIntDefaultValue = 30;

        System.out.println(example5_1.staticIntDefaultValue); // 30
        System.out.println(example5_2.staticIntDefaultValue); // 30
        System.out.println(example5_3.staticIntDefaultValue); // 30
        System.out.println(Example5.staticIntDefaultValue);   // 30

    }
}
