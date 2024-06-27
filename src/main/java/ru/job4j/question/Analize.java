package ru.job4j.question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int change = 0;
        int delete = 0;
        Map<Integer, String> map = new HashMap<>();
        current.forEach(e -> map.put(e.getId(), e.getName()));
        for (User el : previous) {
            if (!map.containsKey(el.getId())) {
                delete++;
                map.put(el.getId(), el.getName());
            } else if (!map.get(el.getId()).equals(el.getName())) {
                change++;
            }
        }
        return new Info(map.size() - previous.size(), change, delete);
    }
}