package ru.kambulov.start;

import ru.kambulov.models.*;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Выберите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();
            } else if (REPLACE.equals(answer)) {
                this.replace();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("~~~~~~~ Добавление новой заявки ~~~~~~~");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("~~~~~~~ Заявка принята! ID: " + item.getId() + " ~~~~~~~");
    }

    private void showAll() {
        System.out.println("~~~~~~~ Вывод всех заявок на экран ~~~~~~~");
        for (Item item : this.tracker.getAll()) {
            System.out.println(item.toString());
        }
    }

    public void replace() {
        System.out.println("~~~~~~~ Редактирование заявки ~~~~~~~");
        String id = this.input.ask("Введите ID заявки: ");
        String newName = this.input.ask("Введите новое имя: ");
        String desc = this.input.ask("Введите описание: ");
        Item item = new Item(newName, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("~~~~~~~ Замена прошла успешно! ~~~~~~~");
        } else {
            System.out.println("~~~~~~~ Заявка не найдена! ~~~~~~~");
        }
    }

    public void delete() {
        System.out.println("~~~~~~~ Удаление! ~~~~~~~");
        String id = this.input.ask("Введите ID: ");
        if (this.tracker.delete(id)) {
            System.out.println("~~~~~~~ Заявка удалена! ~~~~~~~");
        } else {
            System.out.println("~~~~~~~ Заявка не найдена! ~~~~~~~");
        }
    }

    public void findById() {
        System.out.println("~~~~~~~ Поиск по ID ~~~~~~~");
        String id = this.input.ask("Введите ID: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("~~~~~~~ Такой заявки не существует! ~~~~~~~");
        }
    }

    public void findByName() {
        System.out.println("~~~~~~~ Поиск по имени! ~~~~~~~");
        String name = this.input.ask("Введите имя: ");
        Item[] result = this.tracker.findByName(name);
        for (Item item : result) {
            System.out.println(item.toString());
        }
    }

    private void showMenu() {
        System.out.println("Меню программы.");
        System.out.println("Добавление новой заявки: 0");
        System.out.println("Показать все заявки: 1");
        System.out.println("Изменить заяаку: 2");
        System.out.println("Удалить заявку: 3");
        System.out.println("Поиск по ID: 4");
        System.out.println("Поиск по имени: 5");
        System.out.println("Выход из программы: 6");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
