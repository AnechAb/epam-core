package com.epam.se02;

public class Example3 {

    public static void main(String[] args) {
        System.out.println("123");

        Point2D point2D = new Point2D(1, 2);
        point2D.getX();

        point2D.print();
        Point2D.print();
    }

}

class Point2D{

    private int x;
    private int y;

    public Point2D(int x, int y) {
//        super();// генерит компилятор
        this.x = x;
        this.y = y;
    }

    public Point2D(int size) {
        this(size, size);
    }

    public int getX(Point2D this) {
        return this.x;
    }

    public static  void print(){
        Math.pow(2, 3);
//        System.out.println("It's static method" + this.x + " " + this.y);// нельзя
    }
}
