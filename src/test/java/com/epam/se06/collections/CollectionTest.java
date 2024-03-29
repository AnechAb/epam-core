package com.epam.se06.collections;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CollectionTest {

    @Test
    void name() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> result = source.stream()
                                     .filter(value -> value > 3)
                                     .collect(Collectors.toList());

        assertThat(source, contains(1, 2, 3, 4, 5));
        assertThat(result, contains(4, 5));

        source.removeIf(value -> value < 4);
        assertThat(source, contains(4, 5));

        source.forEach(out::println);

    }

    private static void print(Object object) {
        out.println(object);
    }
}
