package ru.kambulov.geometry;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 08.08.18
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("XXXXXXX\n");
        picture.append("X     X\n");
        picture.append("X     X\n");
        picture.append("XXXXXXX");
        return picture.toString();
    }
}
