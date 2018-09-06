package ru.kambulov.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста выбирайте пункт меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные.");
            }
        } while (invalid);
        return value;
    }
}