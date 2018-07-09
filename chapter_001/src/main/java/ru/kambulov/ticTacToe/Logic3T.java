package ru.kambulov.ticTacToe;

import java.util.function.Predicate;

/**
 * Метода отвечают за логику игры "Крестики-нолики".
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
    /**
     * Метод для логики крестиков.
     * @return возвращает рез-тат проверки поля на наличие победы.
     */
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
    /**
     * Метод для логики ноликов.
     * @return возвращает рез-тат проверки поля на наличие победы.
     */
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
    /**
     * Проверка поля на наличие пустых ячеек.
     * @return есть ли пустые ячейки на поле?
     */
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
/*
    public boolean isWinnerX() {
        int line = 0, column = 0;
        boolean result = false;
        for (; line != table.length; line++) {
            if (table[line][0].hasMarkX() & table[line][1].hasMarkX() & table[line][2].hasMarkX()) {
                result = true;
                line = 0;
                break;
            }
        }
        for (; column != table.length; column++) {
            if (table[0][column].hasMarkX() & table[1][column].hasMarkX() & table[2][column].hasMarkX()) {
                result = true;
                column = 0;
                break;
            }
        }
        if ((table[0][0].hasMarkX() & table[1][1].hasMarkX() & table[2][2].hasMarkX())
                || (table[table.length - 1][0].hasMarkX() & table[1][1].hasMarkX() & table[0][2].hasMarkX())) {
            result = true;
        }
        return result;
    }
    public boolean isWinnerO() {
        int line = 0, column = 0;
        boolean result = false;
        for (; line != table.length; line++) {
            if (table[line][0].hasMarkO() & table[line][1].hasMarkO() & table[line][2].hasMarkO()) {
                result = true;
                line = 0;
                break;
            }
        }
        for (; column != table.length; column++) {
            if (table[0][column].hasMarkO() & table[1][column].hasMarkO() & table[2][column].hasMarkO()) {
                result = true;
                column = 0;
                break;
            }
        }
        if ((table[0][0].hasMarkO() & table[1][1].hasMarkO() & table[2][2].hasMarkO())
                || (table[table.length - 1][0].hasMarkO() & table[1][1].hasMarkO() & table[0][2].hasMarkO())) {
            result = true;
        }
        return result;
    }
    */
