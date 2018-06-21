package ru.kambulov.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixTest {
    @Test
    public void when2On2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {{1, 2},
                          {2, 4}};
        assertThat(table, is(expect));
    }
}
