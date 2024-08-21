package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EvenNumberFile {
    public static void main(String[] args) {
        File file = new File("data/even.txt");
        try (Scanner scanner = new Scanner(file)) {
            int[] tall = new int[10];
            int k = 0;
            while (scanner.hasNextInt()) {
                tall[k++] = scanner.nextInt();
            }
            for (int i = 0; i < k; i++) {
                System.out.println(tall[i]);
                if (tall[i] % 2 == 0) {
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



