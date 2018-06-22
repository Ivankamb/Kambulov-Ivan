package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.3
 */
public class MatrixCheck {
    /**
     * @param data матрица с булевыми значениями.
     * @return проверку диагоналей на однотипность.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i = 0;
        if (data[i][i] == data[data.length - 1][i]) {
            for (; i < data.length - 1; i++) {
                if (data[0][0] != data[i + 1][i + 1] || data[data.length - 1][0] != data[data.length - (i + 2)][i + 1]) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}