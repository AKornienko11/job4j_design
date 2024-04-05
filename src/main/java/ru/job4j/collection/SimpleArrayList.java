package ru.job4j.collection;

import java.beans.Introspector;
import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    private void expand() {
        container = Arrays.copyOf(container, container.length * 2);
    }


    @Override
    public void add(T value) {

        if (container.length <= size) {
            expand();
        }
        if (container.length == 0) {
            container = (T[]) new Object[1];
        }
        container[size++] = value;
        modCount++;
    }


    @Override
    public T set(int index, T newValue) {
        if (Objects.checkIndex(index, size) == index) {
            expand();
            System.arraycopy(container, index, container, index + 1, size - index);
            container[index] = newValue;
        }
        return container[index + 1];

    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        if (container[index] == null) {
            throw new IndexOutOfBoundsException();
        }
        T result = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;
        return result;

    }

    @Override
    public T get(int index) {
        if (!(Objects.checkIndex(index, container.length) < size)) {
            throw new IndexOutOfBoundsException();
        }
        return container[index];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int expectedModCount = modCount;

            int count = 0;

            @Override
            public boolean hasNext() {


                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                boolean res = false;
                for (T v : container) {
                    if (v != null) {
                        res = true;
                        break;
                    }

                }

                return count < size && res;

            }

            @Override
            public T next() {
                if (container[count] == null) {
                    throw new NoSuchElementException();
                }
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                return container[count++];
            }
        };
    }
}

