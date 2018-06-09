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
/**
*Test echo
*@Test
*метод назван по принципу when...Then...
*/
		public void whenTakeNameThenThreeEchoPlusName() {
		/**
		*создаётся переменная input строчного типа	
		*/
		String input = "Kambulov Ivan";
		/**
		*Ожидаемый рез-тат
		*/
	    String expect = "Echo, echo, echo : Kambulov Ivan"; 
		/**
		*Создание перменной calc Класса Calculate
		*/
	    Calculate calc = new Calculate();
		/**
		*выполнение метода echo с параметром input и запись её переменную в result
		*/
		String result = calc.echo(input);
		/**
		*Сравнение значений
		*/
		assertThat(result, is(expect));
		
		}
		
		
}

