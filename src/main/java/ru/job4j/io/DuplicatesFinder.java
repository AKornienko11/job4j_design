package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path start = Path.of(".");
        duplicate(start);
    }

    public static List<Path> duplicate(Path path) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(path, duplicatesVisitor);
        return duplicatesVisitor.getList();
    }
}
