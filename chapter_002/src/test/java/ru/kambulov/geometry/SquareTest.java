package ru.kambulov.geometry;

import org.junit.Test;
import ru.kambulov.geometry1.Square;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.2
 * @since 08.08.18
 */
public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(
                new StringBuilder()
                        .append("XXXXXXX")
                        .append(System.lineSeparator())
                        .append("X     X")
                        .append(System.lineSeparator())
                        .append("X     X")
                        .append(System.lineSeparator())
                        .append("XXXXXXX")
                        .toString()
        ));
    }
}
