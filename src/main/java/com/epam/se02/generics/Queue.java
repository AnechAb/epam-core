package com.epam.se02.generics;

// put(1)
// put(2)
// put(3)

// poll() 1
// poll() 2
// poll() 3
public interface Queue {

    void add(Object value);

    Object poll();

    Object peek();

    boolean isEmpty();
}
