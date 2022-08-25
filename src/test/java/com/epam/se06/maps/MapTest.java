package com.epam.se06.maps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.jupiter.api.Assertions.*;

/**
 * O(1) ~ (n)   put(K, V)
 * O(1) ~ (n)   get(Object)
 * O(1) ~ (n)   remove(Object)
 * After Java 8:
 * O(1) ~ (log(n))   put(K, V)
 * O(1) ~ (log(n))   get(Object)
 * O(1) ~ (log(n))   remove(Object)
 */
public class MapTest {
    @Test
    void putNullValue() {
        Map<Integer, String> map = new HashMap<>(0, 100000f);

        assertNull(map.put(1, "1"));
        assertEquals("1", map.put(1, "11"));

        assertNull(map.put(2, "2"));
        assertEquals("2", map.put(2, "22"));

        assertNull(map.put(3, null));
        assertTrue(map.containsKey(3));
        assertNull(map.put(3, "22"));
        assertTrue(map.containsValue("22"));

        assertNull(map.put(null, "null"));
        assertTrue(map.containsKey(null));

        System.out.println(map);

        Set<Integer> integers = map.keySet();
        integers.remove(3);

        System.out.println(map);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

    }

    @Test
    void name() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(5, "abc");
    }

    @Test
    void linkedHashMap() {
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("123", "123");
        hashMap.put("abc", "abc");
        hashMap.put("qw45", "qw45");
        System.out.println(hashMap);

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    void treeMap() {

        TreeMap<A, Integer> map = new TreeMap<>(Comparator.comparing(A::getStr));
        map.put(new A(3, "c"), 3);
        map.put(new A(4, "b"), 4);
        map.put(new A(1, "a"), 1);
        map.put(new A(2, "d"), 2);

        System.out.println(map);
    }

    @Test
    void identity() {
        Map<A, String> map = new IdentityHashMap<>();

        A a1 = new A(1, "a");
        A a2 = new A(1, "a");
        assertNotSame(a1, a2);
        assertEquals(a1, a2);

        map.put(a1, "value");
        assertNotNull(map.get(a1));
        assertNull(map.get(a2));
    }

    @Test
    void containsEntryWithCondition() {
        Map<String, Integer> source = new HashMap<>();

//        source.put("World1", 80);
        source.put("Hello1", 42);
        source.put("Hello2", 73);

        assertThat(source, hasEntry(startsWith("Hello"), greaterThan(50)));

//        boolean entryFound = false;
//        for (Map.Entry<String, Integer> entry : source.entrySet()) {
//            if (entry.getKey().startsWith("Hello") && entry.getValue() > 50){
//                entryFound = true;
//                break;
//            }
//        }
//        assertTrue(entryFound);

    }

    @Test
    void putIf() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);

        assertThat(map, hasEntry("1", 1));

        map.putIfAbsent("1", 11);
        assertThat(map, hasEntry("1", 1));

//        if (!map.containsKey("1")){
//            map.put("1", 11);
//        }

        map.computeIfAbsent("3", Integer::valueOf);
        assertThat(map, hasEntry("3", 3));

        map.computeIfAbsent("3", s -> Integer.valueOf(s + s));
        assertThat(map, hasEntry("3", 3));

        map.computeIfPresent("3", (key, prev) -> prev + 1);
        assertThat(map, hasEntry("3", 4));

        map.compute("4", (key, prev) -> prev == null ? 42 : 0);
        assertThat(map, hasEntry("4", 42));

        map.compute("4", (key, prev) -> prev == null ? 42 : 0);
        assertThat(map, hasEntry("4", 0));

        map.replaceAll((key, value) -> -value);
        assertThat(map, both(hasEntry("1", -1)).and(hasEntry("3", -4)));

        map.forEach((string, value) -> System.out.println(string + " " + value));

        Integer val = map.getOrDefault("195", 195);
        assertThat(val, is(195));
    }

    @Test
    void mergeMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("1", 1);
        map1.put("2", 2);


        Map<String, Integer> map2 = new HashMap<>();
        map1.put("1", 1);
        map2.put("3", 3);
        map2.put("4", 4);

        Map<String, Integer> map3 = new HashMap<>(map2);
        map1.forEach((key, value) -> map3.merge(key, value, Integer::sum));

//        map1.forEach((key1, value) -> map3.compute(key1, (key, prev) -> value + (prev == null ? 0 : prev)));



    }
}

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
class A implements Comparable<A> {
    int field;
    String str;

    @Override
    public int compareTo(A other) {
        return Integer.compare(field, other.field);
    }
}
