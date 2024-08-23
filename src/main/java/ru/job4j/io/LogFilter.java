package ru.job4j.io;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() throws IOException {
        LogFilter logFilter = new LogFilter(file);
        try (BufferedReader input = new BufferedReader(new FileReader(logFilter.file))) {
            return input.lines().filter(e -> e.contains(" 404 ")).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) throws IOException {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}
