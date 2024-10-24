package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zip {
    private final Map<String, String> zip;

    public Zip() {
        this.zip = new HashMap<>();
    }

    public void packFile(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(bufferedInputStream.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zipOutputStream.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zipOutputStream.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        if (!zip.containsKey(key)) {
            throw new IllegalArgumentException("This key: \'%s\' is missing".formatted(key));
        }
        return zip.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            if (!s.contains("=")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not contain an equal sign".formatted(s));
            }
            if (!s.contains("-")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not start with a '-' character".formatted(s));
            }
            String[] words = s.split("-", 2);
            if (words[0] == null) {
                throw new IllegalArgumentException();
            }
            String[] strings = words[1].split("=", 2);
            if (strings[0].equals("")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not contain a key".formatted(s));
            }
            if (strings[1].equals("")) {
                throw new IllegalArgumentException("Error: This argument \'%s\' does not contain a value".formatted(s));
            }

            zip.put(strings[0], strings[1]);
        }
    }

    public static Zip of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        Zip names = new Zip();

        names.parse(args);

        return names;

    }


    public static void main(String[] args) throws IOException {
        Zip zip = Zip.of(args);
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        zip.packFile(
                Search.search(Path.of(zip.get("d")), path -> !path.toFile().getName().endsWith(zip.get("e"))),
                new File(zip.get("o"))
        );
    }
}




