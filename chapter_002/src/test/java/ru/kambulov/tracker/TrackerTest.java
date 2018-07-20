package ru.kambulov.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 19.07.2018
 */

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void testForReplaceMethod() {
        Tracker tracker = new Tracker();
        Item before = new Item("testName1", "testDesc1", 991L);
        tracker.add(before);
        Item after = new Item("testName2", "testDesc2", 5678L);
        after.setId(before.getId());
        tracker.replace(before.getId(), after);
        assertThat(tracker.findById(before.getId()).getName(), is("testName2"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDesc1", 459L);
        Item item2 = new Item("testName2", "testDesc2", 4568L);
        Item item3 = new Item("testName3", "testDesc3", 478L);
        Item item4 = new Item("testName4", "testDesc4", 44678L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(tracker.getAll()[2].getId());
        Item[] expected = {item1, item2, item4};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenGetAllThenReturnAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDesc1", 459L);
        Item item2 = new Item("testName2", "testDesc2", 4568L);
        Item item3 = new Item("testName3", "testDesc3", 478L);
        Item item4 = new Item("testName4", "testDesc4", 44678L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] expected = {item1, item2, item3, item4};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenFinByIdThenReturnItemWithRightId() {
        Tracker tracer = new Tracker();
        Item item1 = new Item("testName1", "testDesc1", 101L);
        Item item2 = new Item("testName2", "testDesc2", 12321L);
        Item item3 = new Item("testName3", "testDesc3", 987L);
        tracer.add(item1);
        tracer.add(item2);
        tracer.add(item3);
        assertThat(tracer.findById(tracer.getAll()[1].getId()), is(item2));
    }

    @Test
    public void whenFindByNameThenReturnAllItemsWithThisName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("testName1", "testDesc1", 110L);
        Item item2 = new Item("testName2", "testDesc2", 1630L);
        Item item3 = new Item("testName3", "testDesc3", 9854L);
        Item item4 = new Item("testName1", "testDesc4", 563453L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] expected = {item1, item4};
        assertThat(tracker.findByName("testName1"), is(expected));
    }
}