package ru.job4j.serialization.json;

public class Identifier {
    private final String number;

    public Identifier(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Identifier {"
                + "number='"
                + number
                + '\''
                + '}';
    }
}
