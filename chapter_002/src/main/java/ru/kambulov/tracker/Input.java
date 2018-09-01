package ru.kambulov.tracker;

import java.util.List;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public interface Input {
    int ask(String question, List<Integer> range);

    String ask(String question);
}
