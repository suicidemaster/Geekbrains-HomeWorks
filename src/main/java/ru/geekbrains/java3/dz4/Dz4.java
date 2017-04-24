package ru.geekbrains.java3.dz4;

/**
 * Created by KGBkid on 20.03.2017.
 */
public class Dz4 {
    public static void main(String[] args) {
        System.out.println("Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз, порядок\n" +
                "должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.\n");
        TaskOne w = new TaskOne();
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(() -> {
                w.printA();
            });
            Thread t2 = new Thread(() -> {
                w.printB();
            });
            Thread t3 = new Thread(() -> {
                w.printC();
            });

            t1.start();
            t2.start();
            t3.start();
        }
//        System.out.println("Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук\n" +
//                "по 10 записей, с периодом в 20 мс)\n");
//        TaskTwo taskTwo = new TaskTwo();
//        for (int i = 0; i < 3; i++) {
//            Thread t4 = new Thread(() -> {
//                taskTwo.writeByLines();
//            }, "тред №" + i);
//            t4.start();
//        }
//        System.out.println("Написать класс МФУ на котором возможны одновременная печать и сканирование\n" +
//                "документов, при этом нельзя одновременно печатать два документа или сканировать (при\n" +
//                "печати в консоль выводится сообщения \"отпечатано 1, 2, 3,... страницы\", при сканировании то\n" +
//                "же самое только \"отсканировано...\", вывод в консоль все также с периодом 50 мс\n");
//        TaskThree taskThree = new TaskThree();
//        taskThree.thread1.start();
//        taskThree.thread2.start();
//        taskThree.thread3.start();
//        taskThree.thread4.start();
    }
}
