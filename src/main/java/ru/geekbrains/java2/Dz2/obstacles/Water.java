package ru.geekbrains.java2.Dz2.obstacles;

import ru.geekbrains.java2.Dz2.animals.Animal;
import ru.geekbrains.java2.Dz2.animals.Swimable;

/**
 * Created by Tim on 13.07.2016.
 */
public class Water extends Obstacle {

    public Water(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal) throws Exception {
        if (animal instanceof Swimable) {
            Swimable swimableAnimal = (Swimable) animal;
            swimableAnimal.swim(getValue());
        } else {
//            animal.crossFail();
        }
    }

    @Override
    public String toString() {
        return "вода";
    }
}
