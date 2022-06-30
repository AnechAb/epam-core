package com.epam.se02.generics;

public class RawTypesExample {

    public static void main(String[] args) {
//        NumberOptional<Integer> intOptional = new NumberOptional<>(1);
//        NumberOptional<String> stringOptional = new NumberOptional<>("abc");
////        Optional<Object> objectOptional = intOptional;
//
//        NumberOptional rawOptional = intOptional;
//        rawOptional.setValue("abc");
//        Object value = rawOptional.getValue();
//
////        Integer intValue = intOptional.getValue();
//
//        System.out.println(value);
//        Integer[] ints = {1, 2, 3};
//        Number[] numbers = ints;
//        Object[] objects = ints;


//        intOptional = stringOptional;
    }


}

class NumberOptional <T extends Number & Cloneable & Comparable<T>> {

    private T value;

    public NumberOptional(T value) {
        value.compareTo(value);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
