package ru.kambulov.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Метод вычисления полупериметра по длиннам сторон.
     * Формула (ab + ac + bc) / 2
     * @param ab расстояние между точками А и В.
     * @param ac расстояние между точками А и С.
     * @param bc расстояние между точками В и С.
     * @return Площадь.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Метод должен вычислять площадь треугольника.
     * @return Вернуть площадь, если треугольник существует.
     * или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
    /**
     * Метод проверки возможности создания треугольника с заданными параметрами.
     * @param ab Длинна от точки A до точки B.
     * @param ac Длинна от точки A до точки C.
     * @param bc Длинна от точки B до точки C.
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        if (ab < ac + bc) {
            if (ac < ab + bc) {
                if (bc < ab + ac) {
                    return true;
                }
            }
        }
        return false;
    }



}
