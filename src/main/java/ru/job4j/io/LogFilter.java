package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() throws IOException {
        List<String> result = new ArrayList<>();
        LogFilter logFilter = new LogFilter(file);
        BufferedReader input = new BufferedReader(new FileReader(logFilter.file));
        List<String> list = input.lines().toList();
        for (String res : list) {
            String[] str = res.split(" ");
            if ("404".equals(str[str.length - 2])) {
                result.add(res);
            }
        }
        return result;
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
    }
}
