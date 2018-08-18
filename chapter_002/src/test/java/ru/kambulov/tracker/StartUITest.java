package ru.kambulov.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.2
 * @since 07.08.18
 */
public class StartUITest {
    private Tracker tracker = new Tracker();
    private Input input;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringJoiner menu = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
            .add("Меню.")
            .add("Создание новой заявки - 0 ")
            .add("Показать все заявки - 1 ")
            .add("Изменить заявку - 2 ")
            .add("удалить заявку - 3 ")
            .add("Поиск по ID - 4 ")
            .add("Поиск по имени - 5 ")
            .add("Выход из программы - 6 ");

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    public void buildInput(final String[] value) {
        input = new StubInput(value);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        this.buildInput(new String[]{"0", "Test name", "Desc", "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("Test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = this.tracker.add(new Item("Test name", "Desc"));
        this.buildInput(new String[]{"2", item.getId(), "Test replace", "Заменили заявку", "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerDeleteItem() {
        Item item1 = this.tracker.add(new Item("Test name 1", "Desc"));
        Item item2 = this.tracker.add(new Item("Test name 2", "Desc"));
        this.buildInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("~~~ Удаление! ~~~")
                        .append(System.lineSeparator())
                        .append("~~~ Заявка удалена! ~~~")
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()
                ));
    }

    @Test
    public void whenUserFindItemByIdThenHeTakeThisItem() {
        Item item = this.tracker.add(new Item("Test name", "Desc"));
        this.buildInput(new String[]{"4", item.getId(), "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Test name"));
    }

    @Test
    public void whenUserFindItemByNameThenHeTakeThisItem() {
        Item item1 = this.tracker.add(new Item("Test name", "Desc"));
        Item item2 = this.tracker.add(new Item("Test name2", "Desc"));
        Item item3 = this.tracker.add(new Item("Test name2", "Desc"));
        this.buildInput(new String[]{"5", item2.getName(), "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("~~~ Поиск по имени! ~~~")
                        .append(System.lineSeparator())
                        .append("Заявка: ")
                        .append(item2)
                        .append(System.lineSeparator())
                        .append("Заявка: ")
                        .append(item3)
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()
                ));
    }

    @Test
    public void whenUserChoiceGetAll() {
        Item item1 = this.tracker.add(new Item("Test name1", "desc"));
        Item item2 = this.tracker.add(new Item("Test name2", "desc"));
        this.buildInput(new String[]{"1", "6"});
        new StartUI(this.input, this.tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                        .append(menu)
                        .append("~~~ Запрос всех заявок на экран! ~~~")
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
}
