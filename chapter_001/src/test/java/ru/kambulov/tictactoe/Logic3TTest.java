package ru.kambulov.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic3TTest {
    @Test
    public void whenHasXWinnerDiagonal() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(true), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerVertical() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXWinnerHorizontal() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOWinnerDiagonal() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(true), new Figure3T(false), new Figure3T(true)},
                {new Figure3T(true), new Figure3T(true), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerVertical() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
                {new Figure3T(), new Figure3T(), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasOWinnerHorizontal() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(false), new Figure3T(false)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(true), new Figure3T(), new Figure3T(true)},
                {new Figure3T(), new Figure3T(true), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(true));
    }

    @Test
    public void whenHasNoGap() {
        Figure3T[][] table = {
                {new Figure3T(false), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(true)},
                {new Figure3T(false), new Figure3T(true), new Figure3T(true)},
        };
        Logic3T login = new Logic3T(table);
        assertThat(login.hasGap(), is(false));
    }
}

