package ru.job4j.map;

import java.util.Objects;

public class Demonstrate {

    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Demonstrate that = (Demonstrate) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int total = 17;
        total = total * 31 + Objects.hashCode(id);
        total = total * 31 + Objects.hashCode(name);
        return total;

    }
}
