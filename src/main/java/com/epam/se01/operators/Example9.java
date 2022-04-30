package com.epam.se01.operators;

public class Example9 {

    public static void main(String[] args) {
        String stringValue = "10";

        // строка -> в число
        double doubleValue = Double.valueOf(stringValue);
        float floatValue = Float.valueOf(stringValue);
        int intValue = Integer.valueOf(stringValue);
        System.out.println(intValue);
        System.out.println(Integer.parseInt(stringValue, 16));

        // число -> в строку
        String anotherStringVal = String.valueOf(intValue);
        System.out.println(stringValue.equals(anotherStringVal)); // начальная и конечная строки равны

//        String str = "" + intValue; // работает, но лучше не использовать
        String str1 = String.valueOf(intValue);// правильный вариант, менее загруженный
        String str = "" + 10;
        System.out.println(str);

        str = "1" + 10 + 20;
        System.out.println(str);// не очевидно 11020

        str = String.valueOf(10) + String.valueOf(20);
        System.out.println(str);// 1020

        str = 10 + 20 + "1"; // 301 <- 30 + 1 как строки
        System.out.println(str);

        str = 'a' + 10 + "bc";
        System.out.println(str); // 107bc т.к a = 97

        str = (char)('a' + 10) + "bc";
        System.out.println(str); // kbc

        str = Character.toString('a') + 10 + "bc";
        System.out.println(str); //

        str = String.valueOf('a') + 10 + "bc";
        System.out.println(str); //

    }
}
