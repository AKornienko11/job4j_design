package ru.job4j.io;

import java.io.*;
import java.util.StringJoiner;

public class Analysis {
    public void unavailable(String source, String target) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(target));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            bufferedReader.lines().forEach(stringJoiner::add);
            String[] str = stringJoiner.toString().split(System.lineSeparator());
            boolean flag = true;
            String res;
            for (String s : str) {
                if ((s.contains("400") || s.contains("500")) && flag) {
                    res = s.split(" ")[1];
                    printWriter.printf("%s%s", res, ";");
                    flag = false;
                }
                if ((s.contains("200") || s.contains("300")) && !flag) {
                    res = s.split(" ")[1];
                    printWriter.printf("%s%s", res, ";");
                    flag = true;
                    printWriter.print(System.lineSeparator());
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
