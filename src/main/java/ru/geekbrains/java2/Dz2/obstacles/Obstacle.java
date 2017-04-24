package ru.geekbrains.java2.Dz2.obstacles;

import ru.geekbrains.java2.Dz2.animals.Animal;

/**
 * Created by Tim on 12.07.2016.
 */
public abstract class Obstacle {
    private int value;

    public abstract void doIt(Animal animal) throws Exception;

    public Obstacle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
