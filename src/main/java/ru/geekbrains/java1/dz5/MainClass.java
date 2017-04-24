package ru.geekbrains.java1.dz5;


import ru.geekbrains.java1.dz5.animals.Animal;
import ru.geekbrains.java1.dz5.animals.Cat;
import ru.geekbrains.java1.dz5.animals.Dog;
import ru.geekbrains.java1.dz5.animals.Horse;

public class MainClass {

    public static void main(String[] args) {
        Animal[] animals = new Animal[3]; // создаем список животных
        animals[0] = new Cat("Барсик", "Белый", 2);
        animals[1] = new Dog("Бобик", "Черный", 2);
        animals[2] = new Horse("Алмаз", "Коричневый", 30);


        for (int i = 0; i < animals.length; i++) { // проходимся по всему списку
            animals[i].voice(); // просим каждое животное подать голос
        }
        for (int i = 0, k = 250; i < animals.length; i++) { // проходимся по всему списку
            animals[i].swim(k); // проверяем смогло ли животное проплыть 250м
        }
        for (int i = 0, k = 2500; i < animals.length; i++) { // проходимся по всему списку
            animals[i].run(k); // проверяем смогло ли животное пробежать 2500м
        }
        for (int i = 0, k = 2; i < animals.length; i++) { // проходимся по всему списку
            animals[i].jump(k); // проверяем смогло ли животное перепрыгнуть 2м
        }
    }
}
