package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Метод создаёт квадратную таблицу(матрицу)
     * @param size длинна стороны таблицы.
     * @return - таблица.
     */

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int line = 0; line < size; line++) {
            for (int column = 0; column < size; column++) {
                table[line][column] = (line + 1) * (column + 1);
            }
        }
        return table;
    }

}


