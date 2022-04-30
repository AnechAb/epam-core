package com.epam.se01.memory;

import com.epam.se01.main.Student;

import java.util.Arrays;

public class Example12 {


    /**
     * 123
     */
    public static final String VERSION = "VERSION 1.0";

    /**
     *
     * @param args
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */

    public static void main(String[] args) throws IllegalStateException, IllegalArgumentException{
//        int arr1[][] = { //или int[] arr1[] - не надо
//                {1, 2, 3},
//                {1, 2, 3}
//        };

//        int[][] arr = { // правильнее по стилю
//                {1, 2, 3},
//                {1, 2, 3}
//        };

            for (int value : getValues()) {
                System.out.println(value);
            }

        int[] values = {1, 2, 3};

        int[] clone = values.clone();

        values[0] = -1;
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(clone));


        Student[] students = {
                new Student("a","a", 1),
                new Student("b","b", 2)
        };

        Student[] clone1 = students.clone();
        clone1[0].setAge(3);

        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(clone1));

    }

    /**
     * Version = {@value Example12#VERSION}
     * @return
     */

    private static int[] getValues(){
        return new int[0];
    }

//      Было ->
//    /**
//     * Проверка: редактируема ли данная ячейка.
//     *
//     * <p>В случае если данная ячейка редактируема - возвращается true</p>
//     *
//     * <p>В случае если данная ячейка не редактируема - возвращается false</p>
//     *
//     * @param column
//     *              номер колонки для проверки
//     * @return результат проверки
//     **/
//      Стало ->
    /**
     * Редактируема ли данная ячейка.
     * @param column номер колонки для проверки
     * @return true - ячейка редактируема, иначе - false
     */
    public static boolean isCellEditable(int column) {
        return column % 2 == 0;
    }

}
