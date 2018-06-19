package ru.kambulov.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *@author Kambulov Ivan (mailto:kia289@mail.ru)
 *@version $Id$
 *@since 0.1
 */
public class TurnTest {
    /**
     * Два следующих тест проверяют работу программы на массиве с чётным кол-вом и нечётным соответственно.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4};
        int[] result = turner.turn(input);
        int[] expect = new int[] {4, 3, 2, 1};
        assertThat(result, is(expect));
    }
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {8, 23, 44, 1, 41, 10, 9};
        int[] result = turner.turn(input);
        int[] expect = new int[] {9, 10, 41, 1, 44, 23, 8};
        assertThat(result, is(expect));
    }
}
