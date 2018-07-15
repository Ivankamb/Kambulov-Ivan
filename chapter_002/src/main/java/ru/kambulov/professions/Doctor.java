package ru.kambulov.professions;

/**
 * Наследник класса Profession.
 */

public class Doctor extends Profession {

    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }

    class Diagnose {
        String name;
    }
}