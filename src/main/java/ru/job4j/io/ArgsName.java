package ru.job4j.io;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ArgsName {
    private final Map<String, String> value;

    public ArgsName() {
        this.value = new HashMap<>();
    }

    public String get(String key) {
        if (!value.containsKey(key)) {
            throw new IllegalArgumentException("This key: \'%s\' is missing".formatted(key));
        }
        return value.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            if (!s.contains("=")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not contain an equal sign".formatted(s));
            }
            if (!s.contains("-")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not start with a '-' character".formatted(s));
            }
            String[] words = s.split("-", 2);
            if (words[0] == null) {
                throw new IllegalArgumentException();
            }
            String[] strings = words[1].split("=", 2);
            if (strings[0].equals("")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not contain a key".formatted(s));
            }
            if (strings[1].equals("")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not contain a value".formatted(s));
            }

            value.put(strings[0], strings[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);

        return names;

    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("encoding"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}