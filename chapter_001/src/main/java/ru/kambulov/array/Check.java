package ru.kambulov.array;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    /**
     * @param data Булевый массив со значениями "true", "false".
     * @return возвращает результат проверки на однотипность значений в массиве.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
