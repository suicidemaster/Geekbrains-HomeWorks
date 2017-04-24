package ru.geekbrains.java3.dz4;

/**
 * Created by KGBkid on 21.03.2017.
 */
public class Scaner {
    public synchronized void scan(String user) {
        for (int page = 1; page < 10; page++) {
            System.out.printf("Пользователь %s сканирует страницу №%d\n", user, page);
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
