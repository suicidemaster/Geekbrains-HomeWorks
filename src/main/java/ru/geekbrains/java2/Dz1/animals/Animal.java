package ru.geekbrains.java2.Dz1.animals;

/**
 * Created by Tim on 12.07.2016.
 */
public abstract class Animal {
    private String name;
    private boolean onDistance;
    private int maxDistance;

    protected Animal(String name, int maxDistance) {
        this.name = name;
        this.onDistance = true;
        this.maxDistance = maxDistance;
    }

    public void cross(int value) {
        if (value <= maxDistance) {
            System.out.println(name + " продолжает путь!");
        } else {
            crossFail();
        }
    }

    public boolean isOnDistance() {
        return this.onDistance;
    }

    public void crossFail() {
        System.out.println(this.toString() + " сошел с дистанции :(");
        setOnDistance(false);
    }

    private void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
