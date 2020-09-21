package ru.x5.list;

import java.util.List;

public interface MyList<E> {
    int size();

    boolean isEmpty();

    boolean add(E o);

    boolean remove(E o);

    void clear();

    E get(int index);

    E remove(int index);
}
