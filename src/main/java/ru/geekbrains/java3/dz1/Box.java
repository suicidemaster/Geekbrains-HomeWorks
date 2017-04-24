package ru.geekbrains.java3.dz1;

import java.util.ArrayList;

/**
 * Created by олег on 27.02.2017.
 */
    //Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
    // поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
public class Box<T extends Fruit> {

    //Для хранения фруктов внутри коробки можете использовать ArrayList;
    ArrayList<Fruit> fruitBox = new ArrayList<>();
    private T fruit;

    // Ну и не забываем про метод добавления фрукта в коробку;
    public ArrayList addFruits(T... fruits) {
        for (Fruit fruit : fruits) {
            fruitBox.add(fruit);
        }
        return fruitBox;
    }

    //Сделать метод getWeight() который высчитывает вес коробки, зная кол-во фруктов и вес
    //одного фрукта
    public double getWeight() {
        double weight = 0;
        for (Fruit i : fruitBox) {
            weight += i.getWeight();
        }
        return weight;
    }

    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
    // (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
    // соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
    // которые были в этой коробке;
    public Box<T> putFruitsToBox(Box<T> box) {
        if (box.fruitBox.isEmpty()) {
            box.fruitBox.ensureCapacity(this.fruitBox.size());
            box.fruitBox = new ArrayList(this.fruitBox);
            this.fruitBox.clear();
        }
        return box;


    }

    // Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку
    // с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в
    // противной случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }
}
