package ru.geekbrains.java2.Dz2.obstacles;

import ru.geekbrains.java2.Dz2.animals.Animal;

/**
 * Created by Tim on 12.07.2016.
 */
public class Cross extends Obstacle {

    public Cross(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal) throws Exception {
        animal.cross(getValue());
//        try {
//            animal.cross(getValue());
//        } catch (FailException e) {
//            e.getFailInfo();
//           throw new AnimalOutFromDistanceException();
    }

    @Override
    public String toString() {
        return "бег на дистанцию";
    }
}