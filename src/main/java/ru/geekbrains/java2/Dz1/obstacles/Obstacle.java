package ru.geekbrains.java2.Dz1.obstacles;

import ru.geekbrains.java2.Dz1.animals.Animal;

/**
 * Created by Tim on 12.07.2016.
 */
public abstract class Obstacle {
    private int value;

    public abstract void doIt(Animal animal);

    public Obstacle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Obstacle() {

    }
}
