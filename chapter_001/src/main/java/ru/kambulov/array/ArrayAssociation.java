package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayAssociation {
    /**
     * Метод объеденяющий два отсортированных массива.
     *
     * @param array1 Первый массив.
     * @param array2 второй массив.
     * @return третий массив с данными из первых двух.
     */
    public int[] association(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        int arrayIndex1 = 0;
        int arrayIndex2 = 0;
        int arrayIndex3 = 0;

        while (arrayIndex1 < array1.length || arrayIndex2 < array2.length) {
            if (arrayIndex1 >= array1.length) {
                array3[arrayIndex3++] = array2[arrayIndex2];
                arrayIndex2++;
            } else if (arrayIndex2 >= array2.length) {
                array3[arrayIndex3++] = array1[arrayIndex1];
                arrayIndex1++;
            } else if (array1[arrayIndex1] < array2[arrayIndex2]) {
                array3[arrayIndex3++] = array1[arrayIndex1];
                arrayIndex1++;
            } else {
                array3[arrayIndex3++] = array2[arrayIndex2];
                arrayIndex2++;
            }
        }
        return array3;
    }
}