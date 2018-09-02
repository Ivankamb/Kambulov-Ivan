package ru.kambulov.tracker;

import java.util.List;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 1.0
 * @since 27.08.18
 */

public class StubInput implements Input {
    private String[] value;
    private int position = 0;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public int ask(String question, List<Integer> range) {
        System.out.println(question);
        return Integer.valueOf(this.value[this.position++]);
    }

    @Override
    public String ask(String question) {
     return this.value[this.position++];
    }
}
