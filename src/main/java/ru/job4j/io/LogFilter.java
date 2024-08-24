package ru.job4j.io;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() throws IOException {
        LogFilter logFilter = new LogFilter(file);
        BufferedReader input = new BufferedReader(new FileReader(logFilter.file));
        return input.lines().filter(e -> e.contains(" 404 ")).collect(Collectors.toList());
    }

    public void saveTo(String out) {
        LogFilter filter = new LogFilter(file);
        try (PrintWriter printWriter = new PrintWriter(out)) {
            printWriter.println(filter.filter().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
        new LogFilter("data/log.txt").saveTo("data/404.txt");
    }
}
