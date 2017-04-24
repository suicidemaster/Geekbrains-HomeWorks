package ru.geekbrains.java1.dz5.animals;

public class Dog extends Animal {
    private static final int MAX_HEIGHT = 2;
    private static final int MAX_DISTANCE = 2000;
    private static final int MAX__SWIM_DISTANCE = 600;

    @Override
    public void voice() {
        System.out.println(name + " лает");
    }

    public Dog(String name, String color, float weight) {
        super(name, color, weight);
    }


    @Override
    public void swim(int f) {
        if (MAX__SWIM_DISTANCE < f) System.out.println("Собака " + name + " не смогла переплыть " + f + " метров");
        else System.out.println("Собака " + name + " переплыла " + f + " метров");

    }

    @Override
    public void jump(int f) {
        if (MAX_HEIGHT < f)
            System.out.println("Собака " + name + " не смогла перепрыгуть препятствие в " + f + " метров");
        else System.out.println("Собака " + name + " перепрыгнула препятствие в " + f + " метров");

    }


    @Override
    public void run(int f) {
        if (MAX_DISTANCE < f) System.out.println("Собака " + name + " не смогла  пробежать " + f + " метров");
        else System.out.println("Собака " + name + " пробежала " + f + " метров");

    }
}