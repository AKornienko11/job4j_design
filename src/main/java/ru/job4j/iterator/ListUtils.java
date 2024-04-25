package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.next();
                iterator.add(value);
                break;
            }
            iterator.next();
        }
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
        for (T i : elements) {
            if (list.contains(i)) {
                list.remove(i);
            }
        }
    }
}
