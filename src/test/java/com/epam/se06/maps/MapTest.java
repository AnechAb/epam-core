package com.epam.se06.maps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
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
    void treeMap(){

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
        assertEquals(a1,a2);

        map.put(a1, "value");
        assertNotNull(map.get(a1));
        assertNull(map.get(a2));
    }
}

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
class A implements Comparable<A>{
    int field;
    String str;

    @Override
    public int compareTo(A other) {
        return Integer.compare(field, other.field);
    }
}
