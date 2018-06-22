package ru.kambulov.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.2
 */
public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false, true},
                {false, true, false},
                {true, true, true}};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenDataMonoByTrueThenTrue2() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false, false, false},
                {false, true, false, false},
                {true, false, true, false},
                {false, false, false, true}};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}