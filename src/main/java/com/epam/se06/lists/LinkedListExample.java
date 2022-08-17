package com.epam.se06.lists;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    /**
     *
     * O(1)         size()
     * O(1) ~ (n)   contains(E)
     * O(1) ~ (n/2) get(index)
     * O(1) ~ (n/2) set(index)
     * O(1) ~ (n)   remove(E)
     * O(1) ~ (n/2) remove(index)
     * O(1)         removeFirst()
     * O(1)         removeLast()
     * O(1) ~ (n/2) add(E, index)
     * O(1)         addFirst()
     * O(1)         addLast() == add(E)
     */
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("hello");

        strings.addFirst("world");
    }
}

