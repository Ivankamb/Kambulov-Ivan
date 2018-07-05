package ru.kambulov.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class CheckSortedTest {
    @Test
    public void whenArrayIsSorted() {
        CheckSorted check = new CheckSorted();
        int[] input = new int[] {1, 3, 5, 8, 8, 8};
        boolean result = check.isSorted(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayIsNotSorted() {
        CheckSorted check = new CheckSorted();
        int[] input = new int[] {3, 1, 2, 10};
        boolean result = check.isSorted(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenArrayIsEmptyThenTrue() {
        CheckSorted check = new CheckSorted();
        int[] input = {};
        boolean result = check.isSorted(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayHaveOneNumeralThenTrue() {
        CheckSorted check = new CheckSorted();
        int[] input = {4};
        boolean result = check.isSorted(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenAllNumbersAsOneThenTrue() {
        CheckSorted check = new CheckSorted();
        int[] input = {3, 3, 3, 3, 3, 3, 3};
        boolean result = check.isSorted(input);
        assertThat(result, is(true));
    }
}
