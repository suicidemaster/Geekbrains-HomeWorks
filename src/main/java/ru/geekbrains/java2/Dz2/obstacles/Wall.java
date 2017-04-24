package ru.geekbrains.java2.Dz2.obstacles;

import ru.geekbrains.java2.Dz2.animals.Animal;
import ru.geekbrains.java2.Dz2.animals.Jumpable;

/**
 * Created by Tim on 12.07.2016.
 */
public class Wall extends Obstacle {

    public Wall(int value) {
        super(value);
    }

    @Override
    public void doIt(Animal animal) throws Exception {
        if (animal instanceof Jumpable) {
            Jumpable jumpableAnimal = (Jumpable) animal;
            jumpableAnimal.jump(getValue());
        } else {
            animal.crossFail();

        }
//                try {
//            if (animal instanceof Jumpable) {
//            Jumpable jumpableAnimal = (Jumpable) animal;
//            jumpableAnimal.jump(getValue());
//        } else {
//            animal.crossFail();
//        }
////        } catch (WallFailException e ){
////            e.getFailInfo();
////        }
    }

    @Override
    public String toString() {
        return "стена";
    }
}
