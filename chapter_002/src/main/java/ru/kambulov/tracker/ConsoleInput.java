package ru.kambulov.tracker;

import java.util.Scanner;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
