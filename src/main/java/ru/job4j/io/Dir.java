package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io\\files\\directory\\file2.txt");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Файл  не существует: %s", file.getAbsoluteFile()));
        }

        if (!file.isFile()) {
            throw new IllegalArgumentException(String.format("Это не файл: %s", file.getAbsoluteFile()));
        }

        System.out.println(String.format("Размер файла : %s", file.length()));
        System.out.println(String.format("Имя  файла %s", file.getName()));


    }
}
