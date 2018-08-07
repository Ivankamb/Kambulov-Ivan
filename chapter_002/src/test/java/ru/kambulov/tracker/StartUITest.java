package ru.kambulov.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 07.08.18
 */
public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "Test name", "Desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("Test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name", "Desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "Test replace", "Заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Test name 1", "Desc");
        Item item2 = new Item("Test name 2", "Desc");
        tracker.add(item1);
        tracker.add(item2);
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] expected = {item2};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenUserFindItemByIdThenHeTakeThisItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name", "Desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker);
        assertThat(tracker.findById(item.getId()).getName(), is("Test name"));
    }

    @Test
    public void whenUserFindItemByNameThenHeTakeThisItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test name", "Desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker);
        Item[] expected = {item};
        assertThat(tracker.findByName(item.getName()), is(expected));
    }
}
