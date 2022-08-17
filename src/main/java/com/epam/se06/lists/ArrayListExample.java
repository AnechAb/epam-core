package com.epam.se06.lists;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    /**
     *
     * O(1)         size()
     * O(1) ~ (n)   contains(E)
     * O(1)         get(index)
     * O(1)         set(index)
     * O(n)         remove(E)
     * O(1) ~ (n)   remove(index)
     * O(1)         add(E, index)
     * O(1) ~ (n)   add(E)
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("hello");

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);

        out.writeObject(strings);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()));
        List object = (List) in.readObject();
        System.out.println(object);

        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.remove(Integer.valueOf(2));
    }
}
