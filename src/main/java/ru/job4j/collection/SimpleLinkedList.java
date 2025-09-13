package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements SimpleLinked<E> {

    private int size;
    private int modCount;
    private Node<E> head;

    public SimpleLinkedList() {
        head = new Node<>(null, null);
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        Node<E> h = head;
        if (h == null) {
            head = newNode;
        } else {
            while (h.next != null) {
                h = h.next;
            }
            h.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.item;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> h = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return h.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                h = h.next;

                return h.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

}