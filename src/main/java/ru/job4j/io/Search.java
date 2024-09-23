package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validate(args);
        Path start = Path.of(args[0]);
        search(start, path -> path.toFile().getName().endsWith(".txt")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validate(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        if (args[1].equals("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io\\files")) {
            throw new IllegalArgumentException("argument number 1 was passed incorrectly");
        }
        if (!args[1].equals(".txt")) {
            throw new IllegalArgumentException("argument number 2 was passed incorrectly");
        }
    }
}






