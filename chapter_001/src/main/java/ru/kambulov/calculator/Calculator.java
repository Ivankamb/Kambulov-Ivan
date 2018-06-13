package ru.kambulov.calculator;

/**
 * Данная программа выполняет простейшие математические действия с двумя переменными
 * @Author Kambulov Ivan
 * @Version 0.1
 * @Since 1.0
 */

public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    public void div(double first, double second) {
        this.result = first / second;
    }
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    public double getResult() {
        return this.result;
    }
}
