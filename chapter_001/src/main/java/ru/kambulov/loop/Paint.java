package ru.kambulov.loop;

import java.util.function.BiPredicate;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Метод создаёт правую половину пирамиды.
     * @param height указатель высоты.
     * @return возвращает нарисованную в псевдографике фигуру.
     */
    public String rightTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= column);
    }
    /**
     * Метод создаёт левую половину пирамиды.
     * @param height указатель высоты.
     * @return возвращает нарисованную в псевдографике фигуру.
     */
    public String leftTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
    }
    /**
     * Метод создаёт пирамиду.
     * @param height указатель высоты.
     * @return возвращает нарисованную в псевдографике фигуру.
     */
    public String piramid(int height) {
        return this.loopBy(height, 2 * height - 1, (row, column) -> row >= height - column - 1
                && row + height - 1 >= column);
    }
    /**
     *
     * @param height параметр высоты.
     * @param weight параметр ширины.
     * @param predict новый параметр позволяющий произвести рефракторинг кода.
     * @return возвращает метод, который значительно уменьшает кол-во кода.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
