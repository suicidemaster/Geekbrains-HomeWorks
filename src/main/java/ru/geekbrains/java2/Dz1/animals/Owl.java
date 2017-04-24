package ru.geekbrains.java2.Dz1.animals;

/**
 * Created by олег on 30.01.2017.
 */

// Задание №3
public class Owl extends Animal implements NightVision, Jumpable, Swimable {
    private static final int MAX_CROSS_DISTANCE = 1000;
    private static final int MAX_JUMP_HEIGHT = 200;
    private static final int MAX_SWIM_DIST = 1000;

    public Owl(String name) {
        super(name, MAX_CROSS_DISTANCE);
    }

    public void nightVision() {
        System.out.println(this + " продолжает путь!");
    }

    @Override
    public String toString() {
        return "Сова " + getName();
    }

    @Override
    public void jump(int height) {
        if (height < MAX_JUMP_HEIGHT) {
            System.out.println(getName() + " продолжает путь!");
        } else {
            crossFail();
        }
    }

    @Override
    public void swim(int dist) {
        if (dist < MAX_SWIM_DIST) {
            System.out.println(getName() + " продолжает путь!");
        } else {
            crossFail();
        }
    }
}