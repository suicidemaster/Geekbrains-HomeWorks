package ru.geekbrains.java2.Dz2;

import ru.geekbrains.java2.Dz2.Exceptions.AnimalOutFromDistanceException;
import ru.geekbrains.java2.Dz2.Exceptions.FailException;
import ru.geekbrains.java2.Dz2.animals.Animal;
import ru.geekbrains.java2.Dz2.animals.Cat;
import ru.geekbrains.java2.Dz2.animals.Duck;
import ru.geekbrains.java2.Dz2.animals.Turtle;
import ru.geekbrains.java2.Dz2.obstacles.Cross;
import ru.geekbrains.java2.Dz2.obstacles.Wall;
import ru.geekbrains.java2.Dz2.obstacles.Water;
import ru.geekbrains.java2.Dz2.obstacles.Obstacle;

/**
 * Created by Tim on 12.07.2016.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Готовимся к старту...");

        Animal[] animals = new Animal[3];

        animals[0] = new Cat("Мурзик");
        animals[1] = new Duck("Квака");
        animals[2] = new Turtle("Череп");

        Obstacle[] obstacles = new Obstacle[3];

        obstacles[0] = new Cross(400); //бег на 400 метров
        obstacles[1] = new Wall(3); //трехметровая стена
        obstacles[2] = new Water(200); //200 метров вплавь

        System.out.println("Старт!");

//        try {
        for (int i = 0; i < obstacles.length; i++) {
            Obstacle obstacle = obstacles[i];
            System.out.println("- Препятствие " + obstacle);
            for (int j = 0; j < animals.length; j++) {
                Animal animal = animals[j];

                if (animal.isOnDistance()) {
                    try {
                        obstacle.doIt(animal);
                    } catch (FailException e) {
                        e.getFailInfo();
                    } catch (AnimalOutFromDistanceException e) {

                    } catch (Exception e) {}
                }

            }
        }
//        } catch (AnimalOutFromDistanceException e) {

        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            if (animal.isOnDistance()) {
                System.out.println(animal.getName() + " ФИНИШИРОВАЛ!!!");
            }
        }


    }


}

