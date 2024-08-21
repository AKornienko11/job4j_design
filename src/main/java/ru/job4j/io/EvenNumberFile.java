package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {

        File file = new File("data/even.txt");
        try (FileInputStream input = new FileInputStream(file)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }

            String[] str = text.toString().split(System.lineSeparator());
            for (
                    String res : str) {
                int resul = Integer.parseInt(res);
                System.out.println(resul);
                if (resul % 2 == 0) {
                    System.out.println("Четное число");
                } else {
                    System.out.println("Не четное число");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



