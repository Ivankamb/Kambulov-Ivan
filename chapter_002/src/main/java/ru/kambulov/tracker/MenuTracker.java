package ru.kambulov.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 29.08.18
 */
public class MenuTracker {

    /**
     * хранит ссылку на объект.
     */
    private Input input;

    /**
     * хранит ссылку на объект.
     */
    private Tracker tracker;

    /**
     * хранит ссылку на объект типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор экземляра MenuTracker.
     *
     * @param input   объект типа Input.
     * @param tracker объект типа Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива Меню.
     *
     * @return возвращает длинну массива.
     */
    public int getActionLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindById(4, "Find item by Id"));
        this.actions.add(new FindByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit program"));
    }

    /**
     * Метод в зависимости от ключа, выполняет действие.
     *
     * @param key ключ операции.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод показывает на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс добавляет заявку в список.
     */
    private class AddItem implements UserAction {
        private int key;
        private String info;

        AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("~~~~~~~ Adding new item! ~~~~~~~");
            String name = input.ask("Please enter the task`s name: ");
            String desc = input.ask("Please enter the task`s desc: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("~~~~~~~ New item with ID: " + item.getId());
            System.out.println("~~~~~~~ New item with name: " + item.getName());
            System.out.println("~~~~~~~ New item with description: " + item.getDescription());
        }

        public String info() {
            return String.format("%s. %s", key, info);
        }

    }

    /**
     * Класс показывает все заполненые заявки.
     */
    private static class ShowItems implements UserAction {
        private int key;
        private String info;

        ShowItems(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        public String info() {
            return String.format("%s. %s", key, info);
        }

    }

    /**
     * Класс редактирует заявку.
     */
    class EditItem implements UserAction {
        private int key;
        private String info;

        EditItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the task`s ID: ");
            String name = input.ask("Please enter the task`s name: ");
            String desc = input.ask("Please enter the task`s desc: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.edit(task);
        }

        public String info() {
            return String.format("%s. %s", key, info);
        }
    }

    /**
     * Класс удаляет заявку.
     */
    class DeleteItem implements UserAction {
        private int key;
        private String info;

        DeleteItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("~~~~~~~ Deleting item! ~~~~~~~");
            String id = input.ask("Please enter the task`s ID: ");
            if (tracker.delete(id)) {
                System.out.println("Item delete!");
            } else {
                System.out.println("Item not found!");
            }
        }

        public String info() {
            return String.format("%s. %s", key, info);
        }
    }

    /**
     * Класс ищет заявку по ID.
     */
    class FindById implements UserAction {
        private int key;
        private String info;

        FindById(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("~~~~~~~ Finding item by ID! ~~~~~~~");
            String id = input.ask("Please enter the task`s ID: ");
            tracker.findById(id);
            System.out.println(tracker.findById(id).toString());

        }

        public String info() {
            return String.format("%s. %s", key, info);
        }
    }

    /**
     * Класс ищет заявку по имени.
     */
    class FindByName implements UserAction {
        private int key;
        private String info;

        FindByName(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("~~~~~~~ Finding item by name! ~~~~~~~");
            String name = input.ask("Please enter the task`s name: ");
            tracker.findByName(name);
            for (Item item : tracker.getAll()) {
                if (item.getName().equals(name)) {
                    System.out.println(item.toString());
                }
            }
        }

        public String info() {
            return String.format("%s. %s", key, info);
        }
    }

    /**
     * Класс заглушка чтоб был пункт меню.
     */
    class ExitProgram implements UserAction {
        private int key;
        private String info;

        ExitProgram(int key, String info) {
            this.key = key;
            this.info = info;
        }

        public int key() {
            return key;
        }

        public void execute(Input input, Tracker tracker) {
        }

        public String info() {
            return String.format("%s. %s", key, info);
        }
    }
}