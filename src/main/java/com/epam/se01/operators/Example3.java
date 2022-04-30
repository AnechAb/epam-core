package com.epam.se01.operators;

public class Example3 {

    public static void main(String[] args) {
        if (left() & right()){
            System.out.println("Here 1");
        }

        if (left() && right()){
            System.out.println("Here 2");
        }

        if (left()) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }

        //int val = left() ? 1 : "1"; // нельзя
        Object val = left() ? 1 : "1"; // можно, обертки
        System.out.println(val);
        System.out.println(left() ? 1 : "1"); // можно
        //boolean condition = left();// нужна ли?
        System.out.println(left() ? "False" : "True");
        System.out.println(left() ? "False" : right() ? "True" : "123");// if внутри if, бинарное дерево
    }

    public static boolean left(){
        System.out.println("Called left");
        return false;
    }

    public static boolean right(){
        System.out.println("Called right");
        return true;
    }
}
