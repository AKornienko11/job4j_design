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
        for (int i = index; i < data.length; i++) {
            if (data[i] != null) {
                break;
            } else {
                index++;
            }
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
        Integer[] array = {1, 3, null, null, null, 4, 5, null, null};
        NonNullIterator nonNullIterator = new NonNullIterator(array);
        while (nonNullIterator.hasNext()) {
            System.out.println(nonNullIterator.next());
        }
    }

}