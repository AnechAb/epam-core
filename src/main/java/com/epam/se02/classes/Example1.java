package com.epam.se02.classes;

import com.epam.se02.generics.Queue;

import java.util.ArrayList;
import java.util.Iterator;

public class Example1 {

    public static void main(String[] args) {
        queue();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        list.clear();


//        for (String aList : queue) {
//            System.out.println(aList);
//        }
    }

    private static void queue() {
        Queue<String> queue = new LinkedQueue<>();
        queue.put("a");
        queue.put("b");
        queue.put("c");

        Iterator<String> iterator = queue.iterator();

        queue.poll();

//        assert queue.isEmpty();
        System.out.println(iterator.next());
    }
}
