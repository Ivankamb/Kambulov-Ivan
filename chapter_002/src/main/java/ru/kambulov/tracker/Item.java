package ru.kambulov.tracker;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class Item {
    private String comment;
    private String id;
    public String name;
    public String description;
    public Long create;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.comment = comment;
    }

    public Item(String name, String description, Long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String name, String description, String comment, Long create) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.comment = comment;
    }

    public Long getCreate() {
        return this.create;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        return this.name + ". Описание: " + this.description + ". ID " + this.id;
    }
}
