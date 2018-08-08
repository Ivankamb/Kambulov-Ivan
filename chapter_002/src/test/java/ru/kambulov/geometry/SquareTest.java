package ru.kambulov.geometry;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 08.08.18
 */
public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(
                new StringBuilder()
                        .append("XXXXXXX\n")
                        .append("X     X\n")
                        .append("X     X\n")
                        .append("XXXXXXX")
                        .toString()
                )
        );
    }
}
