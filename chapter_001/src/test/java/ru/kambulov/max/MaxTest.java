package ru.kambulov.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**
     * Тестируем метод вычисления большего числа из двух.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int result = maximum.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Тест нахождения большего чесла из трёх.
     */
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maximum = new Max();
        int result = maximum.max(1, 2, 3);
        assertThat(result, is(3));
    }
}
