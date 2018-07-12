package ru.kambulov.ticTacToe;
import java.util.function.Predicate;
/**
 * Данный класс отвечает за логику игры "Крестики-нолики".
 * Метод fillBy отвечает за поведение направления при проверке в методах проверки крестиков и ноликов.
 * Метод isWinnerX отвечает за проверку игры крестиками.
 * Метод isWinnerO отвечает за проверку игры ноликами.
 * Метод hasGap проверяет наличие пустых ячеек необходимых для хода игрока.
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)||
                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)||
                this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0)||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)||
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)||
                this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1)||
                this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int line = 0; line < table.length; line++) {
            for (int column = 0; column < table.length; column++) {
                if (!(table[line][column].hasMarkX()) && !(table[line][column].hasMarkO())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}