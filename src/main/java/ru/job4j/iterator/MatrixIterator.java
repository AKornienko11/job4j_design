package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            column = 0;
            row++;
        }
        return row < data.length && column < data[row].length;

    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2}, {}, {6, 7, 0, 8}};
        MatrixIterator matrixIterator = new MatrixIterator(data);
        while (matrixIterator.hasNext()) {
            System.out.println(matrixIterator.next());
        }
    }
}
