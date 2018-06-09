package ru.kambulov.calculate;
/**
Метод main в данном классе является исполняющим программу
сама программа выводит на консоль текстовое сообщение Hello wonderful world!
@author Kambulov Ivan
@since version 1.0
*/
public class Calculate{
	/**
	Main.
	@param args - args.
	*/
	public static void main(String[] args){
		System.out.println("Hello wonderful world!");
		}
	/**
	Method echo.
	@param name Your name.
	@return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}