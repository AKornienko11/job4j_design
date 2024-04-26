package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index);
        iterator.add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index + 1);
        iterator.add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        for (T res : list) {
            if (filter.test(res)) {
                list.remove(res);
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        for (T res : list) {
            if (filter.test(res)) {
                list.set(list.indexOf(res), value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        Predicate<T> result = elements::contains;
        removeIf(list, result);
    }
}
