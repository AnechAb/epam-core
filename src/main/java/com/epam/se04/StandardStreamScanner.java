package com.epam.se04;

import java.util.Scanner;

public class StandardStreamScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());

        scanner.close();

//        System.in.read();

    }
}
