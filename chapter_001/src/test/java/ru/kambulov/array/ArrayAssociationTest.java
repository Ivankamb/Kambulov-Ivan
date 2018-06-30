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
        int[] input1 = new int[]{1, 3, 4};
        int[] input2 = new int[]{2, 3};
        int[] result = conc.association(input1, input2);
        int[] expect = {1, 2, 3, 3, 4};
        assertThat(result, is(expect));
    }
    @Test
    public void whenAllNumbersZero() {
        ArrayAssociation conc = new ArrayAssociation();
        int[] input1 = new int[]{0, 0, 0};
        int[] input2 = new int[]{0, 0, 0, 0};
        int[] result = conc.association(input1, input2);
        int[] expect = {0, 0, 0, 0, 0, 0, 0};
        assertThat(result, is(expect));
    }
    @Test
    public void whenMassivesEmpty() {
        ArrayAssociation conc = new ArrayAssociation();
        int[] input1 = {};
        int[] input2 = {};
        int[] result = conc.association(input1, input2);
        int[] expect = {};
        assertThat(result, is(expect));
    }
    @Test
    public void whenFirstArrayIsEmpty() {
        ArrayAssociation conc = new ArrayAssociation();
        int[] input1 = {};
        int[] input2 = {1, 22, 60001};
        int[] result = conc.association(input1, input2);
        int[] expect = {1, 22, 60001};
        assertThat(result, is(expect));
    }
    @Test
    public void whenSecondArrayIsEmpty() {
        ArrayAssociation conc = new ArrayAssociation();
        int[] input1 = {3, 3, 4, 12};
        int[] input2 = {};
        int[] result = conc.association(input1, input2);
        int[] expect = {3, 3, 4, 12};
        assertThat(result, is(expect));
    }
}

