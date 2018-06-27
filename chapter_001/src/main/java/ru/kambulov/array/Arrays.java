package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Arrays {
    /**
     * Метод сравнивает два массива.
     * @param arrayForCheck массив необходимый проверить.
     * @param array - массив эталон.
     * @return возврат положительного результата или отрицательного на сравнение.
     */
    public boolean arrayCheck(int[] arrayForCheck, int[] array) {
        boolean result = false;
        for (int index = 0; index < arrayForCheck.length; index++) {
            if (arrayForCheck[index] != array[index]) {
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}