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
    public int getActionLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет лист пунктами меню.
     *
     * @return Заполненное поле пунктов в меню.
     */
    public List<Integer> getRange() {
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < this.getActionLength(); i++) {
            range.add(i);
        }
        return range;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(this.new AddItem(0, "Add item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindById(4, "Find item by Id"));
        this.actions.add(new FindByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit program", ui));
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
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
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
    }

    /**
     * Класс показывает все заполненые заявки.
     */
    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }

    /**
     * Класс редактирует заявку.
     */
    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter the task`s ID: ");
            String name = input.ask("Please enter the task`s name: ");
            String desc = input.ask("Please enter the task`s desc: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.edit(task);
        }
    }

    /**
     * Класс удаляет заявку.
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("~~~~~~~ Deleting item! ~~~~~~~");
            String id = input.ask("Please enter the task`s ID: ");
            if (tracker.delete(id)) {
                System.out.println("Item delete!");
            } else {
                System.out.println("Item not found!");
            }
        }
    }

    /**
     * Класс ищет заявку по ID.
     */
    private class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("~~~~~~~ Finding item by ID! ~~~~~~~");
            String id = input.ask("Please enter the task`s ID: ");
            if (tracker.findById(id) != null) {
                System.out.println(tracker.findById(id).toString());
            } else {
                System.out.println("ID wrong! Item not found");
            }
        }
    }

    /**
     * Класс ищет заявку по имени.
     */
    private class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
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
    }

    /**
     * Класс завершения работы трекера.
     */
    private class ExitProgram extends BaseAction {
        private final StartUI ui;

        public ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }
}