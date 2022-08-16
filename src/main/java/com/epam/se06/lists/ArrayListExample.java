package com.epam.se06.lists;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

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
    }
}
