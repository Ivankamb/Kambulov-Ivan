package ru.kambulov.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс для приёма и хранения заявок.
 * @author Kambulov Ivan (mailTo: kia289@mail.ru)
 * @version 0.1
 * @since 17.07.18
 */

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище.
     *
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод производящий замену в ячейке массива.
     *
     * @param id   входящий идентификатор.
     * @param item входящие данные для замены.
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                this.items[index] = item;
            }
        }
    }

    /**
     * Метод обнулящий(Null) ячейку в массиве.
     *
     * @param id входящий идентификатор для нужной ячейки.
     */
    public void delete(String id) {
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                items[position--] = null;
                break;
            }
        }
    }

    /**
     * Метод просто сопирует все данные из массива в массив для выдачи.
     *
     * @return возвращает пользователю массив с данными.
     */
    public Item[] getAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод производит поиск по имени. И возвращает массив со всеми совпаданиями.
     *
     * @param key входящий параметр необходимый для поиска.
     * @return возвращает массив с найдеными совпадениями.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод ищет по ID.
     *
     * @param id входящий идентификатор.
     * @return возвращает найденые данные или Null.
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
     * Метод генерирует уникальный ключ для заявки.
     *
     * @return уникальный ключ.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}