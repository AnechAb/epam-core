package com.epam.se02.generics;

// put(1)
// put(2)
// put(3)

import java.util.NoSuchElementException;

// poll() 1
// poll() 2
// poll() 3
public interface Queue<E> extends Iterable<E> {

    void put(E value);

    E poll() throws NoSuchElementException;

    /**
     * @return Element from head (without delete)
     * @throws NoSuchElementException When queue is empty
     */
    E peek() throws NoSuchElementException;

    boolean isEmpty();
}
