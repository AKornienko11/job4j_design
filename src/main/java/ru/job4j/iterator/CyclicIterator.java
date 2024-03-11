package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    int index;

    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index == (data.size()) && data.size() != 0) {
            index = 0;
        }
        return (!data.isEmpty());
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(index++);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of();
        CyclicIterator cyclicIterator = new CyclicIterator(list);
        boolean res = cyclicIterator.hasNext();
        System.out.println(res);
    }
}
