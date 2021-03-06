package com.epam.se02.classes;

import com.epam.se02.generics.Queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private int modCount = 0;

    @Override
    public void put(T value) {
        Node<T> added = new Node<>(value);
        if (isEmpty()) {
            head = added;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = added;
        }
        ++modCount;
    }

    @Override
    public T poll() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T result = head.value;
        head = head.next;
        ++modCount;
        return result;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
//        System.out.println(LinkedQueueIterator.ABC);
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private static final String ABC = "123";
            private static final int val = 123;
//        private static final Integer vval = 123; // forbids static

            private Node<T> curr = head;
            private int expetedModCount = modCount;

            @Override
            public boolean hasNext() {
                System.out.println(ABC);
                return curr != null;
            }

            @Override
            public T next() {
                checkForComodification();
                T result = curr.value;
                curr = curr.next;
                return result;
            }

            private void checkForComodification(){
                if (expetedModCount != modCount){
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<T> {

        private final T value;
        private Node<T> next = null;

        public Node(T value) {
            this.value = value;
        }
    }
}
