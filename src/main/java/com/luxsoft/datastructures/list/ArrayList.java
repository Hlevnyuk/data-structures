package com.luxsoft.datastructures.list;
public class ArrayList implements List{
    private int size;
    Object[] array;
    public ArrayList(int capacity) {
        array = new Object[capacity];
    }
    public ArrayList() {
        array = new Object[10];
    }
    @Override
    public void add(Object value) {
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        if (size == array.length) {
            Object[] toResized = new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, toResized, 0, array.length);
            array = toResized;
        }
        array[size] = value;
        size++;
    }
    @Override
    public void add(Object value, int index) {
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
            Object[] toResized = new Object[(int) (array.length * 1.5)];
            System.arraycopy(array, 0, toResized, 0, array.length);
            array = toResized;
        }
        for (int i = index; i < size; i++) {
            array[i + 1] = array[i];
        }
        size++;
        array[index] = value;
    }
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Object removedElement = array[index];
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return removedElement;
    }
    @Override
    public Object get(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    @Override
    public Object set(Object value, int index) {
        if (isEmpty()) {
            return null;
        }
        if (value == null) {
            throw new IllegalStateException("Null element is not supported");
        }
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Object toSet = array[index];
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
    public boolean contains(Object value) {
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
    public int indexOf(Object value) {
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
    public int lastIndexOf(Object value) {
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
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i == size - 1) {
                return result.append(']').toString();
            }
            result.append(", ");
        }
        return result.toString();
    }
}