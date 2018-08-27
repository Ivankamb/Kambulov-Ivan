package ru.kambulov.geometry;

import org.junit.Test;
import ru.kambulov.geometry1.Triangle;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 08.08.18
 */
public class TriangleTest {

    @Test
    public void whenDrawtriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                        .append("    X    ")
                        .append(System.lineSeparator())
                        .append("  X   X  ")
                        .append(System.lineSeparator())
                        .append(" X     X ")
                        .append(System.lineSeparator())
                        .append("XXXXXXXXX")
                        .toString()
        ));
    }
}
