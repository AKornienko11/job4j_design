package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> chatLog = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Побазарим?");
        String question = scanner.nextLine();
        String bot;
        while (!OUT.equals(question)) {
            if (STOP.equals(question)) {
                System.out.println("Перекурим");
                question = scanner.nextLine();
                while (!CONTINUE.equals(question)) {
                    System.out.println("если хочешь дальше базарить, скажи, что хочешь продолжить!");
                    question = scanner.nextLine();

                }
                System.out.println("Погнали дальше");
                question = scanner.nextLine();
            }
            bot = botAnswers.get(new Random().nextInt(botAnswers.size()));
            System.out.println(bot);
            chatLog.add(question);
            chatLog.add(bot);
            question = scanner.nextLine();
        }
        bot = "Пакеда!";
        System.out.println(bot);
        chatLog.add(question);
        chatLog.add(bot);
        saveLog(chatLog);
    }

    public List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(botAnswers))) {
            bufferedReader.lines().map(s -> s + System.lineSeparator()).forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    private void saveLog(List<String> log) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path))) {
            log.forEach(printWriter::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("./data/text.txt", "./data/ansvers.txt");
        chat.run();
    }
}




