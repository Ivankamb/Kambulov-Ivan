package ru.kambulov.loop;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Метод строит поле по типу шахматной доски.
     * @param width ширина поля.
     * @param height высота поля.
     * @return результат.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int i, j;
        for (i = 1; i <= height; i++) {
            for (j = 1; j <= width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
