package com.luxsoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T>, Iterable{
    private int size;
    T[] array;
    public ArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }
    public ArrayList() {
        array = (T[]) new Object[10];
    }
    @Override
    public void add(T value) {
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        if (size == array.length) {
            T[] toResized = (T[])new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, toResized, 0, array.length);
            array = toResized;
        }
        array[size] = value;
        size++;
    }
    @Override
    public void add(T value, int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List capacity is 0");
        }
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            T[] toResized = (T[]) new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, toResized, 0, array.length);
            array = toResized;
        }
        if (size - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        size++;
        array[index] = value;
    }
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedElement = array[index];
        size--;
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        return removedElement;
    }
    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    @Override
    public T set(T value, int index) {
        if (isEmpty()) {
            return null;
        }
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
        T toSet = array[index];
        array[index] = value;
        return toSet;
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
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
    public boolean contains(T value) {
        if (isEmpty()) {
            return false;
        }
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int indexOf(T value) {
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(T value) {
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        ArrayList<T> list = ArrayList.this;
        for (Object o : list) {
            stringJoiner.add(o.toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator {
        private int position = 0;
        @Override
        public boolean hasNext() {
            return position<size;
        }
        @Override
        public T next() {
            T value = array[position];
            position++;
            return value;
        }
    }
}