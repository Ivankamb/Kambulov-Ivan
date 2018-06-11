package ru.kambulov.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *@author Kambulov Ivan (mailto:kia289@mail.ru)
 *@version $Id$
 *@since 0.1
 */

public class CalculateTest {

	@Test

	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Kambulov Ivan";
		String expect = "Echo, echo, echo : Kambulov Ivan";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));

	}


}

