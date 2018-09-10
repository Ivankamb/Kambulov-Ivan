package ru.kambulov.tracker;

import java.util.List;

/**
 * Класс обрабатывает исключительные ситуации.
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */
public class ValidateInput implements Input {

    private final Input input;
    public ValidateInput(final Input input) {
        this.input = input;
    }

    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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