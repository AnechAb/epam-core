package com.epam.se02.comparable;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Example1 {

    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("3d", "c", 1),
                new Student("5c", "c", 4),
                new Student("1b", "b", 10),
                new Student("2a", "a", 7)
        };

        System.out.println("Before: " + Arrays.toString(students));

        Arrays.sort(students);

        System.out.println("After: " + Arrays.toString(students));

        Arrays.sort(students, new StudentBySurnameComparator());

        System.out.println("After using comparator: " + Arrays.toString(students));

        Arrays.sort(students, new SurnameComparator());

        System.out.println("SurnameComparator: " + Arrays.toString(students));

        Arrays.sort(students, comparing(Student::getSurname).thenComparing(Student::getName));
    }
}

class StudentBySurnameComparator implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}

class StudentByNameComparator implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SurnameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getSurname().compareTo(o2.getSurname());
        if (result == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}