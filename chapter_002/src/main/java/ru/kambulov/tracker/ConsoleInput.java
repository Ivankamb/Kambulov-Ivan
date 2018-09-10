package ru.kambulov.tracker;

import java.util.List;
import java.util.Scanner;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.1
 * @since 27.08.18
 */

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Выход за пределы меню");
        }
        return key;
    }
}
