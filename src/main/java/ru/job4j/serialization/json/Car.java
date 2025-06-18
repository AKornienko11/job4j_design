package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
     private final boolean allWellDrive;
     private final int age;
     private final Identifier identifier;
     private final String[] statuses;

    public Car(boolean allWellDrive, int age, Identifier identifier, String[] statuses) {
        this.allWellDrive = allWellDrive;
        this.age = age;
        this.identifier = identifier;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car "
                + "{"
                + "allWellDrive=" + allWellDrive
                + ", age=" + age
                + ", identifier=" + identifier
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) {
        System.out.println(new Car(true, 2, new Identifier("sdcsvdsvs"), new String[] {"dccdcd", "sdhjsj"}));
    }
}
