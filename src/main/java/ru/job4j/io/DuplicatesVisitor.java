package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> map;


    public DuplicatesVisitor() {
        this.map = new HashMap<>();

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
      map.computeIfAbsent(fileProperty, k -> new ArrayList<>()).add(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public List<Path> getList() {
        List<List<Path>> list = new ArrayList<>(map.values());
        List<Path> paths = list.stream().filter(l -> l.size() > 1).map(l -> l.get(1).getFileName()).toList();
      for (Path t : paths) {
          System.out.println(t);
        }
        return paths;
    }
}
