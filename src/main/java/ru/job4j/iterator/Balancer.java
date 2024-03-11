package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> scours) {
        while (scours.hasNext()) {
            for (ArrayList<Integer> res : nodes) {
                res.add(scours.next());
                if (!scours.hasNext()) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = List.of(1, 2, 3, 4).iterator();
        List<ArrayList<Integer>> list = (List.of(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()));
        Balancer.split(list, iterator);
        for (ArrayList<Integer> result : list) {
            System.out.println(result);
        }
    }
}

