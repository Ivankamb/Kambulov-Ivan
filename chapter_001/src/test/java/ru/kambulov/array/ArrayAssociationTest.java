package ru.kambulov.array;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayAssociationTest {
    /**
     * Два массива сливаются в один.
     */
    @Test
    public void whenFirstArrayPlusSecondArrayThenThirdArray() {
        ArrayAssociation conc = new ArrayAssociation();
        int[] input1 = new int[]{1, 2, 4, 4, 9, 11};
        int[] input2 = new int[]{3, 4, 6, 8, 9, 11, 13, 14};
        int[] result = conc.association(input1, input2);
        int[] expect = {1, 2, 3, 4, 4, 4, 6, 8, 9, 9, 11, 11, 13, 14};
        assertThat(result, is(expect));
    }
    @Test
    public void whenAllNumbersOne() {
        ArrayAssociation conc = new ArrayAssociation();
        int[] input1 = new int[]{1, 1, 1, 1, 1, 1};
        int[] input2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int[] result = conc.association(input1, input2);
        int[] expect = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertThat(result, is(expect));
    }
}

