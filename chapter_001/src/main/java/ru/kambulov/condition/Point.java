package ru.kambulov.condition;
/**
 * @Author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     *Данный метод производит вычисление по формуле и возвращает рез-тат.
     * @param that
     * @return расстояние
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
    /**
     * Внутри метода main создаются две точки в системе координат.
     * Так же выводится на консоль расчёт расстояния между ними.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}

