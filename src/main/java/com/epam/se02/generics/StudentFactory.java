package com.epam.se02.generics;

@FunctionalInterface
public interface StudentFactory {

    Student create(int weught, int age, String name, int course);

}
