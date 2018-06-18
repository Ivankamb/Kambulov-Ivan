package ru.kambulov.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {
    @Test
    public void whenArrayHasLenght5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(0));
    }
    @Test
    public void whenArrayHasLenght6Then4() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 4, 44, 82};
        int value = 82;
        int result = find.indexOf(input, value);
        int expect = 5;
        assertThat(result, is(5));
    }
}
