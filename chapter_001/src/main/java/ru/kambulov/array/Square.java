package ru.kambulov.array;
/**
 *@author Kambulov Ivan (mailto:kia289@mail.ru)
 *@version $Id$
 *@since 0.1
 */

public class Square {
    /**
     * @param bound параметр указывающий количесво чисел в массиве.
     * @return возвращает массив со степенями всех чисел по порядку.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int count = 0; count < rst.length; count++) {
            int i = count + 1;
            rst[count] = i * i;
        }
        return rst;
    }
}
