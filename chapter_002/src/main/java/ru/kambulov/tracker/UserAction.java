package ru.kambulov.tracker;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 29.08.18
 */
public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ.
     */
    int key();

    /**
     * Основной метод.
     *
     * @param input   Объект типа Input.
     * @param tracker Объект типа Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return строка манею
     */
    String info();
}
