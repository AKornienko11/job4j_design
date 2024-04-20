package ru.job4j.collection;

import java.util.*;

public class ForwardLinked<T> implements Iterable<T> {
    private int size;
    private int modCount;
    private Node<T> head;

    public ForwardLinked() {
        head = new Node<>(null, null);
    }

    public void add(T value) {
        Node<T> node = head;
        Node<T> newNode = new Node<>(value, null);
        if (node == null) {
            head = newNode;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        size++;
        modCount++;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
        modCount++;


    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public T deleteFirst() {
        if (head.next == null && head.item == null) {
            throw new NoSuchElementException();
        }

        Node<T> node = head.next;
        T res = node.item;
        node.item = null;
        head.next = node.next;
        node.next = null;
        size--;
        modCount++;
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int expectedModCount = modCount;

            Node<T> h = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return h.next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                h = h.next;

                return h.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
