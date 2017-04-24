package ru.geekbrains.java2.Dz2.Exceptions;

import ru.geekbrains.java2.Dz2.obstacles.Obstacle;

/**
 * Created by олег on 02.02.2017.
 */
public class FailException extends AppException {
    private Obstacle obstacle;
    private int value;
    private String name;

    public FailException(Obstacle obstacle, int value, String name) {
        this.obstacle = obstacle;
        this.value = value;
        this.name = name;
    }

    public void getFailInfo() {
        System.out.println(name + " выбыл на препятствии " + obstacle + " размером " + value);
    }
}
