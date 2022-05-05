package com.epam.se02.logical;

public class LogicalBlock {

    {
        System.out.println("1: " + this.x); //0
        x = 5;
//        System.out.println(x);// ошибка, forward reference
        System.out.println("2: " + this.x); //5

    }

    private int x = 89;

    {
        System.out.println("3: " + x);
        x = 20;
    }

    public LogicalBlock() {
    }

//    {
//        x = 30;
//    }

    public LogicalBlock(int x) {
        System.out.println("In constuctor: " + this.x);
        this.x = x;
    }

    public int getX() {
        return x;
    }

//    {
//        x = 40;
//    }
}

class Launcher {

    public static void main(String[] args) {
        LogicalBlock ref1 = new LogicalBlock();
        System.out.println(ref1.getX());

        LogicalBlock ref2 = new LogicalBlock(10);
        System.out.println(ref2.getX());
    }
}