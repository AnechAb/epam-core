package com.epam.se02.generics;

import java.util.NoSuchElementException;

public class QueueTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    private static void test1() {
        Queue queue = new ArrayQueue();

        assert queue.isEmpty();

        System.out.println("Test1 passed");

    }

    private static void test2() {
        Queue queue = new ArrayQueue();

        try {
            queue.peek();
            assert false;
        } catch (Exception ex){
            assert ex instanceof NoSuchElementException;
        }

        System.out.println("Test2 passed");

    }

    private static void test3() {
        Queue queue = new ArrayQueue();

        try {
            queue.poll();
            assert false;
        } catch (Exception ex){
            assert ex instanceof NoSuchElementException;
        }

        System.out.println("Test3 passed");

    }

    private static void test4() {
        // prepare
        Queue queue = new ArrayQueue();

        //run
        int value = 1;
        queue.put(value);
        Object result = queue.peek();

        //asserts
        assert result.equals(value);
        assert !queue.isEmpty();

        System.out.println("Test4 passed");

    }

    private static void test5() {
        Queue queue = new ArrayQueue();

        int value = 1;
        queue.put(value);
        Object result = queue.poll();

        assert result.equals(value);
        assert queue.isEmpty();

        System.out.println("Test5 passed");
    }

    private static void test6() {
        Queue queue = new ArrayQueue();

        int value1 = 1;
        int value2 = 2;
        queue.put(value1);
        queue.put(value2);
        Object result1 = queue.poll();
        Object result2 = queue.poll();

        assert result1.equals(value1);
        assert result2.equals(value2);
        assert queue.isEmpty();

        System.out.println("Test6 passed");

    }

    private static void test7() {
        Queue queue = new ArrayQueue();

        String str = "123";
        queue.put(str);
        String result = (String) queue.poll();

        assert result.length() == 3;
        assert queue.isEmpty();

        System.out.println("Test7 passed");

    }

    private static void test8() {
        Queue stringQueue = new ArrayQueue();

        String str = "123";
        stringQueue.put(str);

        devilMethod(stringQueue);

        String result = (String) stringQueue.poll();

        assert result.length() == 3;
        assert stringQueue.isEmpty();

        System.out.println("Test8 passed");

    }

    private static void devilMethod(Queue queue) {
        queue.poll();
        queue.put(1);
    }
}
