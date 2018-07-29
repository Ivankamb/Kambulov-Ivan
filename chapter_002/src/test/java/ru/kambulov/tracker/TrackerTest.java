package ru.kambulov.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

@Test
public void whenAddNewItemThenTrackerHasSameItem() {
    Tracker tracker = new Tracker();
    Item item = new Item("Test name 1", "Test desc 1", 1567L);
    tracker.add(item);
    assertThat(tracker.getAll()[0], is(item));
}

@Test
    public void whenReplaceNameThenReturnNewName() {
    Tracker tracker = new Tracker();
    Item before = new Item("Test 1 previous", "Test desc blha blha blha", 98765L);
    tracker.add(before);
    Item after = new Item("Test name next", "Test desc one more", 4875L);
    after.setId(before.getId());
    tracker.replace(before.getId(), after);
    assertThat(tracker.findById(after.getId()).getName(), is("Test name next"));
}

@Test
    public void testFindById() {
    Tracker tracker = new Tracker();
    Item item1 = new Item("Name for test 1", "Desc for test 1", 83459L);
    Item item2 = new Item("Name for test 2", "Desc for test 2", 835629L);
    Item item3 = new Item("Name for test 3", "Desc for test 3", 2219929L);
    tracker.add(item1);
    tracker.add(item2);
    tracker.add(item3);
    assertThat(tracker.findById(item2.getId()).getName(), is("Name for test 2"));
}

@Test
    public void testFindByName() {
    Tracker tracker = new Tracker();
    Item item1 = new Item("Name for test 1", "Desc for test 1", 1129L);
    Item item2 = new Item("Name for test 1", "Desc for test 2", 22L);
    Item item3 = new Item("Name for test 2", "Desc for test 3", 9999999L);
    tracker.add(item1);
    tracker.add(item2);
    tracker.add(item3);
    Item[] expected = {item1, item2};
    assertThat(tracker.findByName(item1.getName()), is(expected));
}

@Test
    public void testGetAll() {
    Tracker tracker = new Tracker();
    Item item1 = new Item();
    Item item2 = new Item();
    Item item3 = new Item();
    Item item4 = new Item();
    tracker.add(item1);
    tracker.add(item2);
    tracker.add(item3);
    tracker.add(item4);
    Item[] expected = {item1, item2, item3, item4};
    assertThat(tracker.getAll(), is(expected));
}

@Test
    public void whenDeleteSomeItemThenReturnWithoutThisItem() {
    Tracker tracker = new Tracker();
    Item item1 = new Item();
    Item item2 = new Item();
    Item item3 = new Item();
    Item item4 = new Item();
    Item item5 = new Item();
    tracker.add(item1);
    tracker.add(item2);
    tracker.add(item3);
    tracker.add(item4);
    tracker.add(item5);
    tracker.delete(item2.getId());
    Item[] expected = {item1, item3, item4, item5};
    assertThat((tracker.getAll()), is(expected));
}

}