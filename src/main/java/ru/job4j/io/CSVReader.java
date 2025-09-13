package ru.job4j.io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        List<Integer> findIndex = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader(argsName.get("path")));
        String[] filter = argsName.get("filter").split(",");
        String[] str1 = scanner.nextLine().split("\"");
        String[] str2 = str1[1].split(";");
        for (int i = 0; i < filter.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str2[j].equals(filter[i])) {
                    int index = j;
                    findIndex.add(index);
                    stringBuilder.append(str2[index] + " ");
                }
            }
        }
        stringBuilder.append(System.lineSeparator());
        while (scanner.hasNext()) {
            String[] str3 = scanner.nextLine().split("\"");
            String[] str4 = str3[1].split(";");
            for (int i = 0; i < findIndex.size(); i++) {
                stringBuilder.append(str4[findIndex.get(i)] + " ");
            }
            stringBuilder.append(System.lineSeparator());
        }
        Scanner scan = new Scanner(stringBuilder.toString());
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(argsName.get("out")))) {
            while (scan.hasNext()) {
                printWriter.write(scan.nextLine() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        System.out.println(argsName.get("path"));

        handle(argsName);
    }
}