package ru.kambulov.tracker;
/**
 * Данный класс использует контракт и обрабатывает входящий поток от пользователя.
 *
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 30.07.18
 */
import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
