package ru.kambulov.calculator;

/**
 * Программа для расчёта правильного веса для людей.
 * @Author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.1
 */
public class Fit {
    /**
     * Правильный вес для мужчины.
     * @param height Рост.
     * @return правильный вес.
     */
    public double menWeight(double height) {
        return (height - 100) * 1.15;
    }
    /**
     * Правильный вес для женщины.
     * @param height Рост.
     * @return правильный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
