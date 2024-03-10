package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length && data[index] == null) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    public static void main(String[] args) {
        Integer[] array = {1, 3, null, null, null, 4, 5, null, null, 7};
        NonNullIterator nonNullIterator = new NonNullIterator(array);
        while (nonNullIterator.hasNext()) {
            System.out.println(nonNullIterator.next());
        }
    }

}