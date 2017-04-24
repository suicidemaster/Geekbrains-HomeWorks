package ru.geekbrains.java2.Dz1;

import ru.geekbrains.java2.Dz1.animals.*;
import ru.geekbrains.java2.Dz1.obstacles.*;



/**
 * Created by Tim on 12.07.2016.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Готовимся к старту...");

        Animal[] animals = new Animal[4];

        animals[0] = new Cat("Мурзик");
        animals[1] = new Duck("Квака");
        animals[2] = new Turtle("Череп");
        animals[3] = new Owl("Сава");


        Obstacle[] obstacles = new Obstacle[4];

        obstacles[0] = new Cross(400); //бег на 400 метров
        obstacles[1] = new Wall(3); //трехметровая стена
        obstacles[2] = new Water(200); //200 метров вплавь
        obstacles[3] = new Night();

        Competition competition = new Competition(obstacles, animals);
//        competition.doCompetition();
        competition.doObstacle(obstacles[1]);

//
//        System.out.println("Старт!");
//
//        for (int i = 0; i < obstacles.length; i++) {
//            Obstacle obstacle = obstacles[i];
//            System.out.println("- Препятствие " + obstacle);
//            for (int j = 0; j < animals.length; j++) {
//                Animal animal = animals[j];
//                if (animal.isOnDistance()) {
//                    obstacle.doIt(animal);
//                }
//            }
//        }
//
//        for (int i = 0; i < animals.length; i++) {
//            Animal animal = animals[i];
//            if (animal.isOnDistance()) {
//                System.out.println(animal.getName() + " ФИНИШИРОВАЛ!!!");
//            }
//        }

    }
}
