package ru.kambulov.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Основной кдасс программы.
 *
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.1
 * @since 27.08.18
 */

public class StartUI {

    private boolean working = true;

    /**
     * Экземпляр класса получения данных от пользователя.
     */
    private final Input input;

    /**
     * Экземпляр класса хранения заявок.
     */
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        List<Integer> range = menu.getRange();
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
