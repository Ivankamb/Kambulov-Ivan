package ru.kambulov.loop;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * @param n целночисенный параметр расчёта факториала.
     * @return Возвращает факториал перменной "n".
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
