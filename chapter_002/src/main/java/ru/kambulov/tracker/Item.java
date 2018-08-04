package ru.kambulov.tracker;

/**
 * Данный класс соержит в себе переменные и методы для работы с заявками в трекере.
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.2
 * @since 25.07.18
 */
public class Item {
    private String id;
    protected String name;
    protected String description;
    private long create;
    private String comment;

    public Item() {

    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreate() {
        return this.create;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ", описание: " + this.description + ". ID " + this.id;
    }
}
