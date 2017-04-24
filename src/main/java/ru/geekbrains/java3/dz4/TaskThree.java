package ru.geekbrains.java3.dz4;

/**
 * Created by KGBkid on 21.03.2017.
 */
public class TaskThree {
    Printer printer = new Printer();
    Thread thread1 = new Thread(() -> {
        printer.print("Пользователь 1");

    });
    Thread thread2 = new Thread(() -> {
        printer.print("Пользователь 2");

    });


    Scaner scaner = new Scaner();
    Thread thread3 = new Thread(() -> {
        scaner.scan("Пользователь 1");

    });
    Thread thread4 = new Thread(() -> {
        scaner.scan("Пользователь 2");

    });
}
