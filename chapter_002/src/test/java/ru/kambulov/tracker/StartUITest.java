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
            .add("0. Add item")
            .add("1. Show all items")
            .add("2. Edit item")
            .add("3. Delete item")
            .add("4. Find item by Id")
            .add("5. Find items by name")
            .add("6. Exit program");

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Test item1", "Desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("Test item1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test item name1", "Desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "Test replace name", "Заявка заменена", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Test replace name"));
    }

    @Test
    public void whenUserChoiceDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "desc"));
        Item item2 = tracker.add(new Item("Test name2", "desc"));
        Item item3 = tracker.add(new Item("Test name3", "desc"));
        Input input = new StubInput(new String[]{"3", item2.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("select:")
                                .append(System.lineSeparator())
                                .append("~~~~~~~ Deleting item! ~~~~~~~")
                                .append(System.lineSeparator())
                                .append("Item delete!")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserFindItemByIdThenHeTakeThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "Desc"));
        Item item2 = tracker.add(new Item("Test name2", "Desc"));
        Input input = new StubInput(new String[]{"4", item1.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item1.getId()).getName(), is("Test name1"));
    }

    @Test
    public void whenUserGetAllThenTrackerShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Test name1", "desc"));
        Item item2 = tracker.add(new Item("Test name2", "desc"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("select:")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item2)
                                .append(System.lineSeparator())
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
        Input input = new StubInput(new String[]{"5", item3.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("select:")
                                .append(System.lineSeparator())
                                .append("~~~~~~~ Finding item by name! ~~~~~~~")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item3)
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
