package com.epam.se02.classes;

import com.epam.se02.generics.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedQueue<>();
        queue.put("a");
        queue.put("b");
        queue.put("c");

        for (String aList : queue) {
            System.out.println(aList);
        }
    }
}
