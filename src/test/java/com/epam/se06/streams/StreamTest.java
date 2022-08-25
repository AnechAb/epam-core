package com.epam.se06.streams;

import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StreamTest {

    private Collection<Employee> employees;

    @BeforeEach
    void createEmployees() {
        employees = getEmployees();
    }

    @Test
    void name() {
        long countIvans = employees.stream()
                                   .map(Employee::getPerson)
                                   .filter(person -> person.getFirstName().equals("Иван"))
                                   .peek(System.out::println)
                                   .count();

        System.out.println(countIvans);


//        int countIvans = 0;
//        for (Employee employee : employees) {
//            Person person = employee.getPerson();
//            if (person.getFirstName().equals("Иван")) {
//                System.out.println(person.getFullName());
//                ++countIvans;
//            }
//        }
//        System.out.println(countIvans);
    }

    @Test
    void name1() {
        Stream<Employee> stream1 = employees.stream();
        Stream<Employee> stream2 = stream1.filter(employee -> !employee.getJobHistory().isEmpty());
        Stream<Employee> stream3 = stream2.filter(employee -> employee.getJobHistory()
                                                                      .get(0)
                                                                      .getEmployer()
                                                                      .equals("EPAM"));
        assertThat(stream1, is(not(sameInstance(stream2))));
        assertThat(stream2, is(not(sameInstance(stream3))));
        stream3.forEach(System.out::println);
    }

    @Test
    void name2() {
        Function<String, Integer> extractLengthFromString = String::length;
        Integer length1 = extractLengthFromString.apply("123");
        Integer length2 = extractLengthFromString.apply("123456");

        ToIntFunction<String> extractLengthFromString2 = String::length;
        IntFunction<String> convertIntToString = String::valueOf;

        IntFunction<Person[]> generator = Person[]::new;

        Person[] arr1 = generator.apply(10);
        assertThat(arr1, arrayWithSize(10));
        Person[] arr2 = generator.apply(10);
        assertThat(arr1, arrayWithSize(10));
        assertThat(arr1, is(not(sameInstance(arr2))));

        Person[] arr3 = generator.apply(20);
        assertThat(arr1, arrayWithSize(20));

        Person[] people = employees.stream()
                                   .map(Employee::getPerson)
                                   .filter(person -> person.getAge() > 25)
                                   .toArray(Person[]::new);

        assertThat(people, arrayWithSize(5));
    }

    @Test
    void name3() {
        Set<String> result = Stream.of(10, 2, 3000, 4, 4, 5)
                                   .sorted()
                                   .map(String::valueOf)
                                   .filter(str -> str.length() < 4)
                                   .collect(Collectors.toSet());
        assertThat(result, containsInAnyOrder("10", "2", "4", "5"));
    }

    @Test
    void name4() {
        String[] strings = {"1", "2", "3"};
        assertThat(Stream.of(strings).count(), is(3L));
    }

    @Test
    void name5() {
        Random random = new Random();
        boolean result = Stream.generate(() -> random.nextInt(100))
                          .peek(System.out::println)
                          .filter(value -> value > 49)
                          .allMatch(value -> value < 90);

        assertThat(result, is(false));

    }

    @Test
    void name6() {
    }

    private static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(
                        new Person("Иван", "Мельников", 30),
                        Arrays.asList(
                                new JobHistoryEntry(2, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Александр", "Дементьев", 28),
                        Arrays.asList(
                                new JobHistoryEntry(1, "tester", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Дмитрий", "Осинов", 40),
                        Arrays.asList(
                                new JobHistoryEntry(3, "QA", "yandex"),
                                new JobHistoryEntry(1, "QA", "mail.ru"),
                                new JobHistoryEntry(1, "dev", "mail.ru")
                        )),
                new Employee(
                        new Person("Анна", "Светличная", 21),
                        Collections.singletonList(
                                new JobHistoryEntry(1, "tester", "T-Systems")
                        )),
                new Employee(
                        new Person("Игорь", "Толмачёв", 50),
                        Arrays.asList(
                                new JobHistoryEntry(5, "tester", "EPAM"),
                                new JobHistoryEntry(6, "QA", "EPAM")
                        )),
                new Employee(
                        new Person("Иван", "Александров", 33),
                        Arrays.asList(
                                new JobHistoryEntry(2, "QA", "T-Systems"),
                                new JobHistoryEntry(3, "QA", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM")
                        ))
        );
    }
}

@Value
class Person {

    String firstName;
    String lastName;
    int age;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

@Value
class JobHistoryEntry {

    int duration;
    String position;
    String employer;
}

@Value
class Employee {

    private final Person person;
    private final List<JobHistoryEntry> jobHistory;
}
