package ru.x5.list;

import java.util.Arrays;

public class OwnList<E> {

    // Внутренний массив для реализации ArrayList
    private E[] internalArray;

    private final int defaultLength = 10;

    private int lengthInternalArray = defaultLength;

    private int cursor;

    public OwnList() {
        internalArray = newInternalArray(defaultLength);
    }

    public OwnList(int size) {
        if (size > defaultLength) {
            internalArray = newInternalArray(size);
            this.lengthInternalArray = size;
        } else if (size >= 0) {
            internalArray = newInternalArray(defaultLength);
        } else {
            throw new IllegalArgumentException("Incorrect DIYarrayList size specified");
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

    public boolean addAll(OwnList<E> otherOwnList) {
        for (int i = 0; i < otherOwnList.size(); i++) {
            this.add(otherOwnList.get(i));
        }
        return true;
    }

    public E get(int index) {
        return internalArray[index];
    }

    public E set(int index, E element) {

        if (index < 0 || index > cursor) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        E overwrittenItem = internalArray[index];
        internalArray[index] = element;

        return overwrittenItem;
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
        if (index > cursor)
            throw new IndexOutOfBoundsException("Invalid index");

        E objectToDelete = internalArray[index];
        if (index == 0)
            internalArray = Arrays.copyOfRange(internalArray, index + 1, lengthInternalArray);
        else if (index == cursor && index == lengthInternalArray)
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

    public Object[] toArray() {
        return Arrays.copyOf(internalArray, cursor);
    }

    public <T> T[] toArray(T[] a) {

        if (a.length < cursor)
            return (T[]) Arrays.copyOf(internalArray, cursor, a.getClass());

        System.arraycopy(internalArray, 0, a, 0, cursor);

        if (a.length > cursor)
            a[cursor] = null;

        return a;
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