package ru.geekbrains.java2.Dz2.Exceptions;

import ru.geekbrains.java2.Dz2.obstacles.Wall;

/**
 * Created by олег on 02.02.2017.
 */
public class WallFailException extends FailException {
    public WallFailException(int value, String name) {
        super(new Wall(value), value, name);

    }
}
