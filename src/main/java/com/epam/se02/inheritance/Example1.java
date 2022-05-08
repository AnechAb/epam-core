package com.epam.se02.inheritance;

public class Example1 {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getField());
    }

}


class A {

    static {
        System.out.println("A::static block");
    }

    {
        System.out.println("A::logical block (1)" + this.field);
    }

    private int field = 42;

    {
        System.out.println("A::logical block (2)" + this.field);
    }

    public int getField() {
        return field;
    }

    public A() {
        System.out.println("A::constructor");
    }
}

class B extends A {

    static {
        System.out.println("B::static block");
    }

    {
        System.out.println("B::logical block");
    }

    public B() {
        System.out.println("B::constructor");
    }

    public void doSmth() {
//        System.out.println(field);
    }

}