package ru.kambulov.convertor;

/**
 * Программа конвертирования. В данном случае валютный конвертор.
 * @Author Kambulov (mailto:kia289@mail.ru)
 * @Since 1.0
 */

public class Convertor {
    /**
     * Рубли в евро.
     * @param value Рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }
    /**
     * Рубли в доллары.
     * @param value Рубли.
     * @return Доллары.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }
    /**
     * Евро в рубли.
     * @param value Евро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }
    /**
     * Доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}
