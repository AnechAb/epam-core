package com.epam.se01.main;

public class Student {

    private String name;
    private String surname;
    private int age;

    public Student(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void method(){
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

class Launcher {

    public static void main(String[] args) {
        Student student = new Student("Vasiliy", "Ivanov", 30);
        System.out.println("Student: " + student);
    }
}