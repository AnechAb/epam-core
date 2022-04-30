package com.epam.se01.operators;

import com.epam.se01.package02.B;

import java.io.Serializable;

public class Example8 {

    public static void main(String[] args) {
        doLogic(new BaseCourse());      // BaseCourse
        doLogic(new OptionalCourse());  // OptionalCourse
        doLogic(new FreeCourse());      // BaseCourse
        doLogic("123");              // Что-то другое

        if ("123" instanceof Serializable) {
            System.out.println("This is string!");
        }
    }

    private static void doLogic(Object object) {
        if (object instanceof BaseCourse) {
            System.out.println("BaseCourse" + ((BaseCourse)object).getLevel());
        } else if (object instanceof OptionalCourse) {
            System.out.println("OptionalCourse");
        } else {
            System.out.println("Что-то другое");
        }
    }
}

class Course extends Object {}
class BaseCourse extends Course {
    public int getLevel(){
        return 4;
    }
}
class FreeCourse extends BaseCourse {}
class OptionalCourse extends Course {}

