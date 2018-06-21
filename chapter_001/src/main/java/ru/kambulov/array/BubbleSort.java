package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    int tmp; //перменная необходимая для перестановки индексов в массиве.
    /**
     * @param array неотсортированный массив.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int index = 0; index < array.length - 1; index++) {   //кол-во проходов равно кол-ву ячеек в массиве.
            for (int j = 1; j < array.length; j++) {    //сортировка от меньшего к большему.
                if (array[j] < array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }
}
