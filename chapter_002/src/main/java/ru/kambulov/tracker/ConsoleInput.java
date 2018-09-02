package ru.kambulov.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int ask(String question, List<Integer> range) {
        System.out.println(question);
        return Integer.valueOf(scanner.nextLine());
    }

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
