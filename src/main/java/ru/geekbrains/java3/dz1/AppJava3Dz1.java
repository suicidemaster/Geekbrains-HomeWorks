package ru.geekbrains.java3.dz1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by олег on 27.02.2017.
 */
public class AppJava3Dz1 {

    private Object a, b;

    public static void main(String[] args) {
        AppJava3Dz1 app = new AppJava3Dz1();


        Object[] arrayOfObjects = new Object[]{1, 2, 3, "String", 5, 6, 7, "Integer", 9, 10};

        app.exchange(arrayOfObjects, arrayOfObjects[3], arrayOfObjects[8]);
        System.out.println(Arrays.toString(arrayOfObjects));
        List arrayList = app.arrayConvertToList(arrayOfObjects);
        arrayList.add("Double");
        arrayList.add(15);
        System.out.println(arrayList);
        //Задача №3 - Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        Box<Orange> boxOfOranges = new Box<>();
        Orange orange = new Orange();
        boxOfOranges.addFruits(orange, orange, orange, orange);
        Box<Apple> boxOfApples = new Box<>();
        Box<Orange> newBoxOfOranges = new Box<>();
        boxOfOranges.putFruitsToBox(newBoxOfOranges);
        Apple apple = new Apple();
        boxOfApples.addFruits(apple, apple, apple, apple);
        System.out.println(boxOfApples.compare(boxOfOranges));
        System.out.println(boxOfOranges.getWeight());
        System.out.println(boxOfApples.getWeight());
        System.out.println(newBoxOfOranges.getWeight());

    }

    //Задача №1 - Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public Object[] exchange(Object[] array, Object a, Object b) {
        Object[] tempArray = array.clone();
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i].equals(a)) array[i] = b;
            if (tempArray[i].equals(b)) array[i] = a;
        }
        return array;
    }

    //    Задача №2 - Написать метод, который преобразует массив в ArrayList;
    public ArrayList arrayConvertToList(Object[] array) {
        ArrayList arrayList = new ArrayList(Arrays.asList(array));
        return arrayList;
    }

}
