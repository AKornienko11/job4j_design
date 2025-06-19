package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "identifier")
public class Identifier {
    @XmlAttribute
    private String number;

    public Identifier(String number) {
        this.number = number;
    }

    public Identifier() {

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
