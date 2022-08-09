package com.epam.se03;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    @Test
    void matches() {
        String string = "123";
        String string2 = "a123";
        String regex = "\\d+";

        assertTrue(Pattern.matches(regex, string));
        assertTrue(string.matches(regex));
        assertFalse(Pattern.matches(regex, string2));
        assertFalse(string2.matches(regex));
    }

    @Test
    void patternMethods() {

        Pattern regex = Pattern.compile("\\d{2,}");

        String originalRegex = regex.pattern();
        assertEquals("\\d{2,}", originalRegex);

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();
        Predicate<String> startsWith1 = string -> string.startsWith("1");

        assertTrue(notEmpty.test("123"));
        assertFalse(notEmpty.test(""));

        Predicate<String> notEmptyAndStartsWith1 = notEmpty.and(startsWith1);
        assertTrue(notEmptyAndStartsWith1.test("123"));
        assertFalse(notEmptyAndStartsWith1.test("a123"));

        Predicate<String> matches = regex.asPredicate();
//        matches.test("123");

        List<String> result = Stream.of("1", "a", "123", "bbasd")
                .filter(matches)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
        assertEquals("123", result.get(0));

    }

    @Test
    void split() {
        String source = "1, 2, 3, 4       , 6";

        String[] result1 = source.split(",\\s+");

        String[] result2 = Pattern.compile(",\\s+").split(source);

        assertArrayEquals(result1, result2);

        Pattern.compile("\\s*,\\s*")
                .splitAsStream(source)
                .map(string -> "_" + string)
                .forEachOrdered(System.out::println);
    }

    @Test
    void matcher() {
        Pattern regex = Pattern.compile("(\\w+)-(\\w+)");
        Matcher matcher = regex.matcher("How to Find or Validate an Email Address - Regular-Expressions.info");
        assertFalse(matcher.matches());

        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.group(1));
            System.out.println(matcher.start(1));
            System.out.println(matcher.end(1));
            System.out.println(matcher.group(2));
        }
        System.out.println(matcher.hitEnd());
    }

    @Test
    void compile() {

        Pattern regex = Pattern.compile("\\d+");

        assertNotNull(regex);
    }

    @SuppressWarnings({"MalformedRegex", "ResultOfMethodCallIgnored"})
    @Test
    void compileIncorrectRegex() {

        assertThrows(PatternSyntaxException.class, () -> Pattern.compile("[]"));
    }

    @Test
    void example() {
        String input1 = "123.232000";
        String input2 = "123.000000";
        String input3 = "123.002300";
        String input4 = "123.123145";

        String regex = "0*$";


        assertEquals(3,getZerosAtTheEnd(input1, regex));
        assertEquals(6,getZerosAtTheEnd(input2, regex));
        assertEquals(2,getZerosAtTheEnd(input3, regex));
        assertEquals(0,getZerosAtTheEnd(input4, regex));

    }

    private int getZerosAtTheEnd(String input1, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(input1);
        if (matcher.find()) {
            return matcher.group().length();
        }
        return 0;
    }
}
