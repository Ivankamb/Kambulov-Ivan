package ru.kambulov.tracker;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.4
 * @since 25.07.18
 */

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод добавляет заявку в трекер.
     *
     * @param item заявка.
     * @return возвращает принятую заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод редактирует или заменяет заявку.
     *
     * @param id   идентификатор заявки для обработки.
     * @param item возврат обработанной заявки.
     * @return результат успешности метода.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                item.setId(this.items[index].getId());
                this.items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод поиска в теркере по ID.
     *
     * @param id ID необходимый для поиска заявки.
     * @return возврат найденной заявки.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод поиска по имени заявки в трекере.
     *
     * @param name имя искомой заявки.
     * @return возврат всех найденных совпадений.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                result[count++] = item;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод показывает все имеющиеся заявки.
     *
     * @return показывает все заявки.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод удаляет заявку.
     *
     * @param id входящий ID удаляемой заявки.
     * @return результат работы метода.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = null;
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирующий кникальный номер для заявок.
     *
     * @return ID
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
