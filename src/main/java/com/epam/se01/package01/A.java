package com.epam.se01.package01;

public class A {

    static public int publicField;
    static protected int protectedField;
    static int field;
    static private int privateField;

    public static void main(String[] args) {
        System.out.println(publicField);
        System.out.println(protectedField);
        System.out.println(field);
        System.out.println(privateField);

        System.out.println(AA.publicField);
        System.out.println(AA.protectedField);
        System.out.println(AA.field);
//        System.out.println(AA.privateField);

    }

}

class AA {
    static public int publicField;
    static protected int protectedField;
    static int field;
    static private int privateField;

    public static void main(String[] args) {
        System.out.println(A.publicField);
        System.out.println(A.protectedField);
        System.out.println(A.field);
//        System.out.println(A.privateField);
    }
}