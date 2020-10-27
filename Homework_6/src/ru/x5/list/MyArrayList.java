package ru.x5.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private E[] internalArray;

    private final int defaultLength = 10;

    private int lengthInternalArray = defaultLength;

    private int cursor;

    public MyArrayList() {
        internalArray = newInternalArray(defaultLength);
    }

    public MyArrayList(int size) {
        if (size > defaultLength) {
            internalArray = newInternalArray(size);
            this.lengthInternalArray = size;
        } else if (size >= 0) {
            internalArray = newInternalArray(defaultLength);
        } else {
            throw new IllegalArgumentException("Incorrect MyArrayList size specified");
        }
    }

    public int size() {
        return cursor;
    }

    public boolean isEmpty() {
        return cursor == 0;
    }

    public boolean contains(E e) {
        if (getObjectIndex(e) != -1) {
            return true;
        }
        return false;
    }

    public boolean add(E e) {
        if (cursor >= lengthInternalArray) {
            arrayIncrease();
        }
        internalArray[cursor++] = e;
        return true;
    }

    public boolean addAll(MyArrayList<E> otherMyArrayList) {
        for (int i = 0; i < otherMyArrayList.size(); i++) {
            this.add(otherMyArrayList.get(i));
        }
        return true;
    }

    public E get(int index) {
        return internalArray[index];
    }

    public boolean remove(E e) {
        int index;
        if ((index = getObjectIndex(e)) != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public E remove(int index) {
        if (index >= cursor && index < 0)
            throw new IndexOutOfBoundsException("Invalid index");

        E objectToDelete = internalArray[index];

        System.arraycopy(internalArray, index + 1, internalArray, index, cursor - index - 1);

        internalArray[--cursor] = null;

        return objectToDelete;
    }

    public void clear() {
        internalArray = newInternalArray(defaultLength);
        cursor = 0;
    }

    private E[] newInternalArray(int internalSize) {
        return (E[]) new Object[internalSize];
    }

    private void arrayIncrease() {

        lengthInternalArray += lengthInternalArray / 2 + 1;
        internalArray = Arrays.copyOf(internalArray, lengthInternalArray);

    }

    private int getObjectIndex(E e) {

        for (int index = 0; index < cursor; index++) {
            if (internalArray[index].equals(e)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(internalArray, cursor));

    }
}