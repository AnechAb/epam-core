package com.epam.se02.generics;

public class Example1 {

    public static void main(String[] args) {
        Queue<Number> numberQueue = new ArrayQueue<Number>();
        numberQueue.put(1);
        Number value = numberQueue.poll();


        Queue<? extends Number> numberChidQueue1 = new ArrayQueue<Integer>();
        Queue<? extends Number> numberChidQueue2 = new ArrayQueue<Double>();
        Queue<? extends Number> numberChidQueue3 = new ArrayQueue<Number>();

        numberChidQueue1.put(null);// остальное не пускает
    }

    private static Number sum(Queue<? extends Number> queue){

        double result = 0;
        while (!queue.isEmpty()){
            result += queue.poll().doubleValue();
        }
        
        return result;
    }
}
