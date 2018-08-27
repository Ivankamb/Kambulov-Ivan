package ru.kambulov.tracker;

import org.junit.Test;
import ru.kambulov.models.Item;
import ru.kambulov.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class TrackerTest {

    @Test
    public void whenUserGetAllItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = {item1, item2, item3};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Test name 1", "Test desc", "Test comment", 54L);
        tracker.add(item1);
        assertThat(tracker.getAll()[0], is(item1));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item itemBefore = new Item("Test name 1", "Test desc", 456789L);
        tracker.add(itemBefore);
        Item itemAfter = new Item("Test name 2", "Test desc", "Comment");
        itemAfter.setId(itemBefore.getId());
        tracker.replace(itemBefore.getId(), itemAfter);
        assertThat(tracker.findById(itemBefore.getId()).getName(), is("Test name 2"));
    }

    @Test
    public void whenDeleteItemThenTrackerWithaoutThisItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Test name", "Test desc");
        Item item2 = new Item("Test name", "Test desc");
        Item item3 = new Item("Test name", "Test desc");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] expected = {item1, item3};
        assertThat((tracker.getAll()), is(expected));
    }

    @Test
    public void whenFindByNameThenTakeAllItemWithThisName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Test name1", "Desc", 734L);
        Item item2 = new Item("Test name2", "desc", 454L);
        Item item3 = new Item("Test name2", "desc", 77L);
        Item item4 = new Item("Test name3", "desc", 666L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] expected = {item2, item3};
        assertThat(tracker.findByName(item2.getName()), is(expected));
    }

    @Test
    public void whenFindByIdThenTakeItemWithThisId() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Test name1", "Test desc");
        Item item2 = new Item("Test name2", "Test desc");
        Item item3 = new Item("Test name3", "Test desc");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item2.getId()).getName(), is("Test name2"));
    }

    @Test
    public void whenUserAddComment() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Test name1", "Desc");
        Item item2 = new Item("Test name2", "Desc");
        Item item3 = new Item("Test name3", "Desc");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.addComment(item1.getId(), "Test comm");
        assertThat(tracker.findById(item1.getId()).getComment(), is(" Test comm"));
    }

}