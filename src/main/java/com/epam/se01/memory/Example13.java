package com.epam.se01.memory;

public class Example13 {

    public static void main(String[] args) {
        ColoredPoint[] colored = new ColoredPoint[10];
        Point[] pa = colored;

        System.out.println(pa[5] == null);

        colored[0] = new ColoredPoint(1, 1, 1);
        System.out.println(pa[0] == null);
        System.out.println(pa[0] instanceof Point);
        System.out.println(pa[0] instanceof ColoredPoint);
        System.out.println(colored[0].getColor());

        pa[1] = new Point(2, 2);
        ColoredPoint point = colored[1];// exception

        System.out.println(pa[1] == null);
        System.out.println(colored[1].getColor());

        Object[] objects = pa;

//        try {
//            pa[0] = new Point();
//        } catch (ArrayStoreException e) {
//            System.out.println(e);
//        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ColoredPoint extends Point {
    int color;

    public ColoredPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}