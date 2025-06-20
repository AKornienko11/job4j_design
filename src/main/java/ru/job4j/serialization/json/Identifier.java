package ru.job4j.serialization.json;

public class Identifier {
    private  String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Identifier() {

    }


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
