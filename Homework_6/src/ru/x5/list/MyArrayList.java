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

    public boolean contains(Object o) {
        if (cursor > 0) {

            for (int i = 0; i < cursor; i++) {
                if (internalArray[i].equals(o)) {
                    return true;
                }

            }
            return false;
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

    public boolean remove(Object o) {

        boolean contains = false;
        int index;

        for (index = 0; index < cursor; index++) {
            if (internalArray[index].equals(o)) {
                contains = true;
                break;
            }
        }
        if (contains) {
            remove(index);
            return true;
        }

        return false;

    }

    public E remove(int index) {
        if (index > cursor && index < 0)
            throw new IndexOutOfBoundsException("Invalid index");

        E objectToDelete = internalArray[index];
        if (index == 0)
            internalArray = Arrays.copyOfRange(internalArray, index + 1, lengthInternalArray);
        else if (index == cursor)
            internalArray = Arrays.copyOfRange(internalArray, 0, index);
        else {
            E[] modifiedArray = newInternalArray(cursor - 1);

            E[] rightPartOfTheArray = Arrays.copyOf(internalArray, index);
            E[] leftPartOfTheArray = Arrays.copyOfRange(internalArray, index + 1, cursor);

            System.arraycopy(rightPartOfTheArray, 0, modifiedArray, 0, rightPartOfTheArray.length);
            System.arraycopy(leftPartOfTheArray, 0, modifiedArray, index, leftPartOfTheArray.length);

            internalArray = modifiedArray;

        }

        cursor -= 1;
        return objectToDelete;
    }

    public void clear() {
        internalArray = newInternalArray(defaultLength);
    }

    @SuppressWarnings("unchecked")
    private E[] newInternalArray(int internalSize) {
        return (E[]) new Object[internalSize];
    }

    private void arrayIncrease() {

        lengthInternalArray += lengthInternalArray / 2 + 1;
        internalArray = Arrays.copyOf(internalArray, lengthInternalArray);

    }

    @Override
    public String toString() {

        return Arrays.toString(Arrays.copyOf(internalArray, cursor));

    }
}