package ru.geekbrains.java2.Dz2.Exceptions;

import ru.geekbrains.java2.Dz2.obstacles.Water;

/**
 * Created by олег on 02.02.2017.
 */
public class WaterFailException extends FailException {
    public WaterFailException(int value, String name) {
        super(new Water(value), value, name);

    }
}
