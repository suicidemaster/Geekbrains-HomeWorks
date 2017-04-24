package ru.geekbrains.java1.dz5.animals;

public class Cat extends Animal {
    private static final int MAX_HEIGHT = 1;
    private static final int MAX_DISTANCE = 300;
    private static final int MAX__SWIM_DISTANCE = 40;

    @Override
    public void voice() {
        System.out.println(name + " мяукает");
    }


    public Cat(String name, String color, float weight) {
        super(name, color, weight);
    }

    @Override
    public void swim(int f) {
        if (MAX__SWIM_DISTANCE < f) System.out.println("Кот " + name + " не смог переплыть " + f + " метров");
        else System.out.println("Кот " + name + " переплыл " + f + " метров");

    }

    @Override
    public void jump(int f) {
        if (MAX_HEIGHT < f) System.out.println("Кот " + name + " не смог перепрыгуть препятствие в " + f + " метров");
        else System.out.println("Кот " + name + " перепрыгнул препятствие в " + f + " метров");

    }


    @Override
    public void run(int f) {
        if (MAX_DISTANCE < f) System.out.println("Кот " + name + " не смог пробежать " + f + " метров");
        else System.out.println("Кот " + name + " пробежал " + f + " метров");

    }


    public void justCatMethod() {

        System.out.println("Вызов кошачего метода");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}
