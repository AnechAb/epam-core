package com.epam.se01.operators;

public class Example10 {

    public static void main(String[] args) {
        String str1 = "1";

        System.out.println(str1.length());

        str1 = "3";
        System.out.println(str1.length());
        String str2 = "2";
        System.out.println(str2.length());

        String[] strings = {str1, str2, "abc"};
        System.out.println(strings[2]);
    }
}
