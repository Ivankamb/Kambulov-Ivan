package ru.kambulov.tracker;

/**
 * @author Kambulov Ivan (mailto:kia289@mail.ru)
 * @version 0.1
 * @since 07.08.18
 */
public class StubInput implements Input {
    private final String[] value;
    private String[] answers;
    private int position = 0;

    public StubInput(final String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        return this.value[this.position++];

    }
}
