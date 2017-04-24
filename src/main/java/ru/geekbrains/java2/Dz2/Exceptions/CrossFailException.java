package ru.geekbrains.java2.Dz2.Exceptions;

import ru.geekbrains.java2.Dz2.obstacles.Cross;

/**
 * Created by олег on 02.02.2017.
 */
public class CrossFailException extends FailException {
    public CrossFailException(int value, String name) {
        super(new Cross(value), value, name);

    }
}
