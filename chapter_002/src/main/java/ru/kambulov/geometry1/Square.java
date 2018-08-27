package ru.kambulov.geometry1;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.2
 * @since 08.08.18
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("XXXXXXX");
        picture.append(System.lineSeparator());
        picture.append("X     X");
        picture.append(System.lineSeparator());
        picture.append("X     X");
        picture.append(System.lineSeparator());
        picture.append("XXXXXXX");
        return picture.toString();
    }
}
