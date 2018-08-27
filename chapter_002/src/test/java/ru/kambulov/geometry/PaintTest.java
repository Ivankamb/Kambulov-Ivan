package ru.kambulov.geometry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.kambulov.geometry1.Paint;
import ru.kambulov.geometry1.Square;
import ru.kambulov.geometry1.Triangle;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.2
 * @since 08.08.18
 */
public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Execute after method");
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("XXXXXXX")
                                .append(System.lineSeparator())
                                .append("X     X")
                                .append(System.lineSeparator())
                                .append("X     X")
                                .append(System.lineSeparator())
                                .append("XXXXXXX")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("    X    ")
                                .append(System.lineSeparator())
                                .append("  X   X  ")
                                .append(System.lineSeparator())
                                .append(" X     X ")
                                .append(System.lineSeparator())
                                .append("XXXXXXXXX")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
