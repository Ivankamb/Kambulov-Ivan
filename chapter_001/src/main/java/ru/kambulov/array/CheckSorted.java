package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class CheckSorted {
    /**
     * Мутод проверяет массив на отсортированность.
     * @param value массив для проверки.
     * @return результат проверки.
     */
    boolean isSorted(int[] value) {
        boolean result = true;
        for (int index = 0; index < value.length - 1; index++) {
            if (value[index] > value[++index]) {
                result = false;
                break;
            }
        }
        return  result;
    }
}
