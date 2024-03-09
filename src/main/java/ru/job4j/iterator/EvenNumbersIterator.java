package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length && data[index] % 2 != 0) {
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
        int[] array = {1, -3, 2, 3, 5, 5, -4, 5, 6, 7};
        EvenNumbersIterator evenNumbersIterator = new EvenNumbersIterator(array);
        while (evenNumbersIterator.hasNext()) {
            System.out.println(evenNumbersIterator.next());
        }
    }

}
