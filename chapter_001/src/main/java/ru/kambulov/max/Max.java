package ru.kambulov.max;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * @param first первое число.
     * @param second второе число.
     * @return большее число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return result большее число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
//        int temp = this.max(first, second);
//        int result = this.max(temp, third);
//        return result;