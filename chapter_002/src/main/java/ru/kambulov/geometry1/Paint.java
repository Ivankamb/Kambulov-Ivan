package ru.kambulov.geometry1;

/**
 * @author Ivan Kambulov (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 08.08.18
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
