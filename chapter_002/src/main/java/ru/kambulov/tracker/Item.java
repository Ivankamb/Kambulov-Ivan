package ru.kambulov.tracker;

/**
 * Клас Item содержит в себе переменные и методы для работы с заявками.
 *
 * @author Kambulov Ivan.
 * @since 18.07.2018
 * @version 0.1
 */

public class Item {
    private String Id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreated() {
        return this.created;
    }

    public String[] getComments() {
        return this.comments;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }
}
