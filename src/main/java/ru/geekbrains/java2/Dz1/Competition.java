package ru.geekbrains.java2.Dz1;

import ru.geekbrains.java2.Dz1.animals.Animal;
import ru.geekbrains.java2.Dz1.obstacles.Obstacle;

/**
 * Created by олег on 30.01.2017.
 */

// Задание №4
public class Competition {
    private Animal[] animals;
    private Obstacle[] obstacles;

    public Competition(Obstacle[] obstacles, Animal[] animals) {
        this.animals = animals;
        this.obstacles = obstacles;
    }


    public void doCompetition() {
        System.out.println("Старт!");
        for (Obstacle obstacle : obstacles) {
            System.out.println("-Препятствие" + obstacle);
            for (Animal animal : animals) {
                if (animal.isOnDistance()) obstacle.doIt(animal);
            }
        }
        for (Animal animal : animals) {
            if (animal.isOnDistance()) System.out.println(animal.getName() + " Финишировал!!!");
        }
    }

    // Задание №5
    public void doObstacle(Obstacle obstacle) {
        System.out.println("Старт!");
        System.out.println("-Препятствие" + obstacle);
        for (Animal animal : animals) {
            if (animal.isOnDistance()) obstacle.doIt(animal);
        }
    }
}