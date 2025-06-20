package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private boolean allWellDrive;
    private int age;
    private Identifier identifier;
    private String[] statuses;

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


    public boolean isAllWellDrive() {
        return allWellDrive;
    }

    public int getAge() {
        return age;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public void setAllWellDrive(boolean allWellDrive) {
        this.allWellDrive = allWellDrive;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setStatuses(String[] statuses) {
        this.statuses = statuses;
    }

}
