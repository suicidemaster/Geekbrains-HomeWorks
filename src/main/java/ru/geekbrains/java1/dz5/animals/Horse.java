package ru.geekbrains.java1.dz5.animals;

public class Horse extends Animal {
    private static final int MAX_HEIGHT = 3;
    private static final int MAX_DISTANCE = 30000;
    private static final int MAX__SWIM_DISTANCE = 4000;

    public Horse(String name, String color, float weight) {
        super(name, color, weight);
    }

    @Override
    public void voice() {
        System.out.println(name + " ржет");
    }

    @Override
    public void swim(int f) {
        if (MAX__SWIM_DISTANCE < f) System.out.println("Лошадь " + name + " не смогла переплыть " + f + " метров");
        else System.out.println("Лошадь " + name + " переплыла " + f + " метров");

    }

    @Override
    public void jump(int f) {
        if (MAX_HEIGHT < f)
            System.out.println("Лошадь " + name + " не смогла перепрыгуть препятствие в " + f + " метров");
        else System.out.println("Лошадь " + name + " перепрыгнула препятствие в " + f + " метров");

    }


    @Override
    public void run(int f) {
        if (MAX_DISTANCE < f) System.out.println("Лошадь " + name + " не смогла  пробежать " + f + " метров");
        else System.out.println("Лошадь " + name + " пробежала " + f + " метров");

    }
}