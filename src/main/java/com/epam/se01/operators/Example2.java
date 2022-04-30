package com.epam.se01.operators;

public class Example2 {

    public static void main(String[] args) {
        int value = 0;

        System.out.println(value | 0b0000001);

        /*
         * | 0 1
         * 0 0 1
         * 1 1 1
         *
         */

        value = 3;//0b 30 нулей и 11
        System.out.println(value &= 0b10); // 2, т.к в конце побитовое 11 И 10 -> 10 -> 2

        /*
         * & 0 1
         * 0 0 0
         * 1 0 1
         *
         */

        System.out.println(value ^ 0b11);
        /*
         * & 0 1
         * 0 0 1
         * 1 1 0
         *
         */

        System.out.println(~1);

        System.out.println(1 << 2);// 2 4 8 ...
        System.out.println(-8 >> 1);// деление на 2 4 8 ...
        System.out.println(-8 >>> 1);

        short i = -1;// 1111 1111 1111 1111
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;// 0000 0000 0011 1111
        System.out.println(0b0000000000111111);// 63
        System.out.println(i);
    }
}
