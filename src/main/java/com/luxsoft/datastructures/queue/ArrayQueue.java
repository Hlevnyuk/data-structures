package com.luxsoft.datastructures.queue;
public class ArrayQueue implements Queue{
    private int size;
    private Object[] array;
    public ArrayQueue() {
        array = new Object[10];
    }
    public ArrayQueue(int size) {
        array = new Object[size];
    }
    @Override
    public void enqueue(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }
    private void ensureCapacity() {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
    @Override
    public Object dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        Object result = array[0];
        Object[] newArray = new Object[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        size--;
        array = newArray;
        return result;
    }
    @Override
    public Object peek() {
        return array[0];
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < array.length; i++) {
            Object valueInQueue = value;
            if (valueInQueue.equals(array[i])) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void clear() {
        size = 0;
    }
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < size; i++) {
            string = string + array[i];
            if (i == size - 1) {
                break;
            } else {
                string = string + ",";
                string = string + " ";
            }
        }
        return "[" + string + "]";
    }
}
