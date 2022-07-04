package com.epam.se02.generics;

public class Example1 {

    public static void main(String[] args) {
        Queue<Number> numberQueue = new ArrayQueue<Number>();
        numberQueue.put(1);
        Number value = numberQueue.poll();


        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        Queue<? extends Number> numberChidQueue1 = integerArrayQueue;

        Number num = 44d;
//        numberChidQueue1.put(null);// остальное не пускает

        Queue<? super Number> numberParentQueue1 = new ArrayQueue<Number>();
        ArrayQueue<Object> objectArrayQueue = new ArrayQueue<>();
        objectArrayQueue.put("123");
        Queue<? super Number> numberParentQueue2 = objectArrayQueue;
        Object poll = numberParentQueue2.poll();

        numberParentQueue1.put(null);
//        numberParentQueue1.put(new Object());
        numberParentQueue1.put(1);
        numberParentQueue1.put(1d);
        numberParentQueue1.put(1f);




    }

    private static Number sum(Queue<? extends Number> queue){

        double result = 0;
        while (!queue.isEmpty()){
            result += queue.poll().doubleValue();
        }

        return result;
    }
}
