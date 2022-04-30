package com.epam.se01.memory;

import java.util.Date;

public class Example10 {

    public static void main(String[] args) {
        Date myDate = new Date();
        System.out.println("Before: " + myDate.getDate());
        changeDate(myDate);
        System.out.println("After: " + myDate.getDate());
    }

    public static void changeDate(Date date) {
        System.out.println("  - before change: " + date.getDate());
        date.setDate(12);
        System.out.println("  - after change: " + date.getDate());

    }


}

class Example10a {

    public static void main(String[] args) {
        String[] str = {"123"};
        System.out.println("Before: " + str[0]);
        changeDate(str);
        System.out.println("After: " + str[0]);
    }

    public static void changeDate(String[] str) {
        System.out.println("  - before change: " + str[0]);
        str[0] = "aaa";
        System.out.println("  - after change: " + str[0]);

    }
}