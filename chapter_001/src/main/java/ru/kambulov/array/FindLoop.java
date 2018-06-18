package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     *
     * @param data Название массива.
     * @param el число которое необходимо найти в массиве.
     * @return номер индекса с числом если метод сработает положительно. возвращает ноль если нет числа в массиве.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;  //если элемента нет в массиве, то возвращает -1
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
