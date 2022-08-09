package com.epam.se05;

import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

public class Example2 {



    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.epam.se05.Nested");
            Constructor<?> constructor = clazz.getConstructor();
            constructor.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


        Function<String, String> readFile = Example2::readFile;


            String content = readFile.apply("text.txt");
            proccessText(content);
    }

    @SneakyThrows
    private static String readFile(String fileName) {
        // TODO read file
        if(true){
            throw new FileNotFoundException(fileName);
        }
        return "123";
    }

    private static void proccessText(String content) {
        //...
    }
}

abstract class Nested{

    public Nested() {
        System.out.println("Nested::ctor");
    }
}
