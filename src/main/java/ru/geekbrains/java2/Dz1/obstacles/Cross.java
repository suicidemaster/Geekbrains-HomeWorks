package ru.geekbrains.java2.Dz1.obstacles;

import ru.geekbrains.java2.Dz1.animals.Animal;

/**
 * Created by Tim on 12.07.2016.
 */
public class Cross extends Obstacle {

    public Cross(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal) {
        animal.cross(getValue());
    }

    @Override
    public String toString() {
        return "бег на дистанцию";
    }
}
