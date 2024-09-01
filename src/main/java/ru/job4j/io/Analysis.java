package ru.job4j.io;

import java.io.*;
import java.util.StringJoiner;

public class Analysis {
    public void unavailable(String source, String target) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        try (PrintWriter stream = new PrintWriter(new FileOutputStream(target));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            bufferedReader.lines().forEach(stringJoiner::add);
            String[] str = stringJoiner.toString().split(System.lineSeparator());
            for (int i = 0; i < str.length; i++) {
                if (str[i].contains("400") || str[i].contains("500")) {
                    String[] time = str[i].split(" ");
                    stream.write(time[1] + " ");
                    i++;
                    for (int j = 0; j < str.length; j++) {
                        if (str[i].contains("400") || str[i].contains("500")) {
                            i++;
                        } else {
                            String[] end = str[i].split(" ");
                            stream.write(end[1] + ";" + System.lineSeparator());
                            break;
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
