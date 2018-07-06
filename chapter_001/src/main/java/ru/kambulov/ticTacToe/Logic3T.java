package ru.kambulov.ticTacToe;
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
    /**
     * Метод для логики крестиков.
     * @return возвращает рез-тат проверки поля на наличие победы.
     */
    public boolean isWinnerX() {
        boolean result = false;
        for (int line = 0, column = 0; line < table.length; ++line) {
            if (table[line][column].hasMarkX() & table[line][column + 1].hasMarkX() & table[line][column + 2].hasMarkX()) {
                result = true;
                break;
            }
        }
        for (int line = 0, column = 0; column < table.length; ++column) {
            if (table[line][column].hasMarkX() & table[line + 1][column].hasMarkX() & table[line + 2][column].hasMarkX()) {
                result = true;
                break;
            }
        }
        if ((table[0][0].hasMarkX() & table[1][1].hasMarkX() & table[2][2].hasMarkX())
                || (table[table.length - 1][0].hasMarkX() & table[1][1].hasMarkX() & table[0  ][2].hasMarkX())) {
            result = true;
        }
        return result;
    }
    /**
     * Метод для логики ноликов.
     * @return возвращает рез-тат проверки поля на наличие победы.
     */
    public boolean isWinnerO() {
        boolean result = false;
        for (int line = 0, column = 0; line < table.length; ++line) {
            if (table[line][column].hasMarkO() & table[line][column + 1].hasMarkO() & table[line][column + 2].hasMarkO()) {
                result = true;
                break;
            }
        }
        for (int line = 0, column = 0; column < table.length; ++column) {
            if (table[line][column].hasMarkO() & table[line + 1][column].hasMarkO() & table[line + 2][column].hasMarkO()) {
                result = true;
                break;
            }
        }
        if ((table[0][0].hasMarkO() & table[1][1].hasMarkO() & table[2][2].hasMarkO())
                || (table[table.length - 1][0].hasMarkO() & table[1][1].hasMarkO() & table[0][2].hasMarkO())) {
            result = true;
        }
        return result;
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