package ru.kambulov.loop;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * @param start Число начала отсчёта.
     * @param finish последнее число в диапазоне.
     * @return сумма всех чётных в диапазоне.
     */

    public int add(int start, int finish) {
        int summ = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summ += i;
            }
        }
        return summ;
    }
}
