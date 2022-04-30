package com.epam.se01.memory;

public class Example11 {

    public static void main(String[] args) {
        String str1 = "abc";

        String str2  = "a" + "bc";

        System.out.println(str1 == str2); //true

//        String str1 = "abc";
//        String str2 = new String("abc");
//        str2 = str2.intern();
//
//        System.out.println(str1 == str2);//true
    }

}
