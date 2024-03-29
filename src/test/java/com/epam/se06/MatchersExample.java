package com.epam.se06;

import lombok.Value;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MatchersExample {

    @Test
    void numbersMatchers() {
        assertThat(0.55555, closeTo(0.5, 0.1));
        assertThat(5, equalTo(5));
        assertThat(5, equalToObject(5));
    }

    @Test
    void objectMatchers() {
        assertThat(10, hasToString("10"));
        assertThat(10, instanceOf(Number.class));
        assertThat(10, any(Number.class));
        assertThat(10, notNullValue());
        assertThat(null, nullValue());

        Integer[] values = {1, 2, 3, 6, 2, 1, 10};
        assertThat(6, in(values));
        assertThat(6, oneOf(1, 2, 3, 6, 2, 1, 10));
    }

    @Test
    void stringMatchers() {
        assertThat("11111 22222", matchesPattern("1+\\s2+"));

        A object = new A(42, true);
        assertThat(object, hasProperty("value", both(greaterThan(40)).and(lessThan(60))));
        assertThat(object, hasProperty("flag", is(true)));
    }

    @Test
    void arrays() {
        String[] strings = {"adfggb", "123", "   ", null};

        assertThat(strings, array(startsWith("a"), matchesPattern("\\d+"), blankString(), nullValue()));
        assertThat(strings, arrayWithSize(4));
        assertThat(strings, hasItemInArray(allOf(startsWith("a"), endsWith("b"))));

    }
}

