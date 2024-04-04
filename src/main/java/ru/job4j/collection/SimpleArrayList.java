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


    @Override
    public void add(T value) {

        if (container.length <= size) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        if (container.length == 0) {
            container = (T[]) new Object[1];
        }
        container[size++] = value;
        modCount++;
    }


    @Override
    public T set(int index, T newValue) {
        if (Objects.checkIndex(index, container.length) > size) {
            throw new IndexOutOfBoundsException();
        }
        if (container.length == size) {
            container = Arrays.copyOf(container, container.length * 2);

            System.arraycopy(container, index, container, index + 1, size - index);

            container[index] = newValue;

        }
        return container[index + 1];

    }

    @Override
    public T remove(int index) {
        if (Objects.checkIndex(index, container.length) > size) {
            throw new IndexOutOfBoundsException();
        }
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
        T result = null;
        if (Objects.checkIndex(index, container.length) < size) {
            result = container[index];
        } else {
            throw new IndexOutOfBoundsException();
        }

        return result;
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

