package ru.geekbrains.java2.Dz1.obstacles;

import ru.geekbrains.java2.Dz1.animals.Animal;
import ru.geekbrains.java2.Dz1.animals.NightVision;

/**
 * Created by олег on 30.01.2017.
 */

// Задание №2
public class Night extends Obstacle {
    public Night() {
        super();
    }

    @Override
    public void doIt(Animal animal) {
        if (animal instanceof NightVision) {
            NightVision nightSeeingAnimal = (NightVision) animal;
            nightSeeingAnimal.nightVision();
        } else

        {
            animal.crossFail();
        }
    }

    @Override
    public String toString() {
        return "ночь";
    }
}