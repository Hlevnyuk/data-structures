package com.luxsoft.datastructures.stack;
//ADT -> Abstract Data Type
//LIFO -> last-in-first-out
public interface Stack {
    void push(Object value);
    Object pop();
    Object peek();
    boolean contains(Object value);
    int size();
    boolean isEmpty();
    void clear();
}
