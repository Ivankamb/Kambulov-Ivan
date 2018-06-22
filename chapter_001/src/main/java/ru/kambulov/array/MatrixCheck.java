package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.2
 */
public class MatrixCheck {
    /**
     * @param data матрица с булевыми значениями.
     * @return проверку диагоналей на однотипность.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[0][0] != data[i + 1][i + 1] || data[data.length - 1][0] != data[data.length - (i + 2) ][i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}