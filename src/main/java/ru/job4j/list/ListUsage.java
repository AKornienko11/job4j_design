package ru.job4j.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> result = Arrays.asList("one", "two", "three");

        result.set(1, "two and second");

        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент " + iterator.next());
        }

        Integer[] data = {1, 2, 3, 3, 4, 5, 6, 7, 8};
        Integer[] desta = new Integer[10];
        System.arraycopy(data, 2, desta, 0, 3);
        for (Integer res  : desta) {
            System.out.println(res);
        }
        Integer[] res = Arrays.copyOf(desta, 5);
        for (Integer v : res) {
            System.out.print(" " + v + " ");
        }



    }
}

