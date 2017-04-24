package ru.geekbrains.java1.dz5.animals;

public abstract class Animal extends Object {
    private static final String CONSTANT_1 = "fgdfh";
    protected String name;
    String nameDef;
    public String namePub;
    private String color;
    private float weight;

    public void walk(float f) {
        System.out.println("Животное " + name + " прогуливается...");
    }

    public void run(int f) {
        System.out.println("Животное " + name + " пробежало " + f + " метров");
    }

    public void jump(int f) {
        System.out.println(name + " прыгает");
    }

    public void swim(int f) {
        System.out.println(name + " плавает");
    }

    public void printInfo() {
        System.out.println("Имя: " + name + " Цвет: " + color + " Вес: " + weight + " кг.");
    }

    public abstract void voice();


    public Animal(String name, String color, float weight) {
        super();
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
