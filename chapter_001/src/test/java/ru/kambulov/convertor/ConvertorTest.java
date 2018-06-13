package ru.kambulov.convertor;
/**
 * Тест для конвертора валют.
 * @Author Kambulov (mailto:kia289@mail.ru)
 * @Sience 1.0
 * @version 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertorTest {
    /**
     * Далее следуют два теста проверяющие конвертацию рублей в доллары и в евро соответственно.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Convertor convertor = new Convertor();
        int result = convertor.rubleToDollar(60);
        assertThat(result, is(1));
    }
    @Test
    public void when70RubleToEuroThen1() {
        Convertor convertor = new Convertor();
        int result = convertor.rubleToEuro(70);
        assertThat(result, is(1));
    }
}
