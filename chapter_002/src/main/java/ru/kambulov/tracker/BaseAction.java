package ru.kambulov.tracker;
/**
 * Класс позволяет убрать часть повторяющегося кода из класса MenuTracker.
 *
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 11.09.18
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
