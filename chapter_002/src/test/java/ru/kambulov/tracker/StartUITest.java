package ru.kambulov.tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    private final StringJoiner menu = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
            .add("Меню программы.")
            .add("Добавление новой заявки: 0")
            .add("Показать все заявки: 1")
            .add("Изменить заяаку: 2")
            .add("Удалить заявку: 3")
            .add("Поиск по ID: 4")
            .add("Поиск по имени: 5")
            .add("Выход из программы: 6");

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Test item1", "Desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("Test item1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test item name1", "Desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "Test replace name", "Заявка заменена", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Test replace name"));
    }

    @Test
    public void whenUserChoiceDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "desc"));
        Item item2 = tracker.add(new Item("Test name2", "desc"));
        Item item3 = tracker.add(new Item("Test name3", "desc"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("~~~~~~~ Удаление! ~~~~~~~")
                                .append(System.lineSeparator())
                                .append("~~~~~~~ Заявка удалена! ~~~~~~~")
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenUserFindItemByIdThenHeTakeThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "Desc"));
        Item item2 = tracker.add(new Item("Test name2", "Desc"));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item1.getId()).getName(), is("Test name1"));
    }

    @Test
    public void whenUserGetAllThenTrackerShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "desc"));
        Item item2 = tracker.add(new Item("Test name2", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("~~~~~~~ Вывод всех заявок на экран ~~~~~~~")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item2)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenUserFindItemByNameThenHeTakeThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "desc"));
        Item item2 = tracker.add(new Item("Test name2", "desc"));
        Item item3 = tracker.add(new Item("Test name1", "desc"));
        Input input = new StubInput(new String[]{"5", item3.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("~~~~~~~ Поиск по имени! ~~~~~~~")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item3)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }
}
