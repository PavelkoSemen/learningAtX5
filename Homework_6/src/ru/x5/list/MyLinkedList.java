package ru.x5.list;

import java.util.Arrays;

public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    public int size() {
        return size;
    }

    public boolean add(E e) {
        Node<E> newNode = new Node<>(e, null, null);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
        return true;
    }

    public E get(int index) {
        if (index > size && index < 0) {
            throw new IllegalArgumentException("Incorrect index");
        }

        return desiredNode(index).value;
    }

    public E remove(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<E> deletedNode;
        if (index == 0) {
            deletedNode = first;
            first = first.next;
            first.previous = null;
        } else if (index == size - 1) {
            deletedNode = last;
            last = last.previous;
            last = last.next = null;
        } else {
            deletedNode = desiredNode(index);
            Node<E> previous = deletedNode.previous;
            Node<E> next = deletedNode.next;

            next.previous = previous;
            previous.next = next;
        }

        size--;
        return deletedNode.value;
    }

    public boolean remove(Object o) {

        boolean contains = false;
        int index;
        Node<E> deletedNode = first;

        for (index = 0; index < size; index++) {
            if (deletedNode.value.equals(o)) {
                contains = true;
                break;
            }
            deletedNode = deletedNode.next;
        }
        if (contains) {
            remove(index);
            return true;
        }

        return false;
    }

    private Node<E> desiredNode(int index) {
        int midIndex = size / 2;
        Node<E> desiredNode;
        if (index > midIndex) {
            int currentIndex = size - index - 1;
            desiredNode = lookBack(currentIndex);
        } else {
            desiredNode = lookAhead(index);
        }

        return desiredNode;
    }

    private Node<E> lookAhead(int index) {
        Node<E> node = first;
        while (index != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    private Node<E> lookBack(int index) {
        Node<E> node = last;
        while (index != 0) {
            node = node.previous;
            index--;
        }
        return node;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> toStringNode = first;
        int index = size - 1;
        stringBuilder.append("[");

        while (index >= 0) {
            if (index != 0) {
                stringBuilder.append(toStringNode.value);
                stringBuilder.append(", ");
                toStringNode = toStringNode.next;
            } else {
                stringBuilder.append(toStringNode.value);
            }
            index--;
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private class Node<E> {
        private E value;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value, Node<E> previous, Node<E> next) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }
}
