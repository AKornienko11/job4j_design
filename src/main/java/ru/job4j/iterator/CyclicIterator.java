package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    int index;
    /* здесь разместите поля класса, если они будут нужны  */

    public CyclicIterator(List<T> data) {
        this.data = data;
        /* код конструктора */
    }

    @Override
    public boolean hasNext() {
        while (index == (data.size())) {
            index = 0;

        }
        return index < data.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data.get(index++);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        CyclicIterator cyclicIterator = new CyclicIterator(list);
        while (cyclicIterator.hasNext()) {
            System.out.println(cyclicIterator.next());
        }
    }
}