package com.epam.se03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createStudent() {
        Student.StudentBuilder ivan = Student.builder()
                                             .age(24);
        Student result = ivan
                                             .name("Ivan")
                                             .surname("Ivanov")
                                             .build();


        Student a = new Student(1, "a", "2");
    }
}