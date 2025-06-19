package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.job4j.serialization.json.Identifier;

import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean allWellDrive;
    @XmlAttribute
    private int age;
    private Identifier identifier;
    private String[] statuses;

    public Car() {
    }

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
}
