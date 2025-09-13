package ru.job4j.collection;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class RevertLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        boolean result = head != null && head.next != null;
        if (result) {
            Node<T> prev = null;
            Node<T> curr = head;
            while (curr != null) {
                Node<T> after = curr.next;
                curr.next = prev;
                prev = curr;
                curr = after;
                head = prev;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        RevertLinked<Integer> revertLinked = new RevertLinked<>();

        revertLinked.add(2);
        revertLinked.add(3);
        revertLinked.add(4);
        revertLinked.add(5);
        revertLinked.add(6);

        for (Integer el : revertLinked) {
            System.out.println(el);
        }

        System.out.println("_-------------------------------");

        revertLinked.revert();

        for (Integer el : revertLinked) {
            System.out.println(el);
        }


    }
}