package ru.kambulov.geometry1;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 08.08.18
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("    X    ");
        picture.append(System.lineSeparator());
        picture.append("  X   X  ");
        picture.append(System.lineSeparator());
        picture.append(" X     X ");
        picture.append(System.lineSeparator());
        picture.append("XXXXXXXXX");
        return picture.toString();
    }
}
