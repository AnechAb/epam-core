package com.epam.se02.generics;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {

    private static final int INITIAL_CAPACITY = 16;
    private Object[] data = new Object[INITIAL_CAPACITY];
    private int index = 0;


    @Override
    public void add(Object value) {
        if (index == data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[index++] = value;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[index - 1];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }
}
