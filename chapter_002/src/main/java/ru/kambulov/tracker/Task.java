package ru.kambulov.tracker;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class Task extends Item {
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String calculatePrice() {
        return "100%";
    }
}
