package ru.geekbrains.java3.dz4;

/**
 * Created by KGBkid on 20.03.2017.
 */
public class TaskOne {
//    1. Создать три потока, каждый из которых выводит определенную букву(A, B и C)
// 5 раз, порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.

    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while ( currentLetter !='A')
                        mon.wait();
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter !='B')
                        mon.wait();
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter !='C')
                        mon.wait();
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
