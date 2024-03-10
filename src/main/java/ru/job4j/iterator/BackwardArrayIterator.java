package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIterator(int[] data) {
        this.data = data;
        this.point = data.length - 1;

    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        BackwardArrayIterator backwardArrayIterator = new BackwardArrayIterator(data);
        while (backwardArrayIterator.hasNext()) {
            System.out.println(backwardArrayIterator.next());
        }
    }

}
