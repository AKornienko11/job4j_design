package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap();

    public Config(String path) {
        this.path = path;
    }

    public void load() throws IllegalArgumentException {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.lines().forEach(output::add);
            String[] array = output.toString().split(System.lineSeparator());
            for (String rsr : array) {
                if (rsr.startsWith("=") && rsr.endsWith("=")) {
                    throw new IllegalArgumentException("There is no key and value");
                }
                if (!rsr.contains("=") || rsr.startsWith("=") || rsr.endsWith("=")) {
                    throw new IllegalArgumentException("Нет такого");
                }
                String[] result = rsr.split("=", 2);
                values.put(result[0], result[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String result = null;
        for (String res : values.keySet()) {
            if (res.equals(key)) {
                result = values.get(key);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
