package ru.kambulov.calculator;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Тустовый класс для Fit.java
 * @Author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.1
 */

public class FitTest {
    @Test
    public void menWeight() {  //Тест для расчёта веса мужика.
        Fit fit = new Fit();
        double weight = fit.menWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }
    @Test
    public void womanWeight() {  //Тест для расчёта веса женщины.
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
