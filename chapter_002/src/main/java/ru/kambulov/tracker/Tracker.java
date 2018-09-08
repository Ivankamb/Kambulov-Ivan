package ru.kambulov.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс содержит методы которые использует Tracker для выполнения задуманных операций.
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод добавляет заявку в массив и смещает указатель ячейки на 1.
     *
     * @param item Заявка.
     * @return готовая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    public void edit(Item fresh) {
        for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item != null && item.getId().equals(fresh.getId())) {
                items[index] = fresh;
                break;
            }
        }
    }

    /**
     * Метод редактирует готовую заявку.
     *
     * @param id   ID редактируемой заявки.
     * @param item заявка.
     * @return результат.
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
     * Метод удаляет заявку и пересобирает массив чтоб небыло пустых ячеек до последней заявки.
     *
     * @param id ID удаляемой заявки.
     * @return результат удаления.
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
     * Метод вызывает все заявки.
     *
     * @return массив заявок.
     */
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Метод ищет заявки по имени.
     *
     * @param name Имя искомой заявки
     * @return массив заявок которые имеют name.
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(name)) {
                result[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод ищет заявку по ID.
     *
     * @param id ID искомой заявки.
     * @return заявку которую нашёл.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод добавляет комментарии к заявке. Не реализован в трекере полностью.
     *
     * @param id      ID комментируемой заявки.
     * @param comment Строка комментария.
     * @return результат.
     */
    public boolean addComment(String id, String comment) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                this.items[index].setComment(" " + comment);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ID.
     *
     * @return ID
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
